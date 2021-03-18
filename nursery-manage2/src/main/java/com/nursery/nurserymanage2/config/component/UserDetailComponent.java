package com.nursery.nurserymanage2.config.component;


import com.nursery.api.iservice.IRecruitERSV;
import com.nursery.beans.RecruiterManagmentDO;
import com.nursery.beans.RoleDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Create with IDEA
 * author:MeiShiQiang
 */
@Component
public class UserDetailComponent implements UserDetailsService {

    @Autowired
    private IRecruitERSV recruitERSV;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //获取用户及权限的信息
        RecruiterManagmentDO recruiterDO = recruitERSV.findByUsername(username);
        List<RoleDO> roles = recruitERSV.findRolesByUsername(recruiterDO.getId());
        //对用户权限进行封装
        List<SimpleGrantedAuthority> collect = roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole()))
                .collect(Collectors.toList());
        //返回封装userdetails类
        if(recruiterDO !=null){
            UserDetails userDetails = new User(recruiterDO.getRecruitName(), recruiterDO.getRecruitPass(), collect);
            return userDetails;
        }else {
            throw  new UsernameNotFoundException("当前用户不存在");
        }
    }
}
