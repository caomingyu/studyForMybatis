package com.study.mybatis;

import com.study.generator.mapper.SysRoleMapper;
import com.study.generator.mapper.SysUserMapper;
import com.study.mybatis.mapper.RoleMapper;
import com.study.mybatis.mapper.UserMapper;
import com.study.mybatis.model.SysRole;
import com.study.mybatis.model.SysUser;
import com.study.mybatis.proxy.MyMapperProxy;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StopWatch;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Proxy;
import java.sql.SQLException;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class MybatisApplicationTests {

    private SqlSessionFactory sqlSessionFactory;
    private static Logger logger = LoggerFactory.getLogger(MybatisApplicationTests.class);

    @Before
    public void init() throws IOException {
        System.out.println("测试前准备");
        Reader reader = Resources.getResourceAsReader("mybatis.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        reader.close();
    }

    @Test
    void contextLoads() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        reader.close();

        SqlSession sqlSession = sqlSessionFactory.openSession();

//        int i = sqlSession.insert("insertOne", new com.study.mybatis.model.Test(null, "cmy01"));
//        System.out.println(i);
        List<com.study.mybatis.model.Test> testList = sqlSession.selectList("mapper.TestMapper.selectAll");
        testList.forEach(System.out::println);
        System.out.println("-----------------");
//        List<SysUser> sysUserList = sqlSession.selectList("com.study.mybatis.mapper.UserMapper.selectAll");
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<SysUser> sysUserList = mapper.selectAll();
        sysUserList.forEach(System.out::println);
        System.out.println("-----------------");
        SysUser sysUser = mapper.selectById(1L);
        System.out.println(sysUser);
        System.out.println("-----------------");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        List<SysRole> roleList = roleMapper.selectAll();
        stopWatch.stop();
        roleList.forEach(System.out::println);
        System.out.println(stopWatch.getLastTaskTimeMillis() + "ms");
        SysUser user = new SysUser(null, "cmy003", "123", "yyy@163.com", "简介", null, new Date());
        Long insertNum = mapper.insert(user);
        System.out.println(insertNum);
        System.out.println("id is:" + user.getId());
        System.out.println("-----------------");
        MyMapperProxy proxy = new MyMapperProxy(sqlSession, UserMapper.class);
        UserMapper userMapper = (UserMapper) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{UserMapper.class}, proxy);
        List<SysUser> user1 = userMapper.selectAll();
        System.out.println(user1);
        System.out.println("-----------------");
        SysRole sysRole = new SysRole(null, "测试用户", null, 1L, new Date(), null);
        Long key = roleMapper.insert(sysRole, "2");
        System.out.println("key is :" + key + "   id is:" + sysRole.getId());
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    void test2() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        reader.close();

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        List<SysUser> sysUsers = mapper.selectByParam("", null);
        stopWatch.stop();
        sysUsers.forEach(System.out::println);
        System.out.println("cust is " + stopWatch.getLastTaskTimeMillis() + "ms");
        System.out.println("-------------------------------");
        stopWatch.start();
        SysUser user1 = new SysUser(null, null, "", null, null, null, null);
        List<SysUser> sysUsers1 = mapper.selectByIdOrUserName(user1);
        stopWatch.stop();
        sysUsers1.forEach(System.out::println);
        System.out.println("cust is " + stopWatch.getLastTaskTimeMillis() + "ms");
        System.out.println("-------------------------------");
        stopWatch.start();
        List<Long> ids = Arrays.asList(1L, 2L, 3L);
        List<SysUser> sysUsers2 = mapper.selectByIds(ids);
        stopWatch.stop();
        sysUsers2.forEach(System.out::println);
        System.out.println("cust is " + stopWatch.getLastTaskTimeMillis() + "ms");
        System.out.println("-------------------------------");
    }

    @Test
    void test3() throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;
        InputStream is = Resources.getResourceAsStream("generator/generatorConfig_test.xml");
//        InputStream is = MybatisApplicationTests.class.getResourceAsStream("generator/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration configuration = cp.parseConfiguration(is);
        is.close();
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration, callback, warnings);

        myBatisGenerator.generate(null);

        warnings.forEach(System.out::println);
    }

    @Test
    void test4() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        SysUserMapper mapper = sqlSession.getMapper(SysUserMapper.class);
//        List<com.study.generator.model.SysUser> sysUsers = mapper.selectAllWithRole();
//        sysUsers.forEach(System.out::println);
//        List<com.study.generator.model.SysUser> sysUsers = mapper.selectAllById();
//        sysUsers.forEach(System.out::println);
        com.study.generator.model.SysUser sysUser = new com.study.generator.model.SysUser();
//        sysUser.setId(1L);
        sysUser.setUserName("cmy");
        Map<String, Object> map = new HashMap<>(3);
        map.put("_offset", 1);
        map.put("_limit", 1);
        map.put("userName", "cmy");
//        mapper.selectOneById(sysUser);
        List<com.study.generator.model.SysUser> sysUsers = mapper.selectByPage(map);
        sysUsers.forEach(System.out::println);
    }

    @Test
    void test5() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        SysRoleMapper roleMapper = sqlSession.getMapper(SysRoleMapper.class);
        com.study.generator.model.SysRole role1 = roleMapper.selectWithPrivilege(1L);

        role1.setRoleName("admintest");
        com.study.generator.model.SysRole role2 = roleMapper.selectWithPrivilege(1L);
        Assert.assertEquals("admintest", role2.getRoleName());
        Assert.assertEquals(role1, role2);
        sqlSession.close();
        System.out.println("获取新的SqlSession");
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SysRoleMapper mapper = sqlSession1.getMapper(SysRoleMapper.class);
        com.study.generator.model.SysRole role = mapper.selectWithPrivilege(1L);
        Assert.assertEquals("admintest", role.getRoleName());
        Assert.assertNotEquals(role1, role);

        com.study.generator.model.SysRole role3 = mapper.selectWithPrivilege(1L);
        Assert.assertNotEquals(role, role3);
    }


    @Test
    void test6() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        SysUserMapper userMapper = sqlSession.getMapper(SysUserMapper.class);
        List<com.study.generator.model.SysUser> userList = userMapper.selectAllById();
        userList.forEach(System.out::println);
        sqlSession.close();

        logger.info("开启新SqlSession1");
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SysRoleMapper roleMapper = sqlSession1.getMapper(SysRoleMapper.class);
        com.study.generator.model.SysRole role = new com.study.generator.model.SysRole();
        role.setId(1L);
        role.setRoleName("admin_test2");
        int i = roleMapper.updateByPrimaryKey(role);
        logger.info(1 == i ? "成功更新" : "更新失败");
        sqlSession1.commit();
        sqlSession1.close();
        logger.info("开启新SqlSession2");
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        SysUserMapper userMapper1 = sqlSession2.getMapper(SysUserMapper.class);
        List<com.study.generator.model.SysUser> userList1 = userMapper1.selectAllById();
        userList1.forEach(System.out::println);
        sqlSession2.close();
    }
}
