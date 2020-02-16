package com.alita.service;

import com.alita.NotFoundException;
import com.alita.dao.BlogRepository;
import com.alita.po.Blog;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @Author: Alita 1650810671@qq.com
 * @Description:
 * @Date: Created in 13:07 2020/2/16
 * @Modified By:
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Blog getBlog(Long id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public Page<Blog> listBlog(Pageable pageable, Blog blog) {
        return null;
    }

    @Override
    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public Blog updateBlog(Long id, Blog blog) {
        Blog b=blogRepository.findById(id).get();
        if(b==null)
        {
            throw new NotFoundException("not found this blog");
        }
        BeanUtils.copyProperties(blog,b);
        return blogRepository.save(b);
    }

    @Override
    public void deleteBlog(Long id) {
     blogRepository.deleteById(id);
    }
}
