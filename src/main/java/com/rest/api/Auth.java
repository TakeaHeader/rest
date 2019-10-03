package com.rest.api;

import com.rest.base.BaseController;
import com.rest.entity.Result;
import com.rest.mapper.AuthMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class Auth  extends BaseController {


    @Autowired
    public AuthMapper authMapper;

    @PostMapping("/login")
    public Result Login(@RequestBody Map<String,Object> parameter){
        Map result =  authMapper.getUser(parameter);
        if(result == null){
            return Result.Error(-1,"用户不存在/密码错误");
        }
        return Result.OK(result);
    }


}
