package com.reggie.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.reggie.common.R;
import com.reggie.entity.Orders;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * order controller
 */
@RestController
@RequestMapping("/OrderMapper")
@Slf4j
public class OrderController {
    /**
     * 用户分页查询
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("/userPage")
    public R<Page> page(int page,int pageSize,String name) {

        //分页构造
        Page<Orders> pageInfo = new Page<>(page,pageSize);

        LambdaQueryWrapper<Orders> queryWrapper = new LambdaQueryWrapper<>();

        return null;
    }

}
