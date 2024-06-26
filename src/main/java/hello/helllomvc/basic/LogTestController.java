package hello.helllomvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class LogTestController {
    //private final Logger log=LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest(){
        String name="Spring";
        log.trace("trace log={}",name);
        log.debug("debug log={}",name);//디버그에서만 확인
        log.info("info log={}",name);//정보
        log.warn("warn log={}",name);//경고
        log.error("error log={}",name);//에러
        return "ok";
    }
}
