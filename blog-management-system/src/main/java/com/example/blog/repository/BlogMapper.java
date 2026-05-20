package com.example.blog.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.blog.entity.Blog;

@Mapper                     /**MyBatisのMapperインターフェースであることを示すアノテーション*/
public interface BlogMapper /**ブログのデータアクセスを定義するインターフェース*/
{  

    List<Blog> findAll();   /**すべてのブログを取得するメソッド*/
    Blog findById(int id);  /**IDでブログを取得するメソッド*/
    void save(Blog blog);   /**ブログを保存するメソッド*/
    void update(Blog blog); /**ブログを更新するメソッド*/
    void delete(int id);    /**IDでブログを削除するメソッド*/

}   