package com.web.client.module.payment.web;

import com.web.client.module.base.GrpcBase;
import io.grpc.examples.payment.PaymentReply;
import io.grpc.examples.payment.PaymentRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class PaymentController extends GrpcBase {

    private static final Logger log = LoggerFactory.getLogger(PaymentController.class);

    @RequestMapping("/getPaymentInfo")
    public String getPaymentInfo(){
        PaymentRequest.Builder builder = PaymentRequest.newBuilder();
        builder.setOrderNo("00179");
        builder.setOrderMoney("100");
        builder.setPaymentType("ALIPAY-WEB");
        builder.setCreateTime(new Date().toString());
        PaymentReply paymentReply = paymentServiceBlockingStub.payment(builder.build());
        log.info("paymentReply---> \n{}", paymentReply);
        return paymentReply.getOrderNo();
    }
}
