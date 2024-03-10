package com.hxy.cod.dao;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hxy.cod.pojo.Material;
import java.util.List;
public interface MaterialDAO extends JpaRepository<Material, Integer> {
    List<Material> findAllByGroupid(String group_id);
    List<Material>findAllByNameLike(String name);
}
