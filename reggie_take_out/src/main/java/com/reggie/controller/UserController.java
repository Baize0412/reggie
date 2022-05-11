package com.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.reggie.common.R;
import com.reggie.entity.User;
import com.reggie.service.UserService;
import com.reggie.sms.Sample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 发送短信
     *
     * @param user
     * @return
     */
    @PostMapping("/sendMsg")
    public R<String> sendMsg(@RequestBody User user) throws Exception {
        log.info("接收到请求，即将发送验证码");
        Sample.sms();
        return R.success("验证码已发送");
    }

    /**
     * 登录
     *
     * @param map
     * @param httpSession
     * @return
     */
    @PostMapping("/login")
    public R<User> login(@RequestBody Map map, HttpSession httpSession) {
        //获取手机号，验证码
        String phone = map.get("phone").toString();
        String code = map.get("code").toString();
        //获取验证码，test
        String attribute = "1234";

        //验证码比对
        if (attribute.equals(code)) {
            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getPhone, phone);
            User user = userService.getOne(queryWrapper);

            if (user == null) {
                //新用户，注册
                user = new User();
                user.setPhone(phone);
                user.setStatus(1);
                userService.save(user);

            }

            httpSession.setAttribute("user", user.getId());
            return R.success(user);

        }

        return R.error("登录失败");
    }

    /**
     * 订单分页查询
     * @return
     */
    @GetMapping("/page")
    public R<String> page(Long id) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<User> userLambdaQueryWrapper = queryWrapper.eq(User::getId, id);

        userService.count(userLambdaQueryWrapper);
        return R.success("");
    }





}