package co.cstad.test.springboot.api;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
//@RequiredArgsConstructor
public class StaticDatabase {
    //done
    private List<User> productList;

    public StaticDatabase(){
        productList=new ArrayList<>();
        productList.add(new User(10,"Mako","Mouse",20));
        productList.add(new User(12,"Mama","Keyword",20));
        productList.add(new User(13,"Maka","Laptop",20));
        productList.add(new User(15,"Mata","Changer",20));
    }

    public List<User> getProductList() {
        return productList;
    }


    public void setProductList(List<User> productList) {
        this.productList = productList;
    }
}
