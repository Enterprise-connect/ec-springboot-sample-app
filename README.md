# ec-springboot-example
Enterprise-Connect Springboot Example

##Introduction
- For your quickiest adoption, we derived this spring example from the pivotal [starter templates](https://start.spring.io/).
- For internal users, please refer to the internal jFrog virtual repo in your maven settings.xml.
- For external users, you may compile the [library repo](https://github.build.ge.com/Enterprise-Connect/ec-client-java-lib.git) for your reference. We're in progress of acquiring a public artifactory.

##Usage
- Add Maven dependency.
```xml
<dependency>
    <groupId>com.ge.ec</groupId>
    <artifactId>ec-client-java-lib</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```
- import Library.
```java
import com.ge.ec.ECClientImpl;
import com.ge.ec.ECServerImpl;
```
- Depend on your usage, copy the EC Client/Server Artifact to the root path of where the project jar will be running.
```bash
cp /path/from/ecclient_<darwin | windows | linux> /path/to/jar/app.jar
cp /path/from/ecserver_<darwin | windows | linux> /path/to/jar/app.jar
```
- Create the EC Client Instance.
```java
public static void main(String[] args) throws IOException {
        SpringApplication.run(Application.class, args);
        String ver=ec.version();
        
        //Configure EC Client
        final ECClientImpl ec=new ECClientImpl();
    
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
        
        //Configure EC Server
        final ECServerImpl es=new ECServerImpl();
    
        String ver=es.version();
        
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
        boolean _ref2=es.launch();
    }
```
