package com.alita.dao;

import com.alita.po.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
/**
 * @Author: Alita 1650810671@qq.com
 * @Description:
 * @Date: Created in 16:23 2020/2/26
 * @Modified By:
 */

public interface CommentRepository extends JpaRepository<Comment,Long>{


    List<Comment> findByBlogIdAndParentCommentNull(Long blogId, Sort sort);
}
