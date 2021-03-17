package com.nursery.nurserymanage2.config;

import com.nursery.nurserymanage2.config.component.UserDetailComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;

/**
 * author:MeiShiQiang
 * Date:2021/3/17 | Time:14:24
 *
 *  * authorizerequesets 开启基于httpservletRequest请求访问的控制
 *  * formLogin() 开启基于表单的用户登录
 *  * httpBasic    开启基于http请求的basic认证登录
 *  * logout()     开启退出登录的支持
 *  * sessionManagement    开启session管理配置
 *  * rememberMe() 开启记住我功能
 *  * csrf()       配置CSRF跨站请求伪造防护功能
 */
@Component
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailComponent userDetailComponent;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //静态资源放行
                .antMatchers("/assets/**","/css/**","/fonts/**","/img/**","/js/**","/lib/**").permitAll()
                //登录链接放行
                .antMatchers("/login","/login.html").permitAll()
                //ADMIN放行
                .antMatchers("/manage/announcement/*","/manage/pullAnnouncement/*","/manage/announce/detail/**").hasRole("ADMIN")
                .antMatchers("/manage/consumer/visit","/manage/consumer/visitConsumerInfo/*","/manage/consumer/visitConsumerEdit/*").hasRole("ADMIN")
                .antMatchers("/manage/recruit/**","/manage/announce/**","/manage/consumer/**","/manage/recruit/**","/manage/postRecruitment/*").hasRole("ADMIN")
                .antMatchers("/manage/**").hasRole("ADMIN")
                .anyRequest().authenticated();

        /**
         * loginPage() 用户登录页面跳路径,默认为get请求的  /login
         * successForwardUrl()  用户登录后   重定向的地址
         * successHander()      用户登录后   的处理
         * defaultSuccess()     用户直接登陆后     默认跳转地址
         * failureForwardUrl    用户登录失败后 重定向的地址
         * failureUrl()            用户登录失败后的跳转地址,默认为 /login?error
         * failureHandler()     用户登录失败后的错误处理
         * usernameParameter()  登录用户的用户名参数,默认为username
         * passwordParameter()  登录用户的密码参数,默认为password
         * loginProcessingUrl() 登录表单提交的路径,默认为post请求的 /login
         * permitAll()          无条件对请求进行放行
         */
        http.formLogin()
                //loginPage() 用户登录页面跳路径,默认为get请求的  /login
                .loginPage("/login")
                //usernameParameter()  登录用户的用户名参数,默认为username
                //passwordParameter()  登录用户的密码参数,默认为password
                .usernameParameter("username").passwordParameter("password")
                //successHandler()  用户登录后的处理
                .successHandler(new AuthenticationSuccessHandler(){
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        String url = request.getParameter("url");
                        RequestCache requestCache = new HttpSessionRequestCache();
                        SavedRequest savedRequest = requestCache.getRequest(request, response);
                        if(savedRequest != null){
                            response.sendRedirect(savedRequest.getRedirectUrl());
                        }else if(url!=null && !url.equals("")){
                            URL fullURl = new URL(url);
                            response.sendRedirect(fullURl.getPath());
                        }else {
                            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
                            boolean role_admain = authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN"));
                            if(role_admain){
                                response.sendRedirect("/manager");
                            }else {
                                response.sendRedirect("/index");
                            }
                        }
                    }
                })
                //failureHandler()     用户登录失败后的错误处理
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
                        String url = request.getParameter("url");
                        response.sendRedirect("/login?error&url="+url);
                    }
                });
        http.rememberMe().alwaysRemember(true).tokenValiditySeconds(60*30);
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/");
        http.exceptionHandling().accessDeniedHandler(new AccessDeniedHandler() {
            @Override
            public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
                request.getRequestDispatcher("/error_403").forward(request,response);
            }
        });
        http.headers().frameOptions().sameOrigin();
        http.csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        auth.userDetailsService(userDetailComponent).passwordEncoder(bCryptPasswordEncoder);
    }


    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        *//*auth.inMemoryAuthentication().passwordEncoder(bCryptPasswordEncoder)
                .withUser("lisi").password(bCryptPasswordEncoder.encode("123456")).roles("ADMAIN").and()
                .withUser("王大").password(bCryptPasswordEncoder.encode("123456")).roles("VIP");*//*

        *//*auth.jdbcAuthentication().passwordEncoder(bCryptPasswordEncoder)
                .dataSource(dataSource)
                .usersByUsernameQuery("select username,password from user where username = ?")
                .authoritiesByUsernameQuery("select user.username,role.role from user,role,user_role ur where ur.rid=role.rid and ur.uid = user.uid and " +
                        "user.username = ?");*//*
    }*/

}
