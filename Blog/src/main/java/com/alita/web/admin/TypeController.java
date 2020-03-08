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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeServiceImpl typeService;

    private int count;

    @GetMapping("/types")
    public String types(@PageableDefault(size = 10, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable, Model model){

        model.addAttribute("page",typeService.listType(pageable));
        return "admin/types";
    }

    @GetMapping("/types/input")
    public String input(Model model){
        model.addAttribute("type",new Type());
        return "admin/type-input";
    }

    @PostMapping("/types")
    public String save(@Valid Type type, BindingResult bindingResult, RedirectAttributes attributes){
        if(typeService.getTypeByName(type.getName()) !=null){
            bindingResult.rejectValue("name","nameErrors","改分类已存在，请勿重复添加！");
        }
        if(bindingResult.hasErrors()){
            return "/admin/type-input";
        }
        Type t=typeService.saveType(type);
        
        if(t==null){
            attributes.addFlashAttribute("message","分类添加失败！" );
        }else{
            attributes.addFlashAttribute("message","分类添加成功！" );
        }
        return "redirect:/admin/types";
    }

    @GetMapping("types/{id}/input")
    public String editUI(@PathVariable Long id, Model model){
        model.addAttribute("type",typeService.getType(id));
        return "/admin/type-input";
    }

    @PostMapping("/types/{id}")
    public String editType(@PathVariable  Long id,Type type,BindingResult bindingResult,RedirectAttributes attributes){
        if(typeService.getTypeByName(type.getName()) !=null){
            bindingResult.rejectValue("name","nameErrors","改分类已存在，请勿重复添加！");
        }
        if(bindingResult.hasErrors()){
            return "/admin/type-input";
        }
        Type t=typeService.updateType(id,type);

        if(t==null){
            attributes.addFlashAttribute("message","分类更新失败！" );
        }else{
            attributes.addFlashAttribute("message","分类更新成功！" );
        }
        return "redirect:/admin/types";
    }

    @GetMapping("types/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
        typeService.deleteType(id);
        attributes.addFlashAttribute("message","分类更新成功！" );
        return "redirect:/admin/types";
    }


}
