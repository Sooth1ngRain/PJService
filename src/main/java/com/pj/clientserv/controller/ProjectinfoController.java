package com.pj.clientserv.controller;


import com.pj.clientserv.entity.Projectinfo;
import com.pj.clientserv.entity.ReturnInfo;
import com.pj.clientserv.service.IProjectinfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ccw
 * @since 2019-03-05
 */
@RestController
@RequestMapping("/clientserv/projectinfo")
public class ProjectinfoController {
    @Resource
    IProjectinfoService projectinfoService;

    @RequestMapping(value = "/updateuserproject",method = RequestMethod.POST)
    public ReturnInfo updateUserProject(@RequestBody List<Projectinfo> projectinfos) {
        projectinfoService.UpdateProjectInfo_Batch(projectinfos);
        ReturnInfo info = new ReturnInfo();
        info.setResultcode(0);
        info.setResultmsg("更新成功");
        return info;
    }

    @RequestMapping(value = "/getuserproject",method = RequestMethod.POST)
    public List<Projectinfo> getProjectByName(@RequestBody String username) {
        return projectinfoService.GetUserProjectInfo(username);
    }
}
