package com.pj.clientserv.service;

import com.pj.clientserv.entity.Appuserec;
import com.pj.clientserv.entity.Modelbackup;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ccw
 * @since 2019-03-12
 */
public interface IModelbackupService extends IService<Modelbackup> {
    public int AddModel(Modelbackup model);
}
