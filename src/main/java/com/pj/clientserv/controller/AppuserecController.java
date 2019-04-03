package com.pj.clientserv.controller;


import com.pj.clientserv.entity.Appuserec;
import com.pj.clientserv.entity.ReturnInfo;
import com.pj.clientserv.service.IAppuserecService;
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
@RequestMapping("/clientserv/appuserec")
public class AppuserecController {
    @Resource
    IAppuserecService appuserecService;

    @RequestMapping(value = "/addrecord",method = RequestMethod.POST)
    public ReturnInfo addrecord(@RequestBody Appuserec appuserec) {
        int id = appuserecService.AddAppUseRecord(appuserec);
        ReturnInfo info = new ReturnInfo();
        info.setResultcode(0);
        info.setResultmsg(String.valueOf(id));
        return info;
    }

    @RequestMapping(value = "/updateclosetime",method = RequestMethod.POST)
    public ReturnInfo updateclosetime(@RequestBody int id) {
        appuserecService.UpdateAppCloseTime(id);
        ReturnInfo info = new ReturnInfo();
        info.setResultcode(0);
        return info;
    }
}
