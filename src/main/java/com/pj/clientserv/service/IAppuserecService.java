package com.pj.clientserv.service;

import com.pj.clientserv.entity.Appuserec;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ccw
 * @since 2019-03-12
 */
public interface IAppuserecService extends IService<Appuserec> {
    public int AddAppUseRecord(Appuserec appuserec);
    public void UpdateAppCloseTime(int id);
}
