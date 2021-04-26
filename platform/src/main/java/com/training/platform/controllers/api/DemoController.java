package com.training.platform.controllers.api;

import com.training.platform.entities.User;
import com.training.platform.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/demo")
public class DemoController {

    @Autowired
    private UserRepository userRepository;

//    @GetMapping(value = "")
//    public String index() {
//        List<User> users = userRepository.findAll();
//        System.out.println("############### Find All User (In Console)###############");
//        System.out.println(users);
//        String tem = users.toString();
//        return tem;
////        return "Method GET, Function : index => SHOW data list on page";
//    }

    @GetMapping(value = "/{id}")
    public String showWithPath(@PathVariable String id) {
        Optional<User> user = userRepository.findById(Integer.parseInt(id));
        System.out.println("############### Find User By ID (In Console)###############");
        System.out.println(user);
        return "Method Get, Function : show, ID : " + id + " => SHOW data by id on page with path";
    }

    @GetMapping(value = "/index1")
    public List<User> index1() {
        List<User> users = userRepository.findByCityAndActiveAndAge("nakornpathom", 1, 18);
        return users;
    }

    @GetMapping(value = "/index2")
    public List<User> index2() {
        List<Integer> ages = new ArrayList<Integer>(Arrays.asList(18, 19, 22));
        List<User> users = userRepository.findByAgeIn(ages);
        return users;
    }

    // Example for findAllByQuery
    @GetMapping(value = "/index3")
    public List<User> test1() {
        List<User> users = userRepository.findAllByQuery();
        System.out.println(users);
        return users;
    }
    // Example for findAllByParamsQuery
//    @GetMapping(value = "/index9")
//    public List<User> test2() {
//        return userRepository.findAllByParamsQuery(0, "nakornpathom");
//    }
    @GetMapping(value = "/index4")
    public List<User> test2(@RequestParam String active, @RequestParam String city) {
        return userRepository.findAllByParamsQuery(Integer.parseInt(active), city);
    }

    // Example for findAllByJpqlQuery
    @GetMapping(value = "/index5")
    public List<User> test3() {
        return userRepository.findAllByJpqlQuery();
    }
    // Example for findAllByJpqlParamsQuery
//    @GetMapping(value = "/index6")
//    public List<User> test4() {
//        return userRepository.findAllByJpqlParamsQuery(0, "bangkok");
//    }

    @GetMapping(value = "/index7")
    public List<User> test4(@RequestParam Integer id) {
        return userRepository.findAllByIdUser(id);
    }

    @GetMapping(value = "/index8")
    public List<User> test5(@RequestParam String name) {
        return userRepository.findAllByNameUser(name);
    }
}
