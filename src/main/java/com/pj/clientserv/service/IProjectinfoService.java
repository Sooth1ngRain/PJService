package com.pj.clientserv.service;

import com.pj.clientserv.entity.Projectinfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ccw
 * @since 2019-03-05
 */
public interface IProjectinfoService extends IService<Projectinfo> {
    public boolean UpdateProjectInfo_Batch(List<Projectinfo> projectinfos);
    public List<Projectinfo> GetUserProjectInfo(String username);
}
