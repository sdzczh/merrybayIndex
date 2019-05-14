package com.zh.program.Service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zh.program.Common.enums.ResultCode;
import com.zh.program.Dao.CompanyinformationMapper;
import com.zh.program.Dto.Result;
import com.zh.program.Entrty.Companyinformation;
import com.zh.program.Service.CompanyinformationService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 
 * @author: autogeneration
 * @date: 2019-05-09 11:24:51
 **/ 
@Service("companyinformationService")
public class CompanyinformationServiceImpl implements CompanyinformationService {
    @Resource
    private CompanyinformationMapper companyinformationMapper;

    private static final Logger logger = LoggerFactory.getLogger(CompanyinformationServiceImpl.class);

    @Override
    public int insert(Companyinformation record) {
        return this.companyinformationMapper.insert(record);
    }

    @Override
    public int insertSelective(Companyinformation record) {
        return this.companyinformationMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKey(Companyinformation record) {
        return this.companyinformationMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Companyinformation record) {
        return this.companyinformationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.companyinformationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Companyinformation selectByPrimaryKey(Integer id) {
        return this.companyinformationMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Companyinformation> selectAll(Map<Object, Object> param) {
        return this.companyinformationMapper.selectAll(param);
    }

    @Override
    public List<Companyinformation> selectPaging(Map<Object, Object> param) {
        return this.companyinformationMapper.selectPaging(param);
    }

    @Override
    public int selectCount(Map<Object, Object> param) {
        return this.companyinformationMapper.selectCount(param);
    }

    @Override
    public JSONObject getInfo() {
        Map<Object, Object> map = new HashMap<>();
        List<Companyinformation> comList = this.companyinformationMapper.selectAll(map);
        if (comList.size() == 0){
            return null;
        }
        Companyinformation companyinformation = comList.get(0);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("companyName",companyinformation.getCompanyName());
        jsonObject.put("address",companyinformation.getAddress());
        jsonObject.put("phone",companyinformation.getPhone());
        jsonObject.put("welfare",companyinformation.getWelfare());
        jsonObject.put("email",companyinformation.getEmail());
        return jsonObject;
    }
}