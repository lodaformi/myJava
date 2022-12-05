package com.loda.enums;

/**
 * @Author loda
 * @Date 2022/11/23 17:00
 * @Description 分配状态枚举类
 * @Version 1.0
 */
public enum StateStatus {
    // 未分配
    UNSTATE(0),
    // 已分配
    STATED(1);

    private Integer type;

    StateStatus(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }
}
