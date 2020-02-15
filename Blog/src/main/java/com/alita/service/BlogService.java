package com.alita.service;

import com.alita.po.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Author: Alita 1650810671@qq.com
 * @Description:
 * @Date: Created in 21:08 2020/2/15
 * @Modified By:
 */
public interface BlogService {
    Blog getBlog(Long id);
    Page<Blog> listBlog(Pageable pageable,Blog blog);
    Blog save(Blog blog);
    Blog updateBlog(Long id,Blog blog);
    void deleteBlog(Long id);
}
