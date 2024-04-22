package hello.helllomvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {
    //뷰 템플리 호출 방법
    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1(){
        ModelAndView mav=new ModelAndView("response/hello")//해당뷰 찾아서 반환
                .addObject("data","hello");
        //data를 hello로 치환
        return mav;
    }
    @RequestMapping("/response-view-v2")
    public String  responseViewV2(Model model){
        model.addAttribute("data","hello");
        return "response/hello";//뷰의 주소로 찾아서 반환
    }
    @RequestMapping("/response/hello")//.html 주소와 같으면 void로 가능
    public void responseViewV3(Model model){
        model.addAttribute("data","hello");
    }
}
