package com.loda.enums;

/**
 * @Author loda
 * @Date 2022/11/23 16:58
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public enum DevResult {
    // 未开发
    UNDEV(0),
    // 开发中
    DEVING(1),
    // 开发成功
    DEV_SUCCESS(2),
    // 开发失败
    DEV_FAILED(3);

    private Integer status;

    DevResult(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}
