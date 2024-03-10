package com.hxy.cod.controller;
import com.hxy.cod.pojo.Material;
import com.hxy.cod.service.MaterialService;

import com.hxy.cod.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
@RestController
public class MaterialController {
    @Autowired
    MaterialService materialService;

    @GetMapping("/api/materials")
    public List<Material> list() throws Exception {
        return materialService.list();
    }

    @PostMapping("/api/materials")
    public Material addOrUpdate(@RequestBody Material material) throws Exception {
        materialService.addOrUpdate(material);
        return material;
    }

    @PostMapping("/api/delete")
    public void delete(@RequestBody Material book) throws Exception {
        materialService.deleteById(book.getId());
    }


    @GetMapping("/api/categories/{group_id}/books")
    public List<Material> listByCategory(@PathVariable("group_id") String group_id) throws Exception {
        if(group_id.equals("0"))
            return materialService.list();
        else
            return materialService.listByGroup_id(group_id);

    }
    @CrossOrigin
    @PostMapping("api/covers")
    public String coversUpload(MultipartFile file) throws Exception {
        String folder = "/";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, StringUtils.getRandomString(6) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "http://123.56.196.54:8443/api/file/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }


}
