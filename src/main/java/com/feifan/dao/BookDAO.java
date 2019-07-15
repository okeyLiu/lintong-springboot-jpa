package com.feifan.dao;

import com.feifan.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


//JPA
@Repository
public interface BookDAO extends JpaRepository<Book,Integer> {

    /*
    select * from xxx where name=?1 and publisher=?2
    ?1 -> name
    ?2 -> publisher
     */
    Book findByNameAndPublisher(String name,String publisher);

    /*
    select * from xxx where name like ?1 and publisher like ?2
    ?1 -> name
    ?2 -> publisher
     */
    Book findByNameLikeAndPublisherLike(String name,String publisher);


    /*
    select * from xxx where detail is null
     */
    List<Book> findByDetailIsNull();

}
