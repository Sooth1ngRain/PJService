package com.pj.clientserv.service;

import com.pj.clientserv.entity.Userinfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ccw
 * @since 2019-03-05
 */
public interface IUserinfoService extends IService<Userinfo> {
    public Userinfo ValidateUserInfo(Userinfo userinfo);
    public boolean ValidateLoginToken(Userinfo userinfo);
}
