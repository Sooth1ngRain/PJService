package com.pj.clientserv.service.impl;

import com.pj.clientserv.entity.Modelbackup;
import com.pj.clientserv.mapper.ModelbackupMapper;
import com.pj.clientserv.service.IModelbackupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ccw
 * @since 2019-03-12
 */
@Service
public class ModelbackupServiceImpl extends ServiceImpl<ModelbackupMapper, Modelbackup> implements IModelbackupService {
    @Resource
    ModelbackupMapper modelbackupMapper;
    @Override
    public int AddModel(Modelbackup model) {
        return  modelbackupMapper.insert(model);
    }
}
