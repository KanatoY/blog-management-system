package com.example.blog.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.blog.entity.Blog;
import com.example.blog.form.BlogForm;
import com.example.blog.repository.BlogMapper;
import lombok.RequiredArgsConstructor;

@Service                   /* Springのサービスクラスであることを示すアノテーション */
@RequiredArgsConstructor   /* Lombokのアノテーションで、finalなフィールドを持つクラスのコンストラクタを自動生成する */
public class BlogService { /* ブログのビジネスロジックを担当するサービスクラス */

    private final BlogMapper blogMapper; /** ブログのデータアクセスを担当するBlogMapper */

    public List<Blog> list() {           /* ブログの一覧を取得するメソッド */
        return blogMapper.findAll();     /* ブログの一覧を取得する */
    }

    public void create(BlogForm blogForm) {      /* ブログを作成するメソッド */
        Blog blog = new Blog();                  /* 新しいブログのインスタンスを作成する */
        blog.setTitle(blogForm.getTitle());      /* ブログのタイトルを設定する */
        blog.setContent(blogForm.getContent());  /* ブログの内容を設定する */
        blogMapper.save(blog);
    }

    public Blog detail(int id) {         /* ブログの詳細情報を取得するメソッド */
        return blogMapper.findById(id);  /* ブログの詳細情報を取得する */
    }
}