package com.ge.ec.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ge.ec.ECClientImpl;
import com.ge.ec.ECServerImpl;
import java.io.IOException;
import java.util.HashMap;
import org.json.simple.JSONObject;

@SpringBootApplication
public class ECClientDemoApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ECClientDemoApplication.class, args);
    }
}

@RestController
class ECClientDemoController {
    
    private static final ECClientImpl ec=new ECClientImpl();
    private static final ECServerImpl es=new ECServerImpl();
    
    @RequestMapping("/launch")
    String launch() throws IOException {
        String ver=ec.version();
        
        //Configure EC
        JSONObject jobj=new JSONObject();
        jobj.put("host", "http://proxy-src.research.ge.com");
        jobj.put("port", 8080);
        
        ec.setSetting("proxy", jobj);
        ec.setSetting("localPort", 7990);
        ec.setSetting("gatewayHost", "wss://c4240b89-7372-49c5-b4a6-8001286e4bd5.run.asv-pr.ice.predix.io");
        ec.setSetting("gatewayPort", 443);
        ec.setSetting("targetServerId", "191001");
        ec.setSetting("id", "191000");
        ec.setSetting("oauthToken", "thetoken");

        boolean _ref1=ec.launch();
        
        return _ref1?"EC Client ("+ver+") is at your service.":"EC Client failed to launch.";
    }
    
    @RequestMapping("/kill")
    String kill() throws IOException {
        String ver=ec.version();
        Boolean _ref1=ec.terminate();
        return "EC Client ("+ver+") has been terminated.";
    }
    
    @RequestMapping("/status")
    String status() throws IOException {
        ECClientImpl ec=new ECClientImpl();
        String ver=ec.version();
        Boolean _ref1=ec.isAlive();
        return (ec.isAlive())?"EC Client is ok.":"EC Client was terminated.";
    }
    
    @RequestMapping("/launchServer")
    String launchServer() throws IOException {
        String ver=es.version();
        
        //Configure EC
        JSONObject jobj=new JSONObject();
        jobj.put("host", "http://proxy-src.research.ge.com");
        jobj.put("port", 8080);
        
        es.setSetting("proxy", jobj);
        es.setSetting("gatewayHost", "wss://c4240b89-7372-49c5-b4a6-8001286e4bd5.run.asv-pr.ice.predix.io");
        es.setSetting("gatewayPort", 443);
        es.setSetting("resourceHost", "localhost");
        es.setSetting("resourcePort", 5432);
        es.setSetting("id", "191001");
        es.setSetting("oauthToken", "thetoken");
        boolean _ref1=es.launch();
        
        return _ref1?"EC Server ("+ver+") is at your service.":"EC Server failed to launch.";
    }
    
    @RequestMapping("/killServer")
    String killServer() throws IOException {
        String ver=es.version();
        Boolean _ref1=es.terminate();
        return "EC Server ("+ver+") has been terminated.";
    }
    
    @RequestMapping("/statusServer")
    String statusServer() throws IOException {
        ECClientImpl es=new ECClientImpl();
        String ver=es.version();
        Boolean _ref1=es.isAlive();
        return (es.isAlive())?"EC Server is ok.":"EC Server was terminated.";
    }
}
