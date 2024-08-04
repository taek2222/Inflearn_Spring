package hello.jdbc.repository;

import hello.jdbc.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryV0Test {

    private static final Logger log = LoggerFactory.getLogger(MemberRepositoryV0Test.class);
    MemberRepositoryV0 repositoryV0 = new MemberRepositoryV0();

    @Test
    void crud () throws SQLException {
        Member memberV0 = new Member("memberV5", 10000);
        repositoryV0.save(memberV0);

        Member member = repositoryV0.findById(memberV0.getMemberId());
        log.info("findMember={}", member);
        assertThat(member).isEqualTo(memberV0);

        repositoryV0.update(member.getMemberId(), 20000);
        Member updateMember = repositoryV0.findById(member.getMemberId());
        assertThat(updateMember).isNotSameAs(member);

        repositoryV0.delete(member.getMemberId());
        assertThatThrownBy(() -> repositoryV0.findById(member.getMemberId()))
                .isInstanceOf(NoSuchElementException.class);
    }
}