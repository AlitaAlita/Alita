package com.alita.service;

import com.alita.po.Comment;

import java.util.List;

/**
 * @Author: Alita 1650810671@qq.com
 * @Description:
 * @Date: Created in 16:21 2020/2/26
 * @Modified By:
 */
public interface CommentService {
    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);
}
