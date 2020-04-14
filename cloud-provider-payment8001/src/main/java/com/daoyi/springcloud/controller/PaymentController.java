package com.daoyi.springcloud.controller;

import com.daoyi.springcloud.entities.CommonResult;
import com.daoyi.springcloud.entities.Payment;
import com.daoyi.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        int i = paymentService.create(payment);
        if(i>0){
            return new  CommonResult(200,"成功",payment);
        }else{
            return new CommonResult(400,"失败",null);
        }
    }
    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id){
        Payment paymentById = paymentService.getPaymentById(id);
        if(paymentById!=null){
            return  new CommonResult(200,"查询成功",paymentById);
        }else{
            return new CommonResult(401,"查询失败",null);
        }
    }
    @GetMapping("/")
    public String aa(){
        return "aa";
    }
}
