package com.zh.program.Controller;

import com.alibaba.fastjson.JSONObject;
import com.zh.program.Common.enums.ResultCode;
import com.zh.program.Dto.Result;
import com.zh.program.Entrty.CaseDemo;
import com.zh.program.Entrty.FriendshipLink;
import com.zh.program.Entrty.News;
import com.zh.program.Service.CompanyinformationService;
import com.zh.program.Service.FriendshipLinkService;
import com.zh.program.Service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private CompanyinformationService companyinformationService;
    @Autowired
    private FriendshipLinkService friendshipLinkService;
    @Autowired
    private CompanyinformationService comService;

    /**
     *获取新闻列表
     * type 新闻类型 0:行业新闻,1:公司动态
     * @param type
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = {"/list/{type}","/list"})
    public String getAll(@PathVariable(value = "type", required=false)Integer type, Integer page, Integer rows, Model model){
        if (type == null){ type = 0;}
        Map<Object, Object> map = new HashMap<>();
        map.put("type", type);
        /*page = page == null ? 0 : page - 1;
        rows = rows == null ? 10 : rows;
        Map<Object, Object> map = new HashMap<>();
        map.put("type", type);
        model.addAttribute("type", type);
        map.put("firstResult",page * rows);
        map.put("maxResult",rows);
        List<News> list = newsService.selectPaging(map);*/
        model.addAttribute("type", type);
        List<News> list = newsService.selectAll(map);
        Integer count = newsService.selectCount(map);
        List<News> resultList= new LinkedList<>();
        for (News news : list) {
            News news1 = new News();
            news1.setId(news.getId());
            news1.setImgLink(news.getImgLink());
            news1.setTitle(news.getTitle());
            news1.setDescribe(news.getDescribe());
            news1.setUpdateTime(news.getUpdateTime());
            news1.setType(news.getType());
            resultList.add(news1);
        }
        model.addAttribute("resultList",resultList);
        JSONObject jsonObject = companyinformationService.getInfo();
        model.addAttribute("companyInfo", jsonObject);
        List<FriendshipLink> links = friendshipLinkService.getLinks();
        model.addAttribute("friends", links);
        Map<Object,Object> data = new HashMap<>();
        data.put("count", count);
        return "4xinwen.html";
    }

    /**
     * 显示新闻详情
     */
    @RequestMapping("/details/{id}")
    public String getDetails(@PathVariable("id") Integer id, Model model){
        if (id == null || "".equals(id)){
            return Result.toResult(ResultCode.PARAM_TYPE_BIND_ERROQ);
        }
        News news = newsService.selectByPrimaryKey(id);
        model.addAttribute("news",news);
        List<FriendshipLink> links = friendshipLinkService.getLinks();
        JSONObject jsonObject = companyinformationService.getInfo();
        //显示推荐新闻
        Map<Object, Object> map = new HashMap<>();
        List<News> newsList = newsService.selectRecommendCase(map);
        model.addAttribute("newsList", newsList);
        //显示公司信息
        model.addAttribute("companyInfo", jsonObject);
        //显示友情链接
        model.addAttribute("friends", links);
        return "xinwenxiangqing.html";
    }

}
