package com.xyj.learn.springmvc4.upload;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


/**
 * @author: xiayuejie
 * @date: 2019/1/26 14:58
 * @descron:
 */
@Controller
public class UploadController {

    @ResponseBody
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        FileUtils.writeByteArrayToFile(new File("e:/upload/"+filename),file.getBytes());
        return "OK";
    }
}
