# ec-springboot-demo
Enterprise-Connect Springboot Demo

##Reference
- We use [Cloud Foundry Springboot](https://github.com/cloudfoundry-samples/hello-spring-cloud) as the example for your quickiet EC adoption.

##Usage
* Maven dependency.
```xml
<dependency>
    <groupId>com.ge.ec</groupId>
    <artifactId>ec-client-java-lib</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

* Library.
```java
import com.ge.ec.ECClientImpl;
```

* Instance.
```java
public static void main(String[] args) throws IOException {
        SpringApplication.run(Application.class, args);
        ECClientImpl ec=new ECClientImpl();
        String ver=ec.Version();
        Boolean _ref1=ec.Start();
        Boolean _ref2=ec.Stop();
        HashMap _hm=ec.getSettings();
        ec.setSettings(_hm);
    }
```
