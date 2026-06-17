package com.example.blog.form;

public class BlogForm {       // ブログのフォームクラス

    private String title;     // ブログのタイトル
    private String content;   // ブログの内容     

    public String getTitle() {               // ブログのタイトルを取得する */
        return title;
    }

    public void setTitle(String title) {     // ブログのタイトルを設定する */
        this.title = title;
    }

    public String getContent() {             // ブログの内容を取得する */
        return content;
    }

    public void setContent(String content) { // ブログの内容を設定する */
        this.content = content;  
    }

}