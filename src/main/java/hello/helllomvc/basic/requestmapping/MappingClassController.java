package hello.helllomvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {
    @GetMapping
    public String user(){
        return "get users";
    }
    @PostMapping
    public String addUser(){
        return "post user";
    }
    @GetMapping("/{userId}")
    public String findUser(@PathVariable("userId") String userId){
        return "get userId="+userId;
    }
    @PatchMapping("/{userId}")
    public String updateUser(@PathVariable("userId") String userId){
        return "update userId="+userId;
    }
    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable("userId") String userId){
        return "delete userId="+userId;
    }
}
