package com.feifan.controller;

import com.feifan.entity.Book;
import com.feifan.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
@CrossOrigin//开启跨域穿透，即其他服务器可以直接访问
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("")
    public List<Book> getAll(){
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book getOne(@PathVariable Integer id){
        Optional<Book> byId = bookService.findById(id);
        return byId.orElseGet(Book::new);
    }

    @PostMapping("")
    public Book save(){
        Book bk = new Book(1002,"《SpringBoot从入门到放弃》","飞凡教育","从0开始，重新启动！");
        boolean rs = bookService.save(bk);
        if(rs){
            return bk;
        }else{
            return null;
        }
    }

}
