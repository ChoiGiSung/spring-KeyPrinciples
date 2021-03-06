package com.example.coco;

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

    OrderService orderService=new OrderServiceImpl();
    MemberService memberService=new MemberServiceImpl();

    @Test
    void createOrder(){
        Long memberId=1L;
        Member member = new Member(memberId, "A", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.calculatePrice()).isEqualTo(9000);

    }
}
