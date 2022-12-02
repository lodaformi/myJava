package com.loda.service;

import com.loda.dao.RoundMapper;
import com.loda.entity.po.Round;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author loda
 * @Date 2022/11/23 10:01
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Service
public class RoundService {
    @Resource
    private RoundMapper roundMapper;

    public Integer getCurRound() {
        return roundMapper.queryCurRound();
    }

    public Integer updateRound(Integer round) {
        return roundMapper.updateRound(round);
    }
}
