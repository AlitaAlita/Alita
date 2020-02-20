package com.alita.web;

import com.alita.po.Blog;
import com.alita.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Alita 1650810671@qq.com
 * @Description:
 * @Date: Created in 10:35 2020/2/17
 * @Modified By:
 */
@Controller
@RequestMapping("/admin")
public class BlogController {
    @Autowired
    private BlogService blogService;
@GetMapping("/blogs")
    public String blogs(@PageableDefault(size = 2,sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                        Blog blog, Model model)
{
    model.addAttribute("page",blogService.listBlog(pageable,blog));
    return "admin/blogs";
}
}
