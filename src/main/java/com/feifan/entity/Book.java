package com.feifan.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter//getter方法
@Setter//setter方法
@AllArgsConstructor//全参构造器
@NoArgsConstructor//无参构造器
@ToString//toString方法
@EqualsAndHashCode//equals 和 hashcode方法

@Entity
@Table(name = "tb_jpa_books")
public class Book implements Serializable {
    /*
    id的策略
    IDENTITY-使用数据库的自动增长
    AUTO-新建一个表（hibernate_sequence），用来维护下一个id值（next_val）
    SEQUENCE-和AUTO类似
    TABLE-和AUTO类似，细节略微不同
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)//id integer auto_increment
    @Id//主键
    private Integer id;

    @Column(length = 32)
    private String name;
    @Column(length = 32)
    private String publisher;
    @Column(length = 255)
    private String detail;
}
