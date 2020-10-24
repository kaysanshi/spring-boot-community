package com.kaysanshi.springbootcommunity.controller;

import com.kaysanshi.springbootcommunity.config.UploadConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author kay三石
 * @date:2019/10/25
 */
@Controller
public class UploadController {
    @Value("${server.port}")
    private String port;
    @Autowired
    UploadConfig uploadConfig;

    @PostMapping("/file/upload")
    @ResponseBody
    public Map uploadFile(@RequestParam(value = "editormd-image-file", required = false) MultipartFile multipartFile, HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Content-Type", "application/json");
        Map <String, Object> map = new HashMap <>();
        if (!multipartFile.isEmpty()) {
            String fileName = multipartFile.getOriginalFilename();
            String newFileName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));
            File saveFile = new File(uploadConfig.getPimgPath() + "/" + newFileName);
            if (!saveFile.getParentFile().exists()) {
                saveFile.getParentFile().mkdirs();
            }
            try {
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
                out.write(multipartFile.getBytes());
                out.flush();
                out.close();
                map.put("success", 1); //这里必须是数字返回否则不会回显(字符不能解析前台)
                map.put("message", "上传成功");
                map.put("url", "http://localhost:" + port + "/pimg/" + newFileName);
                System.out.println(map);
                return map; // 获得存储的名称
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                map.put("success", 0);
                map.put("message", "上传失败");
                map.put("url", "");
                return map; // 获得存储的名称
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {

            throw new RuntimeException("文件不能为空");
        }

        return null;
    }
}
