package com.web.client.module.base;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.examples.payment.PaymentServiceGrpc;

public class GrpcBase {
    private Channel channel = ManagedChannelBuilder.forAddress("localhost", 9898).usePlaintext().build();
    protected PaymentServiceGrpc.PaymentServiceBlockingStub paymentServiceBlockingStub = PaymentServiceGrpc.newBlockingStub(channel);
}
