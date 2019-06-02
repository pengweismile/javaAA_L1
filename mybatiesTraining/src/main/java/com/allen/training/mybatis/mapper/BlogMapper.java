package com.allen.training.mybatis.mapper;

import com.allen.training.mybatis.pojo.Blog;

public interface  BlogMapper {

    public void insertBlog(Blog blog);
    public Blog getBlogById(int sid);
    public void deleteBlog(int sid);
    public void updateBlog(Blog blog);

}
