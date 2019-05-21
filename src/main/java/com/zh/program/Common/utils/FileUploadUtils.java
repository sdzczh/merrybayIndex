package com.zh.program.Common.utils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileUploadUtils {

    /**
     * author:zhaohe
     * IO流读取图片
     *
     * @param imgUrl 图片url
     */
    public static void ioReadImage(String imgUrl, HttpServletResponse response) throws IOException {
        ServletOutputStream out = null;
        FileInputStream ips = null;
        String upload = null;

        try {
            //获取图片存放路径
            String imgPath = "/home/installPackage/imgs/" + "/" + imgUrl;
            ips = new FileInputStream(new File(imgPath));
            String type = imgUrl.substring(imgUrl.indexOf(".") + 1);
            if ("png".equals(type)) {
                response.setContentType("image/png");
            }
            if ("jpeg".equals(type)) {
                response.setContentType("image/jpeg");
            }
            out = response.getOutputStream();
            //读取文件流
            int len = 0;
            byte[] buffer = new byte[1024 * 10];
            while ((len = ips.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
            ips.close();
        }
    }
}
