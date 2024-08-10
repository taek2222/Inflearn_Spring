package hello.jdbc.service;

import hello.jdbc.domain.Member;
import hello.jdbc.repository.MemberRepositoryV3;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

import java.sql.SQLException;

@Slf4j
public class MemberServiceV3_2 {

//    private final PlatformTransactionManager transactionManager;
    private final TransactionTemplate txTemplate;
    private final MemberRepositoryV3 memberRepositoryV2;

    public MemberServiceV3_2(PlatformTransactionManager transactionManager, MemberRepositoryV3 memberRepositoryV2) {
        this.txTemplate = new TransactionTemplate(transactionManager);
        this.memberRepositoryV2 = memberRepositoryV2;
    }

    public void accountTransfer(String fromId, String toId, int money) throws SQLException {
        txTemplate.executeWithoutResult((status) -> {

            try {
                Member fromMember = memberRepositoryV2.findById(fromId);
                Member toMember = memberRepositoryV2.findById(toId);

                memberRepositoryV2.update(fromId, fromMember.getMoney() - money);
                validation(toMember);
                memberRepositoryV2.update(toId, toMember.getMoney() + money);
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
        });
    }

    private static void validation(Member toMember) {
        if(toMember.getMemberId().equals("ex")) {
            throw new IllegalStateException("이체중 예외 발생");
        }
    }
}
