package com.rest.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.HashMap;
import java.util.Map;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public final class Result {

    public static final int SUCCESS = 0;

    private int code;

    private String message ;

    private Object result;

    private Result(){
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }


    public static Result OK(){
        return OK("",null);
    }


    public static Result OK(Object result){
        return OK("",result);
    }
    /*
    * 成功可以没有
    * */
    public static Result OK(String msg,Object result){
        Result Obj = new Result();
        Obj.setCode(SUCCESS);
        Obj.setMessage(msg);
        Obj.setResult(result);
        return Obj;
    }

    /*
    *
    * 失败必须有错误提示,和错误码
    * */
    public static Result Error(int code,String msg,Object result){
        if(msg == null){
            throw new IllegalArgumentException("The Message can not be Null");
        }
        Result Obj = new Result();
        Obj.setCode(code);
        Obj.setMessage(msg);
        Obj.setResult(result);
        return Obj;
    }

    public static Result Error(int code,String msg){
        return Result.Error(code,msg,null);
    }




}
