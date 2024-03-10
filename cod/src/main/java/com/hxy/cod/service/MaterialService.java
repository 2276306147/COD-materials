package com.hxy.cod.service;
import com.hxy.cod.dao.MaterialDAO;
import com.hxy.cod.pojo.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MaterialService {
    @Autowired
    MaterialDAO materialDAO;


    public List<Material> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return materialDAO.findAll(sort);
    }

    public void addOrUpdate(Material material) {
        materialDAO.save(material);
    }

    public void deleteById(int id) {
        materialDAO.deleteById(id);
    }

    public List<Material> listByGroup_id(String group_id) {
        return materialDAO.findAllByGroupid(group_id);
    }

}
