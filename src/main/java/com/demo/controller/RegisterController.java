package com.demo.controller;

import com.demo.beans.User;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {

    @RequestMapping(method = RequestMethod.GET)
    public String vewRegistration(Map<String, Object> model) {
        model.put("userForm", new User());

        List<String> professionList = Lists.newArrayList();
        professionList.add("p1");
        professionList.add("p2");
        professionList.add("p3");
        model.put("professionList", professionList);
        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("userForm")User user, Map<String, Object> model) {
        System.out.println("username: " + user.getUsername());
        System.out.println("password: " + user.getPassword());
        System.out.println("email: " + user.getEmail());
        System.out.println("profession: " + user.getProfession());

        return "registrationSuccess";
    }
}
