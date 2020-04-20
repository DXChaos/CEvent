package com.dxc.cevent.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.Unsafe;

import java.lang.reflect.Field;


@RestController
@RequestMapping("**/v1/api/")
public class DemoController
{

    @GetMapping("demo")
    public String demo() throws IllegalAccessException {
        Unsafe u =  getUnsafe();
        return "我是带新朝";
    }

    public Unsafe getUnsafe() throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        return unsafe;
    }


}
