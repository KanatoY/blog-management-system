package com.example.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blog.entity.Blog;
import com.example.blog.repository.BlogMapper;

@Service                             /**サービスクラスであることを示すアノテーション*/
public class BlogService {           /**ブログのビジネスロジックを担当するクラス*/

    @Autowired                       /**BlogMapperを自動で注入するアノテーション*/
    private BlogMapper blogMapper;   /**ブログのデータアクセスを担当するBlogMapper*/
    
    public List<Blog> list() {       /**すべてのブログを取得するメソッド*/
        return blogMapper.findAll(); /**BlogMapperのfindAllメソッドを呼び出してブログのリストを返す*/
    }
}
