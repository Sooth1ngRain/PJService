package com.pj.clientserv.service.impl;

import com.pj.clientserv.entity.Appuserec;
import com.pj.clientserv.mapper.AppuserecMapper;
import com.pj.clientserv.service.IAppuserecService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ccw
 * @since 2019-03-12
 */
@Service
public class AppuserecServiceImpl extends ServiceImpl<AppuserecMapper, Appuserec> implements IAppuserecService {
    @Resource
    AppuserecMapper appuserecMapper;

    @Override
    public int AddAppUseRecord(Appuserec appuserec) {
        appuserecMapper.insert(appuserec);
        return appuserec.getId();
    }

    @Override
    public void UpdateAppCloseTime(int id) {
        Appuserec ent = new Appuserec();
        ent.setId(id);
        ent.setClosetime(LocalDateTime.now(ZoneId.systemDefault()));
        appuserecMapper.UpdateAppCloseTime(id);
    }
}
