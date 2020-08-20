package com.kmu.manager.filter;

import com.google.code.kaptcha.Constants;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @作者：Deng 时间：2020/8/19 20:19
 */
public class CodeFilter implements Filter{

    public void init(FilterConfig filterConfig) throws ServletException {

    }


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //ServletRequest转换成HttpServletRequest
        //ServletResponse转换成HttpServletResponse
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        //获取uri，就是获取你访问的路径，方便后面的判断
        String uri = req.getServletPath();

        //判断：如果是登录请求
        if (uri.equals("/login") && req.getMethod().equalsIgnoreCase("post")) {
            //进行验证码校验，session中的验证码和本次提交的验证码，进行比对

            String sessionCode = req.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY).toString();
            String formCode = req.getParameter("code").trim();

            if (StringUtils.isEmpty(formCode)) {
//                throw new RuntimeException("验证码不能为空");
                resp.sendRedirect("/login.html ?codeerror=error");
                return;
            }
            if (sessionCode.equalsIgnoreCase(formCode)) {
                System.out.println("验证通过");
                System.out.println(req.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY));
            }else{
//                //否则：
//                throw new AuthenticationServiceException("验证码错误");
                resp.sendRedirect("/login.html?codeerror=error");
                return;
            }

        }
        //如果上面的if条件不成立，则说明当前路径不是登录，不需要进行拦截
        chain.doFilter(request, response);

    }

    public void destroy() {

    }

}
