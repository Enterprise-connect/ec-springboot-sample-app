package com.ge.ec.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ge.ec.ECClientImpl;
import java.io.IOException;
import java.util.HashMap;

@SpringBootApplication
public class ECClientDemoApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ECClientDemoApplication.class, args);
    }
}

@RestController
class ECClientDemoController {
    
    @RequestMapping("/start")
    String start() throws IOException {
        ECClientImpl ec=new ECClientImpl();
        String ver=ec.Version();
        Boolean _ref1=ec.Start();
        //Boolean _ref2=ec.Stop();
        //HashMap _hm=ec.getSettings();
        //ec.setSettings(_hm);
        return "EC Client is at your service.";
    }
}
