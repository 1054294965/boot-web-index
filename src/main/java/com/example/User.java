package com.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Milogenius
 * @create: 2019-07-08 11:23
 * @description: 用户
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /**
     * 昵称
     */
    private String name;
    /**
     * 密码
     */
    private String password;
}
