package com.example.coco.member;

public interface MemberRepository {

    void svae(Member member);

    Member findById(Long memberId);

}
