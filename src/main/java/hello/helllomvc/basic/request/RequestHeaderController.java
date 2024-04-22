package hello.helllomvc.basic.request;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@Slf4j
@RestController
public class RequestHeaderController {

    @RequestMapping("/headers")
    public String headers(HttpServletRequest request, HttpServletResponse response
            , HttpMethod httpMethod, Locale locale
            , @RequestHeader MultiValueMap<String,String > headerMap
            , @RequestHeader("host") String host//기본 host
            , @CookieValue(value = "myCookie",required = false)//쿠키 없어도 된다
            String cookie){
        log.trace("request log={}",request);
        log.trace("response log={}",response);
        log.trace("httpMethod log={}",httpMethod);
        log.trace("locale log={}",locale);
        log.trace("headerMap log={}",headerMap);
        log.trace("host log={}",host);
        log.trace("cookie log={}",cookie);
        return "ok";
    }
}
