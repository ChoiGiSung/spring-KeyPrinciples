package com.example.coco.order;

public interface OrderService {

    //주문 서비스 기능은 item을 받으면
    //주문 결과를 준다.
    //
    Order createOrder(Long memberId,String itemName,int itemPrice);
}
