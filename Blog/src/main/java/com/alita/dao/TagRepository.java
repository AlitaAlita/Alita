package com.alita.dao;

import com.alita.po.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag,Long> {
    public Tag findByName(String name);
}
