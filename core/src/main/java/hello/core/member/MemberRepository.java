package hello.core.member;

public interface MemberRepository {

    //회원데이터는 자체 db를 구축할 수 있고, 외부시스템과 연동할 수있다.(미확정)

    void save(Member member);

    Member findById(Long memberId);
}
