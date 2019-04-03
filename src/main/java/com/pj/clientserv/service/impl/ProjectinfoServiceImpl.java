package com.pj.clientserv.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pj.clientserv.entity.Projectinfo;
import com.pj.clientserv.mapper.ProjectinfoMapper;
import com.pj.clientserv.service.IProjectinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ccw
 * @since 2019-03-05
 */
@Service
public class ProjectinfoServiceImpl extends ServiceImpl<ProjectinfoMapper, Projectinfo> implements IProjectinfoService {
    @Resource
    ProjectinfoMapper projectinfoMapper;
    @Override
    public boolean UpdateProjectInfo_Batch(List<Projectinfo> projectinfos) {
        projectinfos.forEach((e)->{
            if(projectinfoMapper.selectById(e.getProjectid()) == null)
            {
                projectinfoMapper.insert(e);
            }
            else {
                projectinfoMapper.updateById(e);
            }
        });
        return false;
    }

    @Override
    public List<Projectinfo> GetUserProjectInfo(String username) {
        return projectinfoMapper.selectList(new QueryWrapper<Projectinfo>().lambda().eq(Projectinfo::getUid,username));
    }
}
