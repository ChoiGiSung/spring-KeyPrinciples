package com.example.coco.discount;

import com.example.coco.member.Grade;
import com.example.coco.member.Member;

public class RateDiscountPolicy implements DisCountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountPercent / 100;
        }else {
            return 0;
        }
    }
}
