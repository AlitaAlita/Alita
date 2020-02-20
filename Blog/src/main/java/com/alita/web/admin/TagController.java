package com.alita.web.admin;

import com.alita.po.Tag;
import com.alita.service.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class TagController {

    @Autowired
    private TagServiceImpl tagService;

    @GetMapping("/tags")
    public String tags(@PageableDefault(size = 10, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable, Model model){
        model.addAttribute("page",tagService.listTag(pageable));
        return "admin/tags";
    }

    @GetMapping("/tags/input")
    public String input(Model model){
        model.addAttribute("tag",new Tag());
        return "admin/tag-input";
    }

    @PostMapping("/tags")
    public String save(@Valid Tag tag, BindingResult result, RedirectAttributes attributes){
        if(tagService.getTagByName(tag.getName()) !=null){
            result.rejectValue("name","nameError","分类名称已存在，请勿重复添加！");
        }
        if(result.hasErrors()){
            return "/admin/tag-input";
        }
        Tag t = tagService.saveTag(tag);
        if(t==null){
            attributes.addFlashAttribute("message","标签添加失败！" );
        }
        else{
            attributes.addFlashAttribute("message","标签添加成功！" );
        }
        return "redirect:/admin/tags";
    }

    @GetMapping("/tags/{id}/input")
    public String editUI(@PathVariable Long id,Model model){
        model.addAttribute("tag",tagService.getTag(id));
        return "/admin/tag-input";
    }

    @PostMapping("/tags/{id}")
    public String update(@PathVariable Long id,Tag tag,BindingResult result,RedirectAttributes attributes){
        if(tagService.getTagByName(tag.getName())!=null){
            result.rejectValue("name","nameError","该分类名称已存在，请勿重复添加！");

        }
        if(result.hasErrors()){
            return "/admin/tag-input";
        }
        Tag t = tagService.updateTag(id,tag);
        if(t==null){
            attributes.addFlashAttribute("message","更新操作失败！");

        }else{
            attributes.addFlashAttribute("message","更新操作成功！");
        }

        return "redirect:/admin/tags";

    }

    @GetMapping("tags/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
        tagService.deleteTag(id);
        attributes.addFlashAttribute("message","更新操作成功！");
        return "redirect:/admin/tags";
    }
}
