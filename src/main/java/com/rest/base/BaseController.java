package com.rest.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/*
* 基础控制器
* */
public abstract class BaseController {

    /*
    *   日志接入
    * */
    protected final Logger logger = LogManager.getLogger(getClass());

    /*
     *   数据源接入
     * */
    @Autowired
    protected SqlSessionTemplate sessionTemplate;












}
