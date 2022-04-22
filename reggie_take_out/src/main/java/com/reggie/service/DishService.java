package com.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.reggie.dto.DishDto;
import com.reggie.entity.Dish;

public interface DishService extends IService<Dish> {

    //新增菜品，同时插入口味数据，需要操作两张表，dish，dishFlavor
    void saveWithFlavor(DishDto dishDto);
}
