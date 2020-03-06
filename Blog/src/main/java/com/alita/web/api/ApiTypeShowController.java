package com.alita.web.api;
import com.alita.model.JsonResult;
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

    //    @GetMapping("/types/{id}")
//    public String types(@PageableDefault(size = 8, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
//                        @PathVariable Long id, Model model) {
//        List<Type> types = typeService.listTypeTop(10000);
//        if (id == -1) {
//            id = types.get(0).getId();
//        }
//        BlogQuery blogQuery = new BlogQuery();
//        blogQuery.setTypeId(id);
//        model.addAttribute("types", types);
//        model.addAttribute("page", blogService.listBlog(pageable, blogQuery));
//        model.addAttribute("activeTypeId", id);
//        return "types";
//    }
//}
//    @GetMapping("/types")
//    public JsonResult types(@PageableDefault(size = 8, direction = Sort.Direction.DESC) Pageable pageable
//            , HttpServletResponse response) {
//        response.setBufferSize(1024000);
//        Page<Type> Types = typeService.listType(pageable);
//
//        if (Types == null) {
//            return new JsonResult(200, "fail", Types);
//        }
//        return new JsonResult(200, "success", Types);
//    }
    @Autowired
    private TagService tagService;


    @GetMapping("/tags/{id}")
    public JsonResult tags(@PageableDefault(size = 8,direction = Sort.Direction.DESC) Pageable pageable,
                       @PathVariable Long id, Model model,HttpServletResponse response) {
        response.setBufferSize(1024000);
        List<Tag> tags = tagService.listTagTop(10000);
        if (id == -1) {
            id = tags.get(0).getId();
        }
//        model.addAttribute("tags", tags);
//        model.addAttribute("page", blogService.listBlog(id,pageable));
//        model.addAttribute("activeTagId", id);
        if (tags == null) {
            return new JsonResult(200, "fail", tags);
        }
        return new JsonResult(200, "success",tags);
    }

    @GetMapping("/types/{id}")
    public JsonResult types(@PageableDefault(size = 8, direction = Sort.Direction.DESC) Pageable pageable,
                            @PathVariable Long id, Model model,HttpServletResponse response) {
        response.setBufferSize(1024000);
        List<Type> types = typeService.listTypeTop(10000);
        if (id == -1) {
            id = types.get(0).getId();
        }
//        BlogQuery blogQuery = new BlogQuery();
//        blogQuery.setTypeId(id);
//        model.addAttribute("types", types);
//        model.addAttribute("page", blogService.listBlog(pageable, blogQuery));
//        model.addAttribute("activeTypeId", id);
        if (types == null) {
            return new JsonResult(200, "fail", types);
        }
        return new JsonResult(200, "success",types);
    }
}