package com.study.mybatis.proxy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyMapperProxy<T> implements InvocationHandler {
    private SqlSession sqlSession;
    private Class<T> mapperInterface;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入代理的方法");
        List<T> objectList = sqlSession.selectList(mapperInterface.getCanonicalName() + "." + method.getName());
        System.out.println("方法执行结束");
        return objectList;
    }
}
