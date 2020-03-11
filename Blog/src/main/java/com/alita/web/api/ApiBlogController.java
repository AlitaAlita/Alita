package com.alita.web.api;

import com.alita.model.JsonResult;
import com.alita.po.Blog;
import com.alita.po.User;
import com.alita.service.BlogService;
import com.alita.service.TagService;
import com.alita.service.TypeService;
import com.alita.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Alita 1650810671@qq.com
 * @Description:
 * @Date: Created in 10:35 2020/2/17
 * @Modified By:
 */
@Controller
@RestController
@RequestMapping("/api")
public class ApiBlogController {
    private static final String INPUT = "admin/blogs-input";
    private static final String LIST = "admin/blogs";
    private static final String REDIRECT_LIST = "redirect:/admin/blogs";
//
//    @GetMapping("/blogs")
//    public String list(){
//        return "admin/blogs";
//    }


    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @GetMapping("/blogs")
    public JsonResult blog(@PageableDefault(size=8,sort={"updateTime"},direction = Sort.Direction.DESC) Pageable pageable, HttpServletResponse response){
        response.setBufferSize(1024000);
        Page<Blog> blogs = blogService.listBlog(pageable);
        if(blogs == null){
            return new JsonResult(200,"fail");
        }
        return new JsonResult(200,"success",blogs);
    }

    @GetMapping("/blog/{id}")
    public JsonResult findBlogById(@PathVariable Long id) {
        Blog blog = blogService.getAndConvert(id);
        return new JsonResult(200,"success",blog);
    }

    @PostMapping("/search")
    public JsonResult search(@PageableDefault(size = 8, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                             @RequestParam String query) {
        System.out.println(query);
        Page<Blog> blogs = blogService.listBlog("%"+query+"%", pageable);
        return new JsonResult(200,"success",blogs);
    }

}
