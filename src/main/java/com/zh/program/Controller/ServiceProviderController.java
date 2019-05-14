package com.zh.program.Controller;

import com.alibaba.fastjson.JSONObject;
import com.zh.program.Common.enums.ResultCode;
import com.zh.program.Dto.Result;
import com.zh.program.Entrty.FriendshipLink;
import com.zh.program.Entrty.ServiceProvider;
import com.zh.program.Service.CompanyinformationService;
import com.zh.program.Service.FriendshipLinkService;
import com.zh.program.Service.ServiceProviderService;
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
@RequestMapping("/service")
public class ServiceProviderController {

    @Autowired
    private ServiceProviderService sps;
    @Autowired
    private FriendshipLinkService friendshipLinkService;
    @Autowired
    private CompanyinformationService comService;


    /**
     * 获取服务类型案例 0:APP开发,1:网站建设,2:微信小程序
     */
    @RequestMapping("")
    public String getAll(Model model){
        Map<Object, Object> map = new HashMap<>();
        List<ServiceProvider> list = sps.selectAll(map);
        model.addAttribute("services", list);
        List<FriendshipLink> links = friendshipLinkService.getLinks();
        JSONObject companys = comService.getInfo();
        model.addAttribute("friends", links);
        model.addAttribute("companys", companys);
        return "2anli.html";
    }

}
