package com.rest.api;

import com.rest.base.BaseController;
import com.rest.entity.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class Demo extends BaseController {



    @GetMapping("/getStuat")
    public Result getStuat(){
        return Result.OK();
    }




}
