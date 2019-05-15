package com.zh.program.Controller;

import com.zh.program.Entrty.Consultingservice;
import com.zh.program.Service.ConsultingserviceService;
import org.apache.coyote.Request;
import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: 留言提交
 * @author: zhaohe
 * @create: 2019-05-15 10:20
 */
@Controller
@RequestMapping("consulting")
public class ConsultingController {
    @Autowired
    private ConsultingserviceService consultingserviceService;

    @ResponseBody
    @PostMapping(value = "/commit")
    public String commit(Consultingservice consultingservice, Request request){
        try {
            consultingserviceService.insertSelective(consultingservice);
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
        return "true";
    }
}
