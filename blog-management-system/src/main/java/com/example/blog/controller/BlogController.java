package com.example.blog.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.blog.entity.Blog;
import com.example.blog.service.BlogService;


@Controller                    /**コントローラークラスであることを示すアノテーション*/
public class BlogController {  /**ブログのリクエストを処理するクラス*/

    private final BlogService blogService;            /**ブログのビジネスロジックを担当するBlogService*/

    public BlogController(BlogService blogService) {  /**BlogServiceをコンストラクタで注入する*/
        this.blogService = blogService;               /**注入されたBlogServiceをフィールドにセットする*/
     }

@GetMapping("/blogs")                    
public String index(Model model){
       
        List<Blog> blogs = blogService.list();                /**BlogServiceのlistメソッドを呼び出してブログのリストを取得する*/
        model.addAttribute("blogs", blogs);    /**取得したブログのリストをモデルに追加する*/
        return "blog/list";                                  /**ブログのリストを表示するテンプレートの名前を返す*/

    }
}
