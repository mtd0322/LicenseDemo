package org.alan.controller;

import com.alibaba.fastjson.JSON;
import org.alan.license.LicenseVerify;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    /**
     * 模拟登录验证
     * @param username 用户名
     * @param password 密码
     */
    @RequestMapping("/check")
    public Map<String,Object> test(@RequestParam(required = true) String username, @RequestParam(required = true) String password){
        Map<String,Object> result = new HashMap<>(2);
        System.out.println("############"+username+":"+"password"+"###############");


        LicenseVerify licenseVerify = new LicenseVerify();

        //校验证书是否有效
        boolean verifyResult = licenseVerify.verify();
        if(verifyResult){
            result.put("result","校验成功");
        }else{
            result.put("result","您的证书无效，请核查服务器是否取得授权或重新申请证书！");
        }
        return result;
    }
}
