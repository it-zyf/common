package com.javaboy.common.discover;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyf
 * @date 2023/10/12 15:49
 */
public class ExcuteDiscover extends MyDiscoverAbstract {

    private final List<MyDiscover> myDiscovers = new ArrayList<>(2);


    //责任链模式,这里可以添加很多的处理方法,匹配到哪个方法就用哪个方法来执行.
    public ExcuteDiscover() {
        myDiscovers.add(new CommonDiscover());
        myDiscovers.add(new ChatDiscover());
    }

    @Override
    public String getTitle(String param) {
        for (MyDiscover myDiscover : myDiscovers) {
            return myDiscover.getTitle(param);
        }
        return null;
    }



}
