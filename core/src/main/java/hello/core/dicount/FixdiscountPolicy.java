package hello.core.dicount;

import hello.core.member.Grade;
import hello.core.member.Member;

/**
 * 할인 정책 : VIP 고객이면, 1000원 할인
 */
public class FixdiscountPolicy implements DiscountPolicy{

    private int dicountFixAmount = 1000; // 1,000원 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP)
            return dicountFixAmount;
        else
            return 0;
    }
}
