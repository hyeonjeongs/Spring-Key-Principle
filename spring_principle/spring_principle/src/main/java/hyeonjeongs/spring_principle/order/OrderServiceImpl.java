package hyeonjeongs.spring_principle.order;

import hyeonjeongs.spring_principle.discount.DiscountPolicy;
import hyeonjeongs.spring_principle.discount.FixDiscountPolicy;
import hyeonjeongs.spring_principle.member.Member;
import hyeonjeongs.spring_principle.member.MemberRepository;
import hyeonjeongs.spring_principle.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository; //여기서 회원찾기
    private final DiscountPolicy discountPolicy; //고정할인정책 가져옴

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); //회원정보 불러옴
        int discountPrice = discountPolicy.discount(member, itemPrice); //불러온 회원정보를 넘겨서 할인금액가져옴
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
