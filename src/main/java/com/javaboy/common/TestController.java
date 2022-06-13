package com.javaboy.common;

import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;

/**
 * @author yayu
 * @title: TestController
 * @description:   干掉swagger
 * @date 2021/2/19 9:57
 */
public class TestController {
    public static void main(String[] args) {
        DocsConfig config = new DocsConfig();
        // 项目根目录
        config.setProjectPath("p:\\learnProject\\common");
        // 项目名称
        config.setProjectName("common");
        // 声明该API的版本
        config.setApiVersion("V1.0");
        // 生成API 文档所在目录
        config.setDocsPath("G:\\test");
        config.addJavaSrcPath("P:\\learnProject\\common\\src\\main\\java");
        // 配置自动生成
        config.setAutoGenerate(Boolean.TRUE);
        // 执行生成文档
        Docs.buildHtmlDocs(config);

    }
}
