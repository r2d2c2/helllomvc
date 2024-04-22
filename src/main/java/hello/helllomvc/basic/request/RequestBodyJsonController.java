package hello.helllomvc.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.helllomvc.basic.HelloData;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
public class RequestBodyJsonController {
    private ObjectMapper objectMapper=new ObjectMapper();

    //json으로 받기
    @PostMapping("/request-body-json-v1")
    public void requestBodyJsonV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String s = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        log.info("message={}",s);
        HelloData helloData = objectMapper.readValue(s, HelloData.class);
        log.info("username={}, age={}",helloData.getUsername(),helloData.getAge());
        response.getWriter().write("ok");
    }
    //단순화
    @ResponseBody
    @PostMapping("/request-body-json-v2")
    public String  requestBodyJsonV2(@RequestBody String messag) throws IOException {
        log.info("message={}",messag);
        HelloData helloData = objectMapper.readValue(messag, HelloData.class);
        log.info("username={}, age={}",helloData.getUsername(),helloData.getAge());
        return "ok";
    }
    //더 단순화
    @ResponseBody
    @PostMapping("/request-body-json-v3")
    public String  requestBodyJsonV3(@RequestBody HelloData helloData) {
        log.info("username={}, age={}",helloData.getUsername(),helloData.getAge());
        return "ok";
    }
    @ResponseBody
    @PostMapping("/request-body-json-v5")
    public HelloData  requestBodyJsonV5(@RequestBody HelloData helloData) {
        log.info("username={}, age={}",helloData.getUsername(),helloData.getAge());
        return helloData;
    }
}
