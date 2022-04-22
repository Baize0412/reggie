package com.reggie.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.reggie.dto.DishDto;
import com.reggie.entity.Dish;
import com.reggie.entity.DishFlavor;
import com.reggie.mapper.DishMapper;
import com.reggie.service.DishFlavorService;
import com.reggie.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {

    @Autowired
    private DishFlavorService dishFlavorService;

    /**
     * 操作多张表，新增菜品，同时保存口味数据
     * @param dishDto
     */
    @Override
    @Transactional  //多张表事务控制
    public void saveWithFlavor(DishDto dishDto) {
        //保存基本信息到dish表
        this.save(dishDto);

        //菜品ID
        Long dishId = dishDto.getId();

        //处理dish_id字段
        List<DishFlavor> flavors = dishDto.getFlavors();
        flavors = flavors.stream().map((item) -> {
            item.setDishId(dishId);
            return item;
        }).collect(Collectors.toList());
        //保存口味信息到dishFlavor表
       dishFlavorService.saveBatch(flavors);
    }
}
