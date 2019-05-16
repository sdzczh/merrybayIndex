package com.zh.program.Service;

import com.zh.program.Entrty.CaseDemo;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author: autogeneration
 * @date: 2019-05-08 14:26:51
 **/ 
public interface CaseDemoService {
    /**
     * 添加
     * 
     * @author: autogeneration
     * @date: 2019-05-08 14:26:51
     **/ 
    int insert(CaseDemo record);

    /**
     * 添加
     * 
     * @author: autogeneration
     * @date: 2019-05-08 14:26:51
     **/ 
    int insertSelective(CaseDemo record);

    /**
     * 更新
     * 
     * @author: autogeneration
     * @date: 2019-05-08 14:26:51
     **/ 
    int updateByPrimaryKey(CaseDemo record);

    /**
     * 更新
     * 
     * @author: autogeneration
     * @date: 2019-05-08 14:26:51
     **/ 
    int updateByPrimaryKeySelective(CaseDemo record);

    /**
     * 删除
     * 
     * @author: autogeneration
     * @date: 2019-05-08 14:26:51
     **/ 
    int deleteByPrimaryKey(Integer id);

    /**
     * 按主键查询
     * 
     * @author: autogeneration
     * @date: 2019-05-08 14:26:51
     **/ 
    CaseDemo selectByPrimaryKey(Integer id);

    /**
     * 条件查询
     * 
     * @author: autogeneration
     * @date: 2019-05-08 14:26:51
     **/ 
    List<CaseDemo> selectAll(Map<Object, Object> param);

    /**
     * 分页查询
     * 
     * @author: autogeneration
     * @date: 2019-05-08 14:26:51
     **/ 
    List<CaseDemo> selectPaging(Map<Object, Object> param);

    /**
     * 统计查询
     * 
     * @author: autogeneration
     * @date: 2019-05-08 14:26:51
     **/ 
    int selectCount(Map<Object, Object> param);

    List<CaseDemo> selectType(Map<Object, Object> map);

    /**
     * 倒序显示前三条
     * @param map
     * @return
     */
    List<CaseDemo> selectRecommendCase(Map<Object, Object> map);
}