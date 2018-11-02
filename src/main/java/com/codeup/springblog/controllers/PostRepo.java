package com.codeup.springblog.controllers;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends CrudRepository<Post, Long> {
    //select * from ads where title like '%X%' or description like '%Y%';
    List<Post> findAllByTitleContainsOrBodyContains(String str,String str2);

//    Allows use to search for something in the title or body of the posts
    @Query("from Ad where title like %?1% or body like %?1%")
    List<Post> searchByTitleOrDesc(String term);
}
