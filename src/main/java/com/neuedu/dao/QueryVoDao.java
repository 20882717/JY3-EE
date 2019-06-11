package com.neuedu.dao;

import com.neuedu.entity.Data;
import com.neuedu.entity.QueryVo;

import java.util.List;

public interface QueryVoDao {

    //根据用户名模糊查询
    List<Data> getDataByName(QueryVo vo);

    //根据多个Id查询
    List<Integer> getUserById(QueryVo vo);
}
