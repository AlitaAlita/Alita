package com.alita.service;

import com.alita.po.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TagService {

    public Tag saveTag(Tag tag);

    public Tag getTag(Long id);

    public Tag getTagByName(String name);

    public Page<Tag> listTag(Pageable pageable);

    public Tag updateTag(Long id,Tag tag);

    public void deleteTag(Long id);

    public List<Tag> listTagTop(Integer size);
}

