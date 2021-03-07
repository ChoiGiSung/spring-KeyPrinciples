package com.example.coco.order;

import com.example.coco.AppConfig;
import com.example.coco.member.Grade;
import com.example.coco.member.Member;
import com.example.coco.member.MemberService;
import com.example.coco.member.MemberServiceImpl;
import com.example.coco.order.Order;
import com.example.coco.order.OrderService;
import com.example.coco.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

//    OrderService orderService=new OrderServiceImpl();
//    MemberService memberService=new MemberServiceImpl();

    AppConfig appConfig=new AppConfig();

    @Test
    void createOrder(){
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
        Long memberId=1L;
        Member member = new Member(memberId, "A", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.calculatePrice()).isEqualTo(9000);

    }
}
