package com.study.generator.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.plugin.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Properties;

/**
 * 测试学习Mybtais的拦截器
 */
@Intercepts({@Signature(type = Executor.class, method = "commit", args = {boolean.class})})
public class TestInterceptor implements Interceptor {
    private static Logger logger= LoggerFactory.getLogger(TestInterceptor.class);
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object target = invocation.getTarget();
        logger.info(String.valueOf(target));
        Method method = invocation.getMethod();
        logger.info(method.getName());
        Object[] args = invocation.getArgs();
        Arrays.asList(args).forEach(System.out::println);
        Object proceed = invocation.proceed();
        logger.info(String.valueOf(proceed));
        return null;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {
        String property = properties.getProperty("test");
        logger.info(property);
    }
}
