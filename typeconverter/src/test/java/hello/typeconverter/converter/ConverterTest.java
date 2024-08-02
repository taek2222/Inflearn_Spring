package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ConverterTest {

    @Test
    void stringToInteger() {
        // given
        StringToIntegerConverter converter = new StringToIntegerConverter();
        Integer result = converter.convert("10");

        // when


        // then
        assertThat(result).isEqualTo(10);
    }

    @Test
    void IntegerToString() {
        // given
        IntegerToStringConverter converter = new IntegerToStringConverter();
        String result = converter.convert(10);
        // when

        // then
        assertThat(result).isEqualTo("10");
    }

    @Test
    void stringToIpPort() {
        // given
        StringToIpPortConverter converter = new StringToIpPortConverter();
        String source = "127.0.0.1:8080";

        // when
        IpPort convert = converter.convert(source);

        // then
        assertThat(convert).isEqualTo(new IpPort("127.0.0.1", 8080));
    }

    @Test
    void ipPortToString() {
        // given
        IpPortToStringConverter converter = new IpPortToStringConverter();
        IpPort ipPort = new IpPort("127.0.0.1", 8080);

        // when
        String string = converter.convert(ipPort);

        // then
        assertThat(string).isEqualTo("127.0.0.1:8080");
    }
}