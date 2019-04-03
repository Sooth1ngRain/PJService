package com.pj.clientserv.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pj.clientserv.entity.Userinfo;
import com.pj.clientserv.mapper.UserinfoMapper;
import com.pj.clientserv.service.IUserinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ccw
 * @since 2019-03-05
 */
@Service
public class UserinfoServiceImpl extends ServiceImpl<UserinfoMapper, Userinfo> implements IUserinfoService {
    @Resource
    UserinfoMapper usermapper;

    @Override
    public Userinfo ValidateUserInfo(Userinfo userinfo) {
        Userinfo info = usermapper.selectOne(new QueryWrapper<Userinfo>().lambda().eq(Userinfo::getUid,userinfo.getUid()).eq(Userinfo::getPassword,userinfo
                .getPassword()));
        if(info == null ){
            return  info;
        }
        String logintoken = info.getUid() + "|" +"abcdefghijklmnopqrstuvwxyz0123456789";
        try {
            logintoken = Base64.getEncoder().encodeToString(logintoken.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
        info.setLogintoken(logintoken);
        usermapper.updateById(info);
        return  info;
    }

    @Override
    public boolean ValidateLoginToken(Userinfo userinfo) {
        Userinfo info = usermapper.selectOne(new QueryWrapper<Userinfo>().lambda().eq(Userinfo::getLogintoken,userinfo
                .getLogintoken()));
        if(info==null){
            return  false;
        }
        return true;
    }
}
