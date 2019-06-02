package com.allen.training.mybatis;

import com.allen.training.mybatis.mapper.BlogMapper;
import com.allen.training.mybatis.pojo.Blog;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

@Slf4j //add plugin lombok
public class BlogMybatisXMLStart {

    private static final String resource = "conf/mybatis-config.xml";
    public static void main(String[] args) throws IOException {
//        deleteBlog();
//        updateBlog();
        getBlog(1);
//        addBlog();
    }

    public static void addBlog() {
        try(InputStream inputStream = Resources.getResourceAsStream(resource);){
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            try (SqlSession session = sessionFactory.openSession();) {
                BlogMapper mapper = session.getMapper(BlogMapper.class);
                Blog blog = new Blog(3, "sky");
                mapper.insertBlog(blog);
                session.commit();
                log.info("Blog: "+blog.getSid()+", "+ blog.getSname()+"have been added .");
            }
        }catch (Exception e) {
            log.info("got exception" + e.getMessage());
        }
    }

    public static void updateBlog() {
        try(InputStream inputStream = Resources.getResourceAsStream(resource);){
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            try (SqlSession session = sessionFactory.openSession();) {
                BlogMapper mapper = session.getMapper(BlogMapper.class);
                int sid = 1;
                String newName="Fiona";
                Blog nblog = new Blog(1,"Fiona");
                Blog blog = getBlog(sid);
                mapper.updateBlog(nblog);
                session.commit();
                log.info("Blog: "+blog.getSid()+", "+ blog.getSname()+"have been changed to " + newName);
            }
        }catch (Exception e) {
            log.info("got exception" + e.getMessage());
        }
    }

    public static void deleteBlog() {
        try(InputStream inputStream = Resources.getResourceAsStream(resource);){
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            try (SqlSession session = sessionFactory.openSession();) {
                BlogMapper mapper = session.getMapper(BlogMapper.class);
                int sid = 3;
                Blog blog = getBlog(sid);
                mapper.deleteBlog(sid);
                session.commit();
                log.info("Blog: "+blog.getSid()+", "+ blog.getSname()+"have been deleted .");
            }
        }catch (Exception e) {
            log.info("got exception" + e.getMessage());
        }
    }

    public static Blog getBlog(int sid) {
        try(InputStream inputStream = Resources.getResourceAsStream(resource);){
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            try (SqlSession session = sessionFactory.openSession();) {
                BlogMapper mapper = session.getMapper(BlogMapper.class);
                Blog blog = mapper.getBlogById(sid);
                session.commit();
                log.info("Get Blog: "+blog.getSid()+", "+ blog.getSname());
                return blog;
            }
        }catch (Exception e) {
            log.info("got exception" + e.getMessage());
        }
        return null;
    }

}
