package com.example.coco;

import com.example.coco.member.Grade;
import com.example.coco.member.Member;
import com.example.coco.member.MemberService;
import com.example.coco.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        MemberService memberService=new MemberServiceImpl();
//        AppConfig appConfig=new AppConfig();
//        MemberService memberService = appConfig.memberService();


        //스프링 컨테이너
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);

        //빈 꺼내기기
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);



        Member member = new Member(1L, "memberA", Grade.BASIC);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("member = " + member.getName());
        System.out.println("findMember = " + findMember);
    }
}
