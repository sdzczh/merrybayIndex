package com.zh.program.Controller;

import com.alibaba.fastjson.JSONObject;
import com.zh.program.Common.enums.ResultCode;
import com.zh.program.Dto.Result;
import com.zh.program.Entrty.*;
import com.zh.program.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/index")
public class IndexController {


    @Autowired
    private FriendshipLinkService friendshipLinkService;
    @Autowired
    private CompanyinformationService comService;
    @Autowired
    private CaseDemoService caseDemoService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private PartnersService partnersService;
    @Autowired
    private BannerService bannerService;


    @RequestMapping(value = "")
    public String index(Model model){
        List<FriendshipLink> links = friendshipLinkService.getLinks();
        JSONObject companys = comService.getInfo();
        model.addAttribute("friends", links);
        model.addAttribute("companys", companys);
        Map<Object, Object> map = new HashMap<>();
        map.put("firstResult", 0);
        map.put("maxResult", 6);
        List<CaseDemo> caseDemos = caseDemoService.selectPaging(map);
        model.addAttribute("caseDemos", caseDemos);
        map.put("maxResult", 4);
        List<News> news = newsService.selectPaging(map);
        model.addAttribute("news", news);
        map = new HashMap<>();
        List<Partners> partners = partnersService.selectAll(map);
        model.addAttribute("partners", partners);
        List<Banner> banners = bannerService.selectAll(map);
        model.addAttribute("banners", banners);
        return "index.html";
    }
}
