# ec-springboot-demo
Enterprise-Connect Springboot Demo

##Reference
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
```
- Copy the EC Client Artifact/Settings to the root path of the project jar file.
```bash
cp /path/from/ecclient_<darwin | windows | linux> /path/to/jar/app.jar
cp /path/from/client_settings.json /path/to/
```
- Create the EC Client Instance.
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
