package com.itheima.test;

import com.itheima.po.Customer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    //id查询
    @Test
    public  void fCByIdTest() throws Exception{
        String re="mybatis-config.xml";
        InputStream inputStream= Resources.getResourceAsStream(re);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        Customer customer=sqlSession.selectOne("fCById",2);
        System.out.println(customer);
        sqlSession.close();
    }
    //模糊查询
    @Test
    public  void fCByNameTest() throws Exception{
        String resource="mybatis-config.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        List<Customer> customer=sqlSession.selectList("fCByName","j");
        System.out.println(customer);
        sqlSession.close();
    }
    //添加
    @Test
    public  void addCTest() throws Exception{
        String resource="mybatis-config.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=
                new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        Customer customer=new Customer();
        customer.setUsername("zhy");
        customer.setJobs("student");
        customer.setPhone("12566878956");
        int rows=sqlSession.insert("addC",customer);
        if (rows>0){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    //修改
    @Test
    public  void upCTest() throws Exception{
        String resource="mybatis-config.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=
                new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        Customer customer=new Customer();
        customer.setId(2);
        customer.setUsername("hy");
        customer.setJobs("student");
        customer.setPhone("12566878956");
        int rows=sqlSession.insert("upC",customer);
        if (rows>0){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
        sqlSession.commit();
        sqlSession.close();
        sqlSession.close();
    }

    //删除
    @Test
    public  void deCTest() throws Exception{
        String resource="mybatis-config.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=
                new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        int rows=sqlSession.insert("deC",1);
        if (rows>0){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
