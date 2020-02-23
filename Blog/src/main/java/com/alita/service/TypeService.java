package com.alita.service;

import com.alita.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TypeService {

    public Type saveType(Type type);

    public Type getType(Long id);

    public Type getTypeByName(String name);

    public Page<Type> listType(Pageable pageable);
    List<Type> listType();

    public Type updateType(Long id,Type type);

    public void deleteType(Long id);

    public List<Type> listTypeTop(Integer size);
}