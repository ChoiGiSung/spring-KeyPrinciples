package com.example.coco;

import com.example.coco.discount.FixDiscountPolicy;
import com.example.coco.member.MemberService;
import com.example.coco.member.MemberServiceImpl;
import com.example.coco.member.MemoryMemberRepository;
import com.example.coco.order.OrderService;
import com.example.coco.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
