package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

@Component //컴포넌트 스캔의 대상이 되도록 붙임
public class RateDiscountPolicy implements DiscountPolicy {

    //퍼센트할인

    private int discountPercent = 10; //10%할인


    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }
        return 0;
    }
}
