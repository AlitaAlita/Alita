package com.alita.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: Alita 1650810671@qq.com
 * @Description:
 * @Date: Created in 19:56 2020/2/13
 * @Modified By:
 */
@Controller
public class IndexController {
    @GetMapping("/{id}/{/name}")
    public String index(@PathVariable Integer id,@PathVariable String name)
    {
        //int i=4/0;
//        String blog=null;
//        if(blog == null)
//        {
//            throw new NotFoundException("blog not found");
//        }
        System.out.println("--------index-------");
        return "index";
    }
}
