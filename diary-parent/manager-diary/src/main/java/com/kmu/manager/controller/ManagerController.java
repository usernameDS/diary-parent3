package com.kmu.manager.controller;


import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

@Controller
public class ManagerController {


    @RequestMapping("/{path}.html")
    public String path(@PathVariable("path") String path) {
        return path;
    }

    @GetMapping("/login.html")
    public String toLogin(HttpServletRequest request, Model model) {
        if(request.getParameter("codeerror")!=null){
            model.addAttribute("error","验证码错误");
        }
        if (request.getParameter("login") != null) {
            model.addAttribute("error", "登录失败，请检查用户名密码是否正确！");
        }
        return "login";
    }

    @GetMapping("/logout.do")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login.html";
    }

    @GetMapping("/indexTwo.html")
    public String main(HttpSession session) {
        //从session中，将用户信息取出来，再放到modal中，转发到indexTwo.html，indexTwo.html就可以取到用户信息
        SecurityContextImpl spring_security_context = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
        UserDetails userDetails = (UserDetails) spring_security_context.getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        session.setAttribute("account", username);
        return "indexTwo";
    }

    //注入验证码生产者
    @Autowired
    Producer captchaProducer;

    //验证码生成
    @GetMapping("/kaptcha")
    public void getKaptchaImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        //设置响应头信息
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        //验证码生成
        String capText = captchaProducer.createText();
        System.out.println(capText);
        //向session中存入一份验证码
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
    }


//    @PostMapping("/login.do")
//    public String toLogin(String account, String password, HttpSession session, Model model) {
//        Manager manager = managerService.login(account, password);
//        if (manager != null) {
//            session.setAttribute("manager", manager);
//            return "redirect:/indexTwo.html";
//        } else {
//            //登录失败
//            String msg = "登录失败，请检查账号密码是否正确！";
//            ResultEntity resultEntity = ResultEntity.failedWithData("登录失败，请检查账号密码是否正确！", null);
//            model.addAttribute("resultEntity", resultEntity);
//            return "login";
//        }
//
//    }


}
