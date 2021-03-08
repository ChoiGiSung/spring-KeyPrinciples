package com.example.coco;

import com.example.coco.discount.DisCountPolicy;
import com.example.coco.discount.FixDiscountPolicy;
import com.example.coco.discount.RateDiscountPolicy;
import com.example.coco.member.MemberRepository;
import com.example.coco.member.MemberService;
import com.example.coco.member.MemberServiceImpl;
import com.example.coco.member.MemoryMemberRepository;
import com.example.coco.order.OrderService;
import com.example.coco.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    //장점
    //역할과 구현 클래스가 한 눈에 보인다. - > 애플리케이션 전체 구성이 보인다

    //변경 사항이 있으면 구성영역만 변경됨
    //사용 영역은 변경 x

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), disCountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DisCountPolicy disCountPolicy() {
//        return new FixDiscountPolicy();
        // 할인 정책 변경
        return new RateDiscountPolicy();
    }

}
