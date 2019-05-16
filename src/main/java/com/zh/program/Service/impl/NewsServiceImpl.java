package com.zh.program.Service.impl;

import com.zh.program.Dao.NewsMapper;
import com.zh.program.Entrty.News;
import com.zh.program.Service.NewsService;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 
 * @author: autogeneration
 * @date: 2019-05-08 14:28:08
 **/ 
@Service("newsService")
public class NewsServiceImpl implements NewsService {
    @Resource
    private NewsMapper newsMapper;

    private static final Logger logger = LoggerFactory.getLogger(NewsServiceImpl.class);

    @Override
    public int insert(News record) {
        return this.newsMapper.insert(record);
    }

    @Override
    public int insertSelective(News record) {
        return this.newsMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKey(News record) {
        return this.newsMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective(News record) {
        return this.newsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.newsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public News selectByPrimaryKey(Integer id) {
        return this.newsMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<News> selectAll(Map<Object, Object> param) {
        return this.newsMapper.selectAll(param);
    }

    @Override
    public List<News> selectPaging(Map<Object, Object> param) {
        return this.newsMapper.selectPaging(param);
    }

    @Override
    public int selectCount(Map<Object, Object> param) {
        return this.newsMapper.selectCount(param);
    }

    @Override
    public List<News> selectRecommendCase(Map<Object, Object> map) {
        return this.newsMapper.selectRecommendCase(map);
    }
}