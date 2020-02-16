package com.alita.dao;

import com.alita.po.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Alita 1650810671@qq.com
 * @Description:
 * @Date: Created in 13:08 2020/2/16
 * @Modified By:
 */
public interface BlogRepository extends JpaRepository<Blog,Long> {}