package com.alita.web.api;
import com.alita.model.JsonResult;
import com.alita.po.Blog;
import com.alita.po.Tag;
import com.alita.po.Type;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;;

@Controller
@RestController
@RequestMapping("/api")
public class ApiTypeShowController {
    @Autowired
    private TypeService typeService;

    @Autowired
    private BlogService blogService;


    @GetMapping("/types")
    public JsonResult types(@PageableDefault(size = 8, direction = Sort.Direction.DESC) Pageable pageable
            , HttpServletResponse response) {
        response.setBufferSize(1024000);
        Page<Type> Types = typeService.listType(pageable);

        if (Types == null) {
            return new JsonResult(200, "fail", Types);
        }
        return new JsonResult(200, "success", Types);
    }


    @GetMapping("/types/{id}")
    public JsonResult types(@PageableDefault(size = 8, direction = Sort.Direction.DESC) Pageable pageable,
                            @PathVariable Long id, Model model, HttpServletResponse response) {
        response.setBufferSize(1024000);
        BlogQuery blogQuery = new BlogQuery();
        blogQuery.setTypeId(id);
        Page<Blog> blog = blogService.listBlog(pageable, blogQuery);
        if (blog == null) {
            return new JsonResult(200, "fail", blog);
        }
        return new JsonResult(200, "success", blog);
    }
}


