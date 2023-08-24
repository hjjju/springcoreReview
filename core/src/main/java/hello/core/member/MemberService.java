package hello.core.member;

public interface MemberService {

    //회원은 가입, 조회가능

    void join(Member member);

    Member findMember(Long memberId);
}
