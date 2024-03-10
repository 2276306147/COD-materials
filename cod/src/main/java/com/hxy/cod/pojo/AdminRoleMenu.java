package com.hxy.cod.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "admin_menu")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class AdminRoleMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    int rid;
    int uid;

    public void setId(int id) {
        this.id = id;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getId() {
        return id;
    }

    public int getRid() {
        return rid;
    }

    public int getUid() {
        return uid;
    }
}
