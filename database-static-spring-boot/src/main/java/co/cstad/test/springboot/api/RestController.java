package co.cstad.test.springboot.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequiredArgsConstructor
public class RestController {
    private final StaticDatabase staticDatabase;
    @GetMapping("/")
    public List<User> getGetAllUser(){
      return   staticDatabase.getProductList();
    }
}
