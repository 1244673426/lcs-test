package com.lcs.lcsboot.controller;

import com.lcs.lcsboot.result.Result;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version: 1.0
 * @author: wangLei
 * @create: 2022-11-28 23:00
 **/

@Api(tags = "测试接口")
@RestController
@RequestMapping("/api/v1/maps")
@RequiredArgsConstructor
public class testController {

    @GetMapping
    public Result<String> test(){
        return Result.success();
    }
}
