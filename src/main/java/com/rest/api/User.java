package com.rest.api;


import com.rest.RestApplication;
import com.rest.base.BaseController;
import com.rest.entity.Result;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
public class User extends BaseController {



    @RequestMapping(value = "/save",method = {RequestMethod.POST})
    public Result saveUser(){
        ExecutorService threadPool = new ThreadPoolExecutor(1,1,0, TimeUnit.SECONDS,new ArrayBlockingQueue<>( 1 ),new ThreadPoolExecutor.DiscardOldestPolicy ());
        threadPool.execute (()->{
            try{
                Resource resource = new ClassPathResource("application.properties");
                Properties properties = new Properties();
                properties.load(new FileReader(resource.getFile()));
                properties.put("spring.datasource.username","root");
                FileOutputStream fos = new FileOutputStream(resource.getFile());
                properties.store(fos,""); //所以用到了store方法
            }catch (Exception e){
                e.printStackTrace();
            }
            RestApplication.restart();
        });
        threadPool.shutdown();
        return Result.OK();
    }




}
