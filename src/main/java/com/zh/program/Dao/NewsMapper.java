package com.zh.program.Dao;

import com.zh.program.Entrty.News;
import java.util.List;
import java.util.Map;

public interface NewsMapper {
    int insert(News record);

    int insertSelective(News record);

    int updateByPrimaryKey(News record);

    int updateByPrimaryKeySelective(News record);

    int deleteByPrimaryKey(Integer id);

    News selectByPrimaryKey(Integer id);

    List<News> selectAll(Map<Object, Object> param);

    List<News> selectPaging(Map<Object, Object> param);

    int selectCount(Map<Object, Object> param);

    List<News> selectRecommendCase(Map<Object, Object> map);
}