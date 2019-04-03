package com.pj.clientserv.controller;


import com.pj.clientserv.entity.Modelbackup;
import com.pj.clientserv.entity.ReturnInfo;
import com.pj.clientserv.service.IModelbackupService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ccw
 * @since 2019-03-12
 */
@RestController
@RequestMapping("/clientserv/modelbackup")
public class ModelbackupController {
    @Resource
    IModelbackupService modelbackupService;

    @RequestMapping(value = "/addmodel",method = RequestMethod.POST)
    public ReturnInfo addrecord(@RequestBody Modelbackup appuserec) {
        int affectrow = modelbackupService.AddModel(appuserec);
        ReturnInfo info = new ReturnInfo();
        info.setResultcode(0);
        info.setResultmsg("更新行数：" + String.valueOf(affectrow));
        return info;
    }
}
