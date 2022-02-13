package hyeonjeongs.spring_principle.member;

public interface MemberService {
    /*
    * 서비스 - 회원가입, 조회
    */
    void join(Member member); //회원가입

    Member findMember(Long memberId); //조회
}
