package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制器
 *
 * @RequestMapping("/") 和 @RequestMapping 是有区别的
 * 如果不写参数，则为全局默认页，加入输入404页面，也会自动访问到这个页面。
 * 如果加了参数“/”，则只认为是根页面。
 */
@RestController
@RequestMapping
public class DefaultController {

    @RequestMapping
    public String hello() {
        return "Hello World";
    }
}
