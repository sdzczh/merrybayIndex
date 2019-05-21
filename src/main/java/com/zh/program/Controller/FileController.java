package com.zh.program.Controller;

import com.zh.program.Common.utils.FileUploadUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: zhaohe
 * @create: 2019-05-21 11:37
 */
@Controller
@RequestMapping(value = "/caseDemo")
public class FileController {
    /**
     *author:zhaohe
     * IO流读取图片
     * @param imgUrl 图片url
     */
    @RequestMapping(value = "/showImg",method = RequestMethod.GET)
    public void ioReadImage(String imgUrl, HttpServletResponse response)throws IOException {
        FileUploadUtils.ioReadImage(imgUrl,response);
    }
}
