package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {

    @RequestMapping("/log-test")
    public String logTest() {
        String spring = "Spring";

        System.out.println("spring = " + spring);

        log.trace(" trace log = {}", spring);
        log.debug(" debug log = {}", spring);
        log.info(" info log = {}", spring);
        log.warn(" warn log = {}", spring);
        log.error(" error log = {}", spring);

        return "ok";
    }
}
