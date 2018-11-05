package com.codeup.springblog.services;

import com.codeup.springblog.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends CrudRepository<Post, Long> {
//    //select * from ads where title like '%X%' or description like '%Y%';
//    List<Post> findAllByTitleContainsOrBodyContains(String str,String str2);
//
////    Allows use to search for something in the title or body of the posts
//    @Query("from posts where title like %?1% or body like %?1%")
//    List<Post> searchByTitleOrDesc(String term);
}
