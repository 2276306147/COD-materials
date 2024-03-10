package com.hxy.cod.pojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
@Entity
@Table(name = "material")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;


    String cover;
    String name;
    String productId;
    String state;
    String bind;
    String location;
    @Column(name="groupid")
    String groupid;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getBind() {
        return bind;
    }

    public void setBind(String bind) {
        this.bind = bind;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCover() {
        return cover;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getProductId() {
        return productId;
    }

    public String getState() {
        return state;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProductId(String product_id) {
        this.productId = product_id;
    }

    public void setState(String state) {
        this.state = state;
    }



    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String group_id) {
        this.groupid = group_id;
    }



}
