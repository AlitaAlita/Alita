package com.alita.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: Alita 1650810671@qq.com
 * @Description:
 * @Date: Created in 19:56 2020/2/13
 * @Modified By:
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String index()
    {
        int i=4/0;
        return "index";
    }
}