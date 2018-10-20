package com.lz.grpcservice.module.payment.web;

import io.grpc.examples.payment.PaymentReply;
import io.grpc.examples.payment.PaymentRequest;
import io.grpc.examples.payment.PaymentServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;

@GrpcService(PaymentGrpcServerService.class)
public class PaymentGrpcServerService extends PaymentServiceGrpc.PaymentServiceImplBase {

    @Override
    public void payment(PaymentRequest request, StreamObserver<PaymentReply> responseObserver) {
        PaymentReply.Builder paymentReply = PaymentReply.newBuilder();
        paymentReply.setOrderNo(request.getOrderNo());
        paymentReply.setOrderMoney(request.getOrderMoney());
        paymentReply.setPaymentType(request.getPaymentType());

        responseObserver.onNext(paymentReply.build());
        responseObserver.onCompleted();
    }
}





