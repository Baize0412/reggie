package com.reggie.common;

/**
 * 基于ThreadLocal封装工具类，用户保存和获取用户ID
 */
public class BaseContext {
    private static ThreadLocal<Long> threadLocal = new InheritableThreadLocal<>();

    public static void setCurrentId(Long id) {
        threadLocal.set(id);
    }

    public static Long getCurrentId() {
        return threadLocal.get();
    }
}
