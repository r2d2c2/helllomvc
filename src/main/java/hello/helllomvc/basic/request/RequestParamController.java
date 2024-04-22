package hello.helllomvc.basic.request;

import hello.helllomvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {
    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age =Integer.parseInt(request.getParameter("age"));
        log.info("username={}, age={}",username,age);

        response.getWriter().write("ok");
    }
    @ResponseBody//컨트롤럴에서 스트링 바로출력
    @RequestMapping("/request-param-v2")
    public String requestParamV2(@RequestParam("username")String memberName,
                                 @RequestParam("age")int memberAge){
        log.info("username={}, age={}",memberName,memberAge);
        return "ok";
    }
    @ResponseBody//컨트롤럴에서 스트링 바로출력
    @RequestMapping("/request-param-v3")
    public String requestParamV3(@RequestParam String username,
                                 @RequestParam int age){
        log.info("username={}, age={}",username,age);
        return "ok";
    }
    @ResponseBody//컨트롤럴에서 스트링 바로출력
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username,int age){
        log.info("username={}, age={}",username,age);
        return "ok";
    }
    @ResponseBody//컨트롤럴에서 스트링 바로출력
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username,
            //username이 필수 값이다
            @RequestParam(required = false) Integer age){
            //age는 없어도 된다
        log.info("username={}, age={}",username,age);
        return "ok";
    }
    @ResponseBody//컨트롤럴에서 스트링 바로출력
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(required = true,defaultValue = "guest") String username,
            //username이 필수 값이다
            @RequestParam(required = false,defaultValue = "-1") Integer age){
        //age는 없어도 된다
        log.info("username={}, age={}",username,age);
        return "ok";
    }
    @ResponseBody//컨트롤럴에서 스트링 바로출력
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String,Object> paramMap){
        //age는 없어도 된다
        log.info("username={}, age={}",paramMap.get("username"),paramMap.get("age"));
        return "ok";
    }
    @ResponseBody//컨트롤럴에서 스트링 바로출력
    @RequestMapping("/request-param-mulitivaluemap")
    public String requestParamMulitiValueMap(@RequestParam MultiValueMap<String,Object> paramMap){
        //age는 없어도 된다
        log.info("username={}, age={}",paramMap.get("username"),paramMap.get("age"));
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {
        log.info("username={}, age={}", helloData.getUsername(),
                helloData.getAge());
        return "ok";
    }
    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData) {
        log.info("username={}, age={}", helloData.getUsername(),
                helloData.getAge());
        return "ok";
    }
}
