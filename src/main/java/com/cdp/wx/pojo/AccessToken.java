package com.cdp.wx.pojo;

import lombok.Data;

/**
 * 描述:
 *
 * @author cdp
 * @create 2022-08-22-1:17-周一
 */
@Data
public class AccessToken {
    private String access_token;
    private Integer expires_in;
}
