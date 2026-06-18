package com.example.blog.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.blog.entity.Blog;
import com.example.blog.form.BlogForm;
import com.example.blog.service.BlogService;

import lombok.RequiredArgsConstructor;

@Controller                    /** Springのコントローラークラスであることを示すアノテーション */
@RequestMapping("/blogs")      /** このコントローラーが処理するリクエストのパスを指定するアノテーション */
@RequiredArgsConstructor       /** Lombokのアノテーションで、finalなフィールドを持つクラスのコンストラクタを自動生成する */
public class BlogController {  /** ブログのコントローラークラス */

    private final BlogService blogService;  /** ブログのビジネスロジックを担当するBlogService */

    @GetMapping                                           /** HTTP GETリクエストを処理するメソッドであることを示すアノテーション */
    public String index(Model model) {                    /** ブログの一覧を表示するメソッド */
        List<Blog> blogs = blogService.list();            /** ブログの一覧を取得する */
        model.addAttribute("blogs", blogs); /** モデルにブログの一覧を追加する */
        return "blog/list";                                /** ブログの一覧を表示するビューの名前を返す */
    }

    @GetMapping("/new")                                       /** HTTP GETリクエストを処理するメソッドであることを示すアノテーション */
    public String newForm(@ModelAttribute BlogForm blogForm, Model model) { /** ブログの作成フォームを表示するメソッド */
        model.addAttribute("blog", new Blog());             /** モデルにブログの作成フォームを追加する */
        return "blog/form";                                   /** ブログの作成フォームを表示するビューの名前を返す */
    }

    @PostMapping                      
    public String create(@ModelAttribute BlogForm blogForm) { /** ブログの作成フォームから送信されたデータを保存するメソッド */
        blogService.create(blogForm);                       /** ブログの作成フォームから送信されたデータを保存する */
        return "redirect:/blogs";                           /** ブログの一覧ページにリダイレクトする */
    }

    @GetMapping("/{id}")                                      
    public String detail(@PathVariable int id, Model model) { /** ブログの詳細情報を表示するメソッド */ 
        Blog blog = blogService.detail(id);                   /** ブログの詳細情報を取得する */
        model.addAttribute("blog", blog);       /** モデルにブログの詳細情報を追加する */
        return "blog/detail";                                 /** ブログの詳細情報を表示するビューの名前を返す */
    }
}