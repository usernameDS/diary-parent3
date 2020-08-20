package com.kmu.manager.config;


import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;

import com.kmu.manager.filter.CodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Properties;

/**
 * @作者：Deng 时间：2020/8/19 15:09
 */
@Configuration
@EnableWebSecurity
public class DiaryConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }


    /**
     *
     * 执行权限配置，如：为指定资源分配权限，开放无需权限的资源等
     *
     * @param http
     * @throws Exception
     */


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //父类中默认进行了配置，我们将其拿到子类，按照自己的需求进行修改
        http

                .addFilterBefore(new CodeFilter(), UsernamePasswordAuthenticationFilter.class)//设置验证码过滤器
                .authorizeRequests()//进行权限设置

                .anyRequest()//任何请求
                .authenticated()//进行认证
                // 这是ant语法，表示向后退一步，回到HttpSecurity位置的那一个级别,
                // 可以认为是使用这种方式实现HttpSecurity对象通过连续调用方法实现配置，
                // 每进行一个板块的配置完毕，则向后退一步回到HttpSecurity位置
                .and()
                .formLogin()//设置表单登录，后续可以在这里修改自定义登录页面
                .loginPage("/login.html") //设置自定义的登录页面

                //指定处理登录请求的路径，对应form表单的action地址
                .loginProcessingUrl("/login").permitAll()
                //设置接收表单提交的用户name，默认为username
                .usernameParameter("account")
                //设置接收表单提交的用户密码，默认为password
                .passwordParameter("password")
                //指定权限认证失败跳转的错误页面
                .failureUrl("/login.html?login=error")
                //直接访问登录页面时返回的地址,如果访问的是登录页的话返回指定的地址
                .defaultSuccessUrl("/index.html", true)
                //指定退出登录URL
                .and().logout().logoutUrl("/logout")
                .and().rememberMe().rememberMeParameter("remember-me")
                .and().csrf().disable() //禁用csrf功能，这里暂时用不到
        ;


    }

    //忽略静态请求
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/kaptcha","/bootstrap/**", "/css/**", "/font/**", "/images/**", "/img.404/**", "/jquery/**", "/js/**", "/ztree/**", "/layer/**", "/lib/**");


    }


    /**
     * 向容器中注入密码的编码器，密码一般都会经过编码，将明文转为密文
     *
     * @return
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        //向容器中，注入加盐的密码编码器
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DefaultKaptcha getDefaultKaptcha() {
        DefaultKaptcha captchaProducer = new DefaultKaptcha();
        Properties properties = new Properties();
        properties.setProperty("kaptcha.border", "yes");
        properties.setProperty("kaptcha.border.color", "105,179,90");
        properties.setProperty("kaptcha.textproducer.font.color", "blue");
        properties.setProperty("kaptcha.image.width", "80");
        properties.setProperty("kaptcha.image.height", "50");
        properties.setProperty("kaptcha.textproducer.font.size", "30");
        properties.setProperty("kaptcha.noise.impl", "com.google.code.kaptcha.impl.DefaultNoise");
        properties.setProperty("kaptcha.noise.color", "green");
        properties.setProperty("kaptcha.session.key", "code");
        properties.setProperty("kaptcha.textproducer.char.length", "4");
        //    properties.setProperty("kaptcha.textproducer.char.string", "123456");默认的数字
        properties.setProperty("kaptcha.obscurificator.impl", "com.google.code.kaptcha.impl.ShadowGimpy");
        properties.setProperty("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑");
        Config config = new Config(properties);
        captchaProducer.setConfig(config);
        return captchaProducer;
    }


}
