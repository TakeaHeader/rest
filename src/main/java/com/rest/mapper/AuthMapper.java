package com.rest.mapper;

import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface AuthMapper {


    public Map getUser(Map parameter);

}
