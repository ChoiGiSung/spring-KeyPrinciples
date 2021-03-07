package com.example.coco.member;

import com.example.coco.AppConfig;
import com.example.coco.member.Grade;
import com.example.coco.member.Member;
import com.example.coco.member.MemberService;
import com.example.coco.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

//    MemberService memberService =new MemberServiceImpl();
    AppConfig appConfig=new AppConfig();

    @Test
    void join(){
        MemberService memberService = appConfig.memberService();

        //given
        Member member = new Member(1L,"memA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
