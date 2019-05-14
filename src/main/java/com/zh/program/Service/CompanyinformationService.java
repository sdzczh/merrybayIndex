package com.zh.program.Service;

import com.alibaba.fastjson.JSONObject;
import com.zh.program.Entrty.Companyinformation;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author: autogeneration
 * @date: 2019-05-09 11:24:51
 **/ 
public interface CompanyinformationService {
    /**
     * 添加
     * 
     * @author: autogeneration
     * @date: 2019-05-09 11:24:51
     **/ 
    int insert(Companyinformation record);

    /**
     * 添加
     * 
     * @author: autogeneration
     * @date: 2019-05-09 11:24:51
     **/ 
    int insertSelective(Companyinformation record);

    /**
     * 更新
     * 
     * @author: autogeneration
     * @date: 2019-05-09 11:24:51
     **/ 
    int updateByPrimaryKey(Companyinformation record);

    /**
     * 更新
     * 
     * @author: autogeneration
     * @date: 2019-05-09 11:24:51
     **/ 
    int updateByPrimaryKeySelective(Companyinformation record);

    /**
     * 删除
     * 
     * @author: autogeneration
     * @date: 2019-05-09 11:24:51
     **/ 
    int deleteByPrimaryKey(Integer id);

    /**
     * 按主键查询
     * 
     * @author: autogeneration
     * @date: 2019-05-09 11:24:51
     **/ 
    Companyinformation selectByPrimaryKey(Integer id);

    /**
     * 条件查询
     * 
     * @author: autogeneration
     * @date: 2019-05-09 11:24:51
     **/ 
    List<Companyinformation> selectAll(Map<Object, Object> param);

    /**
     * 分页查询
     * 
     * @author: autogeneration
     * @date: 2019-05-09 11:24:51
     **/ 
    List<Companyinformation> selectPaging(Map<Object, Object> param);

    /**
     * 统计查询
     * 
     * @author: autogeneration
     * @date: 2019-05-09 11:24:51
     **/ 
    int selectCount(Map<Object, Object> param);

    /**
     * 获取公司信息  名称 手机 地址 福利 邮箱
     * @return
     */
    JSONObject getInfo();
}