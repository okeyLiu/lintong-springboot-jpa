package com.feifan;

import com.feifan.dao.BookDAO;
import com.feifan.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LintongSpringbootJpaApplicationTests {

    @Autowired
    private BookDAO bookDAO;

    @Test
    public void diyQuery1() {
        Book bk = bookDAO.findByNameAndPublisher("《十万个为什么》", "新华出版社");
        System.out.println(bk);
    }

    @Test
    public void diyQuery2() {
        Book bk = bookDAO.findByNameLikeAndPublisherLike("%十万%", "%出版社%");
        System.out.println(bk);
    }


    @Test
    public void diyQuery3() {
        List<Book> byDetailIsNull = bookDAO.findByDetailIsNull();
        System.out.println(byDetailIsNull);
    }

    /*
    是修改还是插入是根据是否能找到id对应记录
    如果找到，就是修改
    如果找不到，就是插入
     */
    @Test
    public void useUpdateOrInsert() {
        Book bk = new Book();
        bk.setName("《大话-十万个2》");
        //bk.setId(1002);
        bookDAO.save(bk);
    }


}
