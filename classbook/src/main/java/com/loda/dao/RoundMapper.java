package com.loda.dao;

import com.loda.entity.po.Round;

/**
 * @Author loda
 * @Date 2022/11/23 9:57
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public interface RoundMapper {
    public Integer queryCurRound();
    public Integer updateRound(Integer round);
}
