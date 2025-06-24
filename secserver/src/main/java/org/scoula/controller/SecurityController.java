package org.scoula.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Log4j2
@RequestMapping("/security")
@Controller
public class SecurityController {
    @GetMapping("/all")
    public void doAll(){
        log.info("do all can access everybody");
    }

    @GetMapping("/member")
    public void doMember(Principal principal){
        log.info("username="+principal.getName());
        log.info("logined member");
    }

    @GetMapping("/admin")
    public void doAdmin(){
        log.info("admin only");
    }

    @GetMapping("/login")
    public void login(){
        log.info("login page");
    }

    @GetMapping("/logout")
    public void logout(){
        log.info("logout page");
    }
}
