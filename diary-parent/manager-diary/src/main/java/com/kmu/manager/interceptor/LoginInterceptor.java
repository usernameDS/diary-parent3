package com.kmu.manager.interceptor;

import com.kmu.manager.entity.Manager;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @作者：Deng 时间：2020/8/19 9:42
 * 拦截器：请求前
 *；拦截请求对象
 */
public class LoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession  session = request.getSession();
      Manager manager = (Manager) session.getAttribute("manager");
        if (manager !=null){
            return true;
        }else {
            response.sendRedirect(request.getContextPath()+"/login.html");
            return false;
        }
    }
}



