package com.loda.entity.vo;

/**
 * @Author loda
 * @Date 2022/11/28 21:04
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class TreeModel {
    private Integer id;
    private Integer pId;
    private String name;
    //复选框是否被勾选。如果是true，则勾选;如果是false，则不勾选
    private boolean checked = false;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
