DROP TABLE IF EXISTS blogs CASCADE;

CREATE TABLE blogs (  /*ブログ記事を管理するテーブル*/

    id SERIAL PRIMARY KEY,                                      /*IDは自動で増加する整数型の主キー*/
    title VARCHAR(255) NOT NULL CHECK(length(trim(title)) > 0), /*タイトルは必須で、空文字を許可しない*/
    content TEXT NOT NULL CHECK(length(trim(content)) > 0),     /*内容は必須で、空文字を許可しない*/
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,              /*作成日時をデフォルトで現在時刻に設定*/  
    updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,              /*更新日時をデフォルトで現在時刻に設定*/
    deletedAt TIMESTAMP,                                        /*削除日時を管理するカラム（論理削除）*/
   
);