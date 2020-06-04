package org.blackist.cloudq.api;

import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class LuckController {

    @RequestMapping(value = "/luck", method = {RequestMethod.GET})
    public String hello() {
        System.out.println("=== Luck Gateway");
        return "Luck Gateway";
    }

    @RequestMapping(value = "/upload", method = {RequestMethod.POST})
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        FileUtils.writeByteArrayToFile(new File("e:/Cache/file/" + file.getOriginalFilename()), file.getBytes());
        return "OK";
    }
}
