package com.whzl.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.whzl.common.interceptor.AuthorizationInterceptor;
import com.whzl.modules.person.resolver.LoginPersonHandlerMethodArgumentResolver;

/**
 * MVC配置
 *
  * @author xuchao
 * @email 1009470059@qq.com
 * @date 2019-01-26 10:33
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private AuthorizationInterceptor authorizationInterceptor;
    @Autowired
    private LoginPersonHandlerMethodArgumentResolver loginUserHandlerMethodArgumentResolver;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorizationInterceptor)
        		.addPathPatterns("/app/**")
        		.addPathPatterns("/person/**");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(loginUserHandlerMethodArgumentResolver);
    }
}