package com.alita.web.admin;
import com.alita.po.Type;
import com.alita.service.TypeService;
import com.alita.service.TypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeServiceImpl typeService;

    @GetMapping("/types")
    public String types(@PageableDefault(size = 10, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable, Model model){

        model.addAttribute("page",typeService.listType(pageable));
        return "admin/types";
    }

    @GetMapping("/types/input")
    public String input(){

        return "admin/type-input";
    }

    @PostMapping("/save")
    public String save(Type type){
        Type t=typeService.saveType(type);
        if(t==null){

        }else{

        }
        return "redirect:admin/types";
    }


}
