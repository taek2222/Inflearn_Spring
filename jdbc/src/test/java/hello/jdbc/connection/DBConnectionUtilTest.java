package hello.jdbc.connection;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class DBConnectionUtilTest {

    @Test
    void connection() throws SQLException {
        // given
        Connection connection = DBConnectionUtil.getConnection();

        // when

        // then
        assertThat(connection).isNotNull();
    }
}