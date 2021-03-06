package com.example.coco.discount;

import com.example.coco.member.Grade;
import com.example.coco.member.Member;

public class FixDiscountPolicy implements DisCountPolicy{

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return discountFixAmount;
        }else {
            return 0;
        }
    }
}
