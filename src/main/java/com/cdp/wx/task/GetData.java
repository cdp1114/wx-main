package com.cdp.wx.task;

import com.alibaba.fastjson.JSON;
import com.cdp.wx.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * 描述:
 *
 * @author cdp
 * @create 2022-08-22-16:17-周一
 */
@Component
public class GetData {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    MyWx wx;
    /**
     * 得到令牌
     * @return
     */
    public String getToken(){
        String url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+wx.getAppID()+"&secret="+wx.getAppsecret();
        AccessToken accessToken = restTemplate.getForObject(url, AccessToken.class);
        System.out.println(accessToken);
        return accessToken.getAccess_token();
    }
    /**
     * 每日一句
     */
    public Content everydaySentence(){
        String url = "http://open.iciba.com/dsapi/";
        String forObject = restTemplate.getForObject(url, String.class);
        Content content = JSON.parseObject(forObject, Content.class);
        System.out.println(content);
        return content;
    }

    /**
     * 天气详情
     */
    public Weather weather(){
        String url="https://v0.yiketianqi.com/api?unescape=1&version=v61&appid=43656176&appsecret=I42og6Lm&ext=&cityid="+wx.getCityid()+"&city=";
        String forObject = restTemplate.getForObject(url, String.class);
        Weather weather = JSON.parseObject(forObject, Weather.class);
        System.out.println(weather);
        return weather;
    }
    //随机一句
    public String getWords(){
        String url = "https://api.shadiao.pro/chp";
        String forObject = restTemplate.getForObject(url, String.class);
        RandomData randomData = JSON.parseObject(forObject, RandomData.class);
        RandomText randomText = randomData.getData();
        System.out.println(randomText.getText());
        return randomText.getText();
    }



}
