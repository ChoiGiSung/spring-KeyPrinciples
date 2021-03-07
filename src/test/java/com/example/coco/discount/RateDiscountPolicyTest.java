package com.example.coco.discount;

import com.example.coco.member.Grade;
import com.example.coco.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy=new RateDiscountPolicy();

    @Test
    @DisplayName("vip는 10 할인이 적용되어야 한다.")
    void vip_o(){
        //given
        Member member = new Member(1L, "vip", Grade.VIP);

        //when
        int discount = rateDiscountPolicy.discount(member, 10000);

        //then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("vip가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x(){
        //given
        Member member = new Member(1L, "vip", Grade.BASIC);

        //when
        int discount = rateDiscountPolicy.discount(member, 10000);

        //then
        Assertions.assertThat(discount).isEqualTo(0);
    }

}