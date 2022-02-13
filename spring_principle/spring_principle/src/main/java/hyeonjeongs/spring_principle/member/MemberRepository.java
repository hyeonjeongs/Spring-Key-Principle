package hyeonjeongs.spring_principle.member;



public interface MemberRepository {
    void save(Member member); //회원 저장하는것

    Member findById(Long memberId); //회원 아이디로 회원 찾는기능
}
