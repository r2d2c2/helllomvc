package hello.helllomvc.basic.request;

import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
public class RequestBodyStringController {

    //스트림으로 받기
    @PostMapping("/request-body-sting-v1")
    public void requestBodyString(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        //utf 설정 필수
        log.info("messageBody={}",messageBody);
        response.getWriter().write("ok");
    }
    @PostMapping("/request-body-sting-v2")
    public void requestBodyStringV2(InputStream inputStream, Writer mywriter) throws IOException {

        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        //utf 설정 필수
        log.info("messageBody={}",messageBody);
        mywriter.write("ok");
    }

    @PostMapping("/request-body-sting-v3")
    public HttpEntity<String> requestBodyStringV3(HttpEntity<String> httpEntity) throws IOException {
        //특정 타입으로 값을 받고 리턴
        String body = httpEntity.getBody();
        log.info("messageBody={}",body);
        return new HttpEntity<>("ok");
    }
    @ResponseBody
    @PostMapping("/request-body-sting-v4")
    public String  requestBodyStringV4(@RequestBody String message){
        //편하고 가장 많이 사용된다
        log.info("messageBody={}",message);
        return "ok";
    }
}
