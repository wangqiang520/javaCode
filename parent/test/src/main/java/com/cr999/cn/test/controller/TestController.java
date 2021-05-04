package com.cr999.cn.test.controller;

import com.cr999.cn.com.biz.exception.CustomException;
import com.cr999.cn.common.DataResponse;
import com.cr999.cn.common.ResultEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文件描述：
 *
 * @version 1.0
 * @author wangqiang
 * @date 2021/4/1 23:15 
 */

@RestController
@RequestMapping("v1/test1")
public class TestController {

    @GetMapping("/test1")
    public void test1(){
        throw new CustomException("sss");
    }

    @GetMapping("/test2")
    public void test2(){
        int a=1/0;
    }

    @GetMapping("/test3")
    public DataResponse test3(){
        return new DataResponse<>(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMsg());

    }


}
