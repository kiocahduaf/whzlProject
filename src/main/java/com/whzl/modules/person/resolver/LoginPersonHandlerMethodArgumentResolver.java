package com.whzl.modules.person.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.whzl.common.annotation.LoginUser;
import com.whzl.common.interceptor.AuthorizationInterceptor;
import com.whzl.modules.person.entity.PersonEntity;
import com.whzl.modules.person.service.PersonService;

/**
 * 有@LoginUser注解的方法参数，注入当前登录用户
 * @author xuchao
 * @email 1009470059@qq.com
 * @date 2019-01-26 10:33
 */
@Component
public class LoginPersonHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Autowired
    private PersonService personService;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(PersonEntity.class) && parameter.hasParameterAnnotation(LoginUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer container,
                                  NativeWebRequest request, WebDataBinderFactory factory) throws Exception {
        //获取用户ID
        Object object = request.getAttribute(AuthorizationInterceptor.USER_KEY, RequestAttributes.SCOPE_REQUEST);
        if(object == null){
            return null;
        }

        //获取用户信息
        PersonEntity user = personService.selectById((Long)object);

        return user;
    }
}
