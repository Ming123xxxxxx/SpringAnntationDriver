package com.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/12/26 12:24
 */
//Spring的容器不扫描controller
@ComponentScan(value = "com",excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
})
public class RootConfig {
}
