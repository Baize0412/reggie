package com.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.reggie.dto.SetmealDto;
import com.reggie.entity.Setmeal;

public interface SetmealService extends IService<Setmeal> {

    void saveWithDish(SetmealDto setmealDto);
}
