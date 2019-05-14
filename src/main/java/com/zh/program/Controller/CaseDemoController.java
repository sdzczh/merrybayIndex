package com.zh.program.Controller;

import com.alibaba.fastjson.JSONObject;
import com.zh.program.Common.enums.ResultCode;
import com.zh.program.Dto.Result;
import com.zh.program.Entrty.CaseDemo;
import com.zh.program.Entrty.FriendshipLink;
import com.zh.program.Service.CaseDemoService;
import com.zh.program.Service.CompanyinformationService;
import com.zh.program.Service.FriendshipLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/caseDemo")
public class CaseDemoController {
    @Autowired
    private CaseDemoService caseDemoService;
    @Autowired
    private FriendshipLinkService friendshipLinkService;
    @Autowired
    private CompanyinformationService comService;


    /**
     * 显示案例列表
     * @param type 0APP 1网站 2小程序
     * @return
     */
    @RequestMapping("/{type}")
    public String getDetails(@PathVariable("type") Integer type, Model model, Integer page){
        page = page == null ? 0 : page - 1;
        Integer rows = 9;
        Map<Object, Object> map = new HashMap<>();
        map.put("serviceId", type);
        map.put("firstResult", page * rows);
        map.put("maxResult", rows);
        List<CaseDemo> caseDemos = caseDemoService.selectPaging(map);
        model.addAttribute("caseDemos", caseDemos);
        List<FriendshipLink> links = friendshipLinkService.getLinks();
        JSONObject companys = comService.getInfo();
        model.addAttribute("friends", links);
        model.addAttribute("companys", companys);
        model.addAttribute("type", type);
        return "wangzhan.html";
    }

    /**
     * 显示推荐案例
     * @return
     */
    @ResponseBody
    @RequestMapping("/recommendCase")
    public String getRecommendCase(){
        Map<Object, Object> map = new HashMap<>();
        List<CaseDemo> caseDemoList = caseDemoService.selectRecommendCase(map);
        return Result.toResult(ResultCode.SUCCESS,caseDemoList);
    }

    /**
     * 获取案例详情
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/detail/{id}")
    public String getDetail(@PathVariable("id") Integer id, Model model){
        CaseDemo caseDemo = caseDemoService.selectByPrimaryKey(id);
        model.addAttribute("caseDemo", caseDemo);
        List<FriendshipLink> links = friendshipLinkService.getLinks();
        JSONObject companys = comService.getInfo();
        model.addAttribute("friends", links);
        model.addAttribute("companys", companys);
        Map<Object, Object> map = new HashMap<>();
        List<CaseDemo> caseDemoList = caseDemoService.selectRecommendCase(map);
        model.addAttribute("caseDemoList", caseDemoList);
        return "anlixiangqing.html";
    }
}
