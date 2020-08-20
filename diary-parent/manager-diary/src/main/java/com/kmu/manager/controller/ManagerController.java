package com.kmu.manager.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.kmu.manager.util.ResultEntity;
import com.kmu.manager.entity.Manager;
import com.kmu.manager.service.ManagerService;
import com.kmu.manager.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class ManagerController {
    @Autowired
    ManagerService managerService;

    //通过ids批量删除
    @ResponseBody
    @PostMapping("/delAll.do")
    public ResultEntity delAll(String ids){
        String[] split = ids.split(",");
        //将字符串数组转为字符串集合
        List<String> strings = Arrays.asList(split);
        boolean b=managerService.deleteByIds(strings);
        if (b) {
            return ResultEntity.success();
        }else
            return ResultEntity.failed();
    }

    //通过id删除
    @PostMapping("/delByManagerId.do")
    @ResponseBody
    public ResultEntity delByManagerId(String id){
        boolean b = managerService.removeById(id);
        if (b) {
            return  ResultEntity.success();
        }else{
            return ResultEntity.failed();
        }
    }

    //通过id修改
    @PostMapping("/updateManager.do")
    @ResponseBody
    public ResultEntity updateManager(Manager manager){
        boolean b = managerService.updateById(manager);
        if (b) {
            return  ResultEntity.success();
        }else{
            return  ResultEntity.failed();
        }
    }

    //通过id查询
    @ResponseBody
    @GetMapping("/findByManagerId.do")
    public ResultEntity findByManagerId(String id){
        Manager manager=managerService.findManagerById(id);
        return  ResultEntity.successWithData(manager);
    }

    //增加管理员
    @ResponseBody
    @PostMapping("/insertManager.do")
    public ResultEntity insertManager(Manager manager){
        //添加日期
        Date date = new Date();
        manager.setCreateDate(date);

        ResultEntity insert = managerService.insert(manager);
        if (insert.getCode()== ResultEntity.CODE_SUCCESS) {
            return ResultEntity.success();
        }else{
            return ResultEntity.failed();
        }
    }

    @Value("${disk.picPrefix}")
    String picPrefix;
    //上传头像
    @PostMapping("/submitPic.do")
    @ResponseBody
    public ResultEntity submitPic(MultipartFile file, HttpSession session) throws IOException {
        String randomString = UploadUtil.randomString();
        String picName=randomString+file.getOriginalFilename();
//        file.transferTo(new File("E:\\uploadFile\\"+picName));
        file.transferTo(new File(picPrefix+picName));
        return ResultEntity.successWithData(picName);
    }


    //模糊+分页查询
    @RequestMapping("/manager.html")
    public String managerAccount(@RequestParam(defaultValue = "",required = false) String account
            , @RequestParam(defaultValue = "1",required = false) Integer pageNum
            , @RequestParam(defaultValue = "5",required = false) Integer pageSize, Model model){

        Page<Manager> lpages= managerService.selectManagers(account,pageNum,pageSize);
        ResultEntity result = ResultEntity.successWithData(lpages);
//        System.out.println(lpages.getRecords());
//        System.out.println(lpages.getCurrent());
        model.addAttribute("result",result);
        return "manager";
    }



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
