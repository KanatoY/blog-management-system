package com.example.blog.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BlogMapper {

@Select("""
    
    select *
    from blog
    WHERE id = #{id}
    AND deleted_at is null

        """)
List<Blog>findAll();


@Select("""

    select *
    from blog
    WHERE id = #{id}
    AND deleted_at is null
    
        """)
Blog findByld(int id);


@Insert("""

    insert into blog (title, content)
    values (#{titke, #{content})
        
        """)
void save(Blog blog);


@Update("""

    UPDATE blog
    SET title = #{title},
      content = #{content},
   updated_at = current_timestamp
   WHERE id = #{id}
   AND deleted_at is null

        """)
void update(Blog blog);


@Update("""
        
    UPDATE blog
    SET deleted_at = current_timestamp
    WHERE id = #{id}
    
        """)
void delete(int id);

}