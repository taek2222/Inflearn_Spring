package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * basePackages 이렇게 하면 하위 기준 스캔이 된다.
 * 하지만, 스프링부트 메인 어노테이션에 ComponentScan 이 존재
 * 삭제해도 무방.
 * 기본 디폴트 값으로 최상위 기준 하위만 스캔한다.
 */
@Configuration
@ComponentScan (
        basePackages = "hello.core",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}
