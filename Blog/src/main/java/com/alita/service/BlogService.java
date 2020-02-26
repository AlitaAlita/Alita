package com.alita.service;

import com.alita.po.Blog;
import com.alita.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author: Alita 1650810671@qq.com
 * @Description:
 * @Date: Created in 21:08 2020/2/15
 * @Modified By:
 */
public interface BlogService {
    Blog getBlog(Long id);
    Blog getAndConvert(Long id);
    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);
    Page<Blog> listBlog(Pageable pageable);
    Blog saveBlog(Blog blog);
    Blog updateBlog(Long id,Blog blog);
    void deleteBlog(Long id);
    public List<Blog> listRecommendBlogTop(Integer size);
}
