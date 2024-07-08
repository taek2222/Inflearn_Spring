package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        // given
        Member member = new Member("오연택", 25);

        // when
        Member save = memberRepository.save(member);

        // then
        Member findMember = memberRepository.findById(save.getId());
        assertThat(save).isEqualTo(findMember);
    }

    @Test
    void findAll() {
        // given
        Member member1 = new Member("오연택", 25);
        Member member2 = new Member("김영한", 20);

        Member save1 = memberRepository.save(member1);
        Member save2 = memberRepository.save(member2);

        // when
        List<Member> members = memberRepository.findAll();

        // then
        assertThat(members.size()).isEqualTo(2);
        assertThat(members).contains(save1, save2);
    }
}