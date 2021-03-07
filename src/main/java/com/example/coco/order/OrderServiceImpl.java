package com.example.coco.order;

import com.example.coco.discount.DisCountPolicy;
import com.example.coco.discount.FixDiscountPolicy;
import com.example.coco.discount.RateDiscountPolicy;
import com.example.coco.member.Member;
import com.example.coco.member.MemberRepository;
import com.example.coco.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
//    private final DisCountPolicy disCountPolicy=new FixDiscountPolicy();
    private final DisCountPolicy disCountPolicy;
    // cop 원칙에 위배됨 , 오른쪽을 변경했다.
    // dip 원칙을 위배했다. 명시적으로 하위 구현체를 정했다.

    //-> 빈으로 만들고 생성자로 받아서 넣는다.

    public OrderServiceImpl(MemberRepository memberRepository, DisCountPolicy disCountPolicy) {
        this.memberRepository = memberRepository;
        this.disCountPolicy = disCountPolicy;
    }
    //dip를 지키고 있다. interface만 바라보고 있다.



   @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        //단일 책임 원칙으로
        //할인 관련은 service가 아닌 discountPolicy만 수정하면 된다.
        int discountPrice = disCountPolicy.discount(member, itemPrice);
        //멤버를 통째로 넘길까 ? or Grade만 뽑아서 넘길까?
        //이거는 프로젝트의 상황이나 다른 부가적인 것을 봐야한다.

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
