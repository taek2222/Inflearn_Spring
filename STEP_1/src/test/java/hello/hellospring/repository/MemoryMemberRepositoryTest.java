package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 실행 이후 초기화
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    // 저장 테스트
    @Test
    public void save() {
        Member member = new Member();
        member.setName("Oh Yeon Taek");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    // name 기반 검색 테스트
    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("Oh Yeon Taek");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Yeon Taek");
        repository.save(member2);

        Member result = repository.findByName("Oh Yeon Taek").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("Oh Yeon Taek");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Yeon Taek");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
