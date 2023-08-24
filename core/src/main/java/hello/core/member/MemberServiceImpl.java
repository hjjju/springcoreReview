package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //컴포넌트 스캔의 대상이 되도록 붙임
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;  //인턴페이스에 대한 코드만있다.


    //생성자 만듦
    @Autowired //의존관계 자동 주입
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
