package com.reggie.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.reggie.entity.Orders;
import com.reggie.mapper.OrderMapper;
import com.reggie.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServicesImpl extends ServiceImpl<OrderMapper, Orders> implements OrderService {
}
