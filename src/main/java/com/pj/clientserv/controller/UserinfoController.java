package com.pj.clientserv.controller;


import com.pj.clientserv.entity.ReturnInfo;
import com.pj.clientserv.entity.Userinfo;
import com.pj.clientserv.service.IUserinfoService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Base64;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ccw
 * @since 2019-03-05
 */
@RestController
@RequestMapping("/clientserv/userinfo")
public class UserinfoController {
    @Resource
    IUserinfoService userinfoService;

    @ApiOperation(value="登陆验证")
    @ApiImplicitParam(name = "userinfo", value = "用户信息", required = true, dataType = "Userinfo")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ReturnInfo Login(@RequestBody Userinfo userinfo) {
        ReturnInfo info = new ReturnInfo();
        userinfo = userinfoService.ValidateUserInfo(userinfo);
        if(userinfo == null){
            info.setResultmsg("账号或密码不正确。");
            info.setResultcode(2);
            return  info;
        }
        info.setResultcode(0);
        info.setResultmsg(userinfo.getLogintoken());
        return  info;
    }

    @ApiOperation(value="登陆码验证")
    @RequestMapping(value = "/logintoken",method = RequestMethod.POST)
    public ReturnInfo logintoken(@RequestParam(value="logincode") String logincode) {
        try{
            Userinfo user = new Userinfo();
            user.setLogintoken(logincode);
            if(userinfoService.ValidateLoginToken(user)){
                ReturnInfo returnInfo = new ReturnInfo();
                returnInfo.setResultcode(0);
                returnInfo.setResultmsg("pass");
                return  returnInfo;
            }
            else {
                ReturnInfo returnInfo = new ReturnInfo();
                returnInfo.setResultcode(1);
                returnInfo.setResultmsg("连接失败，请重新登陆。");
                return  returnInfo;
            }
        }
        catch (Exception ex){
            ReturnInfo info = new ReturnInfo();
            info.setResultcode(1);
            info.setResultmsg("连接失败，请重新登陆。");
            return  info;
        }
    }
}
