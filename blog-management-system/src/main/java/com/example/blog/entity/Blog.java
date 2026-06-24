package com.example.blog.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity              /**エンティティクラスであることを示すアノテーション*/
public class Blog {  /**ブログエンティティクラス*/
    
    @Id                       /**エンティティの主キーを示すアノテーション*/
    private Integer id;           /** ブログのID */
    private String title;     /** ブログのタイトル */
    private String content;   /** ブログの内容 */
    private LocalDateTime createdAt;   /** 作成日時 */
    private LocalDateTime updatedAt;   /** 更新日時 */
    private LocalDateTime deletedAt;   /** 削除日時 */
   
    /** getter/setterメソッド */

    /** ブログのIDを取得する */
    public Integer getId(){
        return id;
    }
    /** ブログのIDを設定する */
    public void setId(Integer id){
        this.id = id;
    }
    
    /** ブログのタイトルを取得する */
    public String getTitle(){
        return title;
    }
    /** ブログのタイトルを設定する */
    public void setTitle(String title){
        this.title = title;
    }

    /** ブログの内容を取得する */
    public String getContent(){
        return content;
    }
    /** ブログの内容を設定する */
    public void setContent(String content){
        this.content = content;
    }

    /** 作成日時を取得する */
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    /** 作成日時を設定する */
    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt = createdAt;
    }

    /** 更新日時を取得する */
    public LocalDateTime getUpdatedAt(){
        return updatedAt;
    }
    /** 更新日時を設定する */
    public void setUpdatedAt(LocalDateTime updatedAt){
        this.updatedAt = updatedAt;
    }

    /** 削除日時を取得する */
    public LocalDateTime getDeletedAt(){
        return deletedAt;
    }
    /** 削除日時を設定する */
    public void setDeletedAt(LocalDateTime deletedAt){
        this.deletedAt = deletedAt;
    }










}
