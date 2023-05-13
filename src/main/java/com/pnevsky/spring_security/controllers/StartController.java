package com.pnevsky.spring_security.controllers;

import com.pnevsky.spring_security.security.PersonDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.pnevsky.spring_security.services.AdminService;

@Controller
public class StartController {

    private AdminService adminService;

    public StartController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/hello")
    public String helloPage(){
        return "hello";
    }

    @GetMapping("/showUserInfo")
    public String userInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        System.out.println(personDetails.getPerson());

        return "hello";
    }

    @GetMapping("/admin")
    public String adminPage(){
        adminService.doAdminStaff();
        return "admin";
    }

}
