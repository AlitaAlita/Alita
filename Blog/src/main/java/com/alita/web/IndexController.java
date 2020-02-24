package com.alita.web;

import com.alita.service.BlogServiceImpl;
import com.alita.service.TagServiceImpl;
import com.alita.service.TypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



/**
 * @Author: Alita 1650810671@qq.com
 * @Description:
 * @Date: Created in 19:56 2020/2/13
 * @Modified By:
 */
@Controller
public class IndexController {

    @Autowired
    private TypeServiceImpl typeService;
    @Autowired
    private TagServiceImpl tagService;

    @Autowired
    private BlogServiceImpl blogService;

    @GetMapping("/")
    public String index(@PageableDefault(size=8,sort={"updateTime"},direction = Sort.Direction.DESC) Pageable pageable, Model model) {
        model.addAttribute("page",blogService.listBlog(pageable));
        model.addAttribute("types",typeService.listTypeTop(6));
        model.addAttribute("tags",typeService.listTypeTop(10));
        model.addAttribute("recommend",blogService.listRecommendBlogTop(8));
        return "/index";
    }
}
