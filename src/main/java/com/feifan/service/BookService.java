package com.feifan.service;

import com.feifan.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    /**
     * 获取所有book
     * @return
     */
    List<Book> findAll();

    /**
     * 获取一个
     * @param id
     * @return
     */
    Optional<Book> findById(Integer id);

    /**
     * 保存一本书
     * @param bk
     * @return
     */
    boolean save(Book bk);
}
