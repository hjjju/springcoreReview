package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {
    //구현객제를 생성, 연결
    
    //그냥침
    //이전에는 객체를 생성하고 어떤인터페이스가 들어가야하는지 할당하는것을 MemberService안에서 직접함
    //-> 생성자 주입
    @Bean//@Bean을 적어두면 스프링컨테이너에 등록됨
    public MemberService memberService() {  //MemberService를 부르면
        //1.번
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository()); //이때 memoryMemberReopository 가 여기서 들어감
    }

    @Bean
    public MemberRepository memberRepository() {
        //2번 ?? 3번?
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }


    @Bean
    public OrderService orderService() {
        //1번
        System.out.println("call AppConfig.orderService");
        
        return new OrderServiceImpl(memberRepository(),discountPolicy()); //생성자주입
    }

    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
