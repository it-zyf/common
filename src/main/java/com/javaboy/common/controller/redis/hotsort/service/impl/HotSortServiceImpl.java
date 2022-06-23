package com.javaboy.common.controller.redis.hotsort.service.impl;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Maps;
import com.javaboy.common.api.ResponseMsg;
import com.javaboy.common.controller.redis.hotsort.dao.entity.MPost;
import com.javaboy.common.controller.redis.hotsort.dao.mapper.HotSortMapper;
import com.javaboy.common.controller.redis.hotsort.service.HotSortService;
import com.javaboy.common.controller.redis.utils.RedisUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 1.day:rank 设置文章id,评论数
 * 2.rank:post 缓存文章信息
 * 3.week:rank 对day:rank 进行合并排序
 * @author: zyf
 * @create: 2022-06-23 11:30
 **/
@Service
@RequiredArgsConstructor
public class HotSortServiceImpl  implements HotSortService {

    private  final HotSortMapper hotSortMapper;

    private final RedisUtil redisUtil;

    @Override
    public ResponseMsg<List<Map<String, Object>>> hotSort() {
       // 设置 key
        String key ="week:rank";
        //开始索引结束索引
        Set<ZSetOperations.TypedTuple> zSetRank = redisUtil.getZSetRank(key, 0, 6);
        List<Map<String, Object>> maps = new ArrayList<>();

        // 便利
        for (ZSetOperations.TypedTuple typedTuple : zSetRank) {
            // 创建 Map
            HashMap<String, Object> map = Maps.newHashMap();
            Object postId = typedTuple.getValue();
            String postHashKey = "rank:post:" +postId;
            map.put("id",postId);
            map.put("title",redisUtil.hget(postHashKey,"post:title"));
            map.put("commentCount",typedTuple.getScore());
            maps.add(map);
        }
        return new ResponseMsg<>(maps);
    }


    public void initHotData(){
        //获取 7天的文章
        List<MPost> posts = hotSortMapper.selectList(new QueryWrapper<MPost>().ge("created", DateUtil.lastWeek())
                .select("id", "title", "user_id", "comment_count", "view_count", "created")
        );// 获取到7天前的以及按照这几个查询，不需要全部查询
        // 初始化文章的总评论
        for (MPost post : posts) {
            // 设置 key
            String key = "day:rank:" + DateUtil.format(post.getCreated(), DatePattern.PURE_DATE_FORMAT);
            // 缓存进去的评论数量
            redisUtil.zSet(key, post.getId(), post.getCommentCount());
            //设置自动过期 7天过期
            long between = DateUtil.between(new Date(), post.getCreated(), DateUnit.DAY);
            // 有效 时间
            long expireTime = (7 - between) * 24 * 60 * 60;

            redisUtil.expire(key, expireTime);
            // 缓存文章的一些基本信息
            this.hashCachePost(post, expireTime);
        }
        // 做并集
        this.zunionAndStore();
    }


    /**
     * 文章每周评论数量并集操作
     **/
    private void zunionAndStore() {
        String destkey = "day:rank:" + DateUtil.format(new Date(), DatePattern.PURE_DATE_FORMAT);
        // 设置并集后的新的 key
        String newkey = "week:rank";
        ArrayList<String> otherKeys = new ArrayList<>();
        // 计算7天的
        for (int i = -6; i < 0; i++) {
            String temp = "day:rank:" + DateUtil.format(DateUtil.offsetDay(new Date(), i), DatePattern.PURE_DATE_FORMAT);
            otherKeys.add(temp);
        }
        redisUtil.zUnionAndStore(destkey, otherKeys, newkey);
    }

    /**
     * 文章作者缓存
     **/
    private void hashCachePost(MPost post, long expireTime) {
        // 设置 key
        String key = "rank:post:" + post.getId();
        // 判断存在不存在
        boolean hasKey = redisUtil.hasKey(key);
        if (!hasKey) {
            // 就存到缓存里面
            redisUtil.hset(key, "post:id", post.getId(), expireTime);
            redisUtil.hset(key, "post:title", post.getTitle(), expireTime);
            redisUtil.hset(key, "post:commentCount", post.getCommentCount(), expireTime);

        }
    }
}
