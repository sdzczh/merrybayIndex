package com.zh.program.Service;

import com.zh.program.Entrty.FriendshipLink;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author: autogeneration
 * @date: 2019-05-09 11:24:38
 **/ 
public interface FriendshipLinkService {
    /**
     * 添加
     * 
     * @author: autogeneration
     * @date: 2019-05-09 11:24:38
     **/ 
    int insert(FriendshipLink record);

    /**
     * 添加
     * 
     * @author: autogeneration
     * @date: 2019-05-09 11:24:38
     **/ 
    int insertSelective(FriendshipLink record);

    /**
     * 更新
     * 
     * @author: autogeneration
     * @date: 2019-05-09 11:24:38
     **/ 
    int updateByPrimaryKey(FriendshipLink record);

    /**
     * 更新
     * 
     * @author: autogeneration
     * @date: 2019-05-09 11:24:38
     **/ 
    int updateByPrimaryKeySelective(FriendshipLink record);

    /**
     * 删除
     * 
     * @author: autogeneration
     * @date: 2019-05-09 11:24:38
     **/ 
    int deleteByPrimaryKey(Integer id);

    /**
     * 按主键查询
     * 
     * @author: autogeneration
     * @date: 2019-05-09 11:24:38
     **/ 
    FriendshipLink selectByPrimaryKey(Integer id);

    /**
     * 条件查询
     * 
     * @author: autogeneration
     * @date: 2019-05-09 11:24:38
     **/ 
    List<FriendshipLink> selectAll(Map<Object, Object> param);

    /**
     * 分页查询
     * 
     * @author: autogeneration
     * @date: 2019-05-09 11:24:38
     **/ 
    List<FriendshipLink> selectPaging(Map<Object, Object> param);

    /**
     * 统计查询
     * 
     * @author: autogeneration
     * @date: 2019-05-09 11:24:38
     **/ 
    int selectCount(Map<Object, Object> param);

    /**
     * 获取友情链接列表
     * @return
     */
    List<FriendshipLink> getLinks();
}