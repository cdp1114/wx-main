package com.cdp.wx.controller;

import com.cdp.wx.task.GetData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author changdepeng
 * @version 1.0
 * @description
 * @date 2022-08-23 15:30
 */
@RestController
public class Test {

    @Resource
    GetData getData;

    @GetMapping("getwords")
    public String getWords(){
        return getData.getWords();
    }
}
