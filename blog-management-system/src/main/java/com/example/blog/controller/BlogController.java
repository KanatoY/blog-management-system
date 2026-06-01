package com.example.blog.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.blog.entity.Blog;
import com.example.blog.service.BlogService;


@Controller                    /**コントローラークラスであることを示すアノテーション*/
public class BlogController {  /**ブログのリクエストを処理するクラス*/

private final BlogService blogService;             /**ブログのビジネスロジックを担当するBlogService*/

public BlogController(BlogService blogService) {   /**BlogServiceをコンストラクタで注入する*/
       
        this.blogService = blogService;            /**注入されたBlogServiceをフィールドにセットする*/
    
    }


@GetMapping("/blogs")                    
public String index(Model model){
       
        List<Blog> blogs = blogService.list();                 /**BlogServiceのlistメソッドを呼び出してブログのリストを取得する*/
        model.addAttribute("blogs", blogs);     /**取得したブログのリストをモデルに追加する*/
        return "blog/list";                                   /**ブログのリストを表示するテンプレートの名前を返す*/

    }


@org.springframework.web.bind.annotation.GetMapping("/blogs/new") /**新しいブログを作成するフォームを表示するメソッド*/
public String create(Model model) {                               /**モデルに新しいBlogFormを追加する*/
       
        model.addAttribute("blogForm", new com.example.blog.form.BlogForm()); /**新しいBlogFormをモデルに追加する*/
        return "blog/form";                                                                  /**ブログのフォームを表示するテンプレートの名前を返す*/

    }

   
@org.springframework.web.bind.annotation.PostMapping("/blogs") /**新しいブログを保存するメソッド*/
public String save(@org.springframework.web.bind.annotation.ModelAttribute com.example.blog.form.BlogForm blogForm, Model model) { /**BlogFormを引数として受け取る*/
      
        blogService.create(blogForm);                                            /**BlogServiceのcreateメソッドを呼び出して新しいブログを保存する*/
        java.util.List<com.example.blog.entity.Blog> blogs = blogService.list(); /**BlogServiceのlistメソッドを呼び出してブログのリストを取得する*/
        model.addAttribute("blogs", blogs);                        /**取得したブログのリストをモデルに追加する*/
        return "blog/list";                                                       /**ブログのリストを表示するテンプレートの名前を返す*/

    }

}
