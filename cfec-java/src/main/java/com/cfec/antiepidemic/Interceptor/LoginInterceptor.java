package com.cfec.antiepidemic.Interceptor;

import com.cfec.antiepidemic.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private HttpSession httpSession;

    //Controller逻辑执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        /**
         * HandlerMethod=>Controller中标注@RequestMapping的方法
         *  需要配置静态资源不拦截时，添加这块逻辑  => 前后端分离项目
         */
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        String token = request.getHeader("Authentication");

        if (!TokenUtil.verify(token)) {
            // 未登录跳转到登录界面
            throw new RuntimeException("no login!");
        } else {
            return true;
        }
    }

}