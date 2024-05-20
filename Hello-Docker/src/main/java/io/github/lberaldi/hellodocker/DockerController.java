package io.github.lberaldi.hellodocker;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerController {

    @RequestMapping("/hello-docker")
    public HelloDocker helloDocker(){
        var hostName = System.getenv("HOSTNAME");

        return new HelloDocker("Hello Docker", hostName);
    }
}
