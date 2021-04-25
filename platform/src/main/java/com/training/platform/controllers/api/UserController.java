//package com.training.platform.controllers.api;
//
//import com.training.platform.entities.User;
//import com.training.platform.services.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.*;
//
//@RestController
//@RequestMapping(value = "/demouser")
//public class UserController {
//    @Autowired
//    private UserService userService;
//
//    @GetMapping(value = "")
//    public List<User> index() throws Exception {
//        return userService.findAll();
//    }
//
//
//    //    @GetMapping(value = "/test1")
////    public List<User> findAllByJpqlParamsQuery(@RequestParam String active, @RequestParam String city) {
////        // Change from UserRepository to UserService
////        return userService.findAllByJpqlParamsQuery(Integer.parseInt(active), city);
////    }
//    @GetMapping(value = "/test1")
//    public List<User> findAllByJpqlParamsQuery() {
//        // Change from UserRepository to UserService
//        return userService.findAllByJpqlParamsQuery(0, "bangkok");
//    }
//
//    @GetMapping(value = "/test2")
//    public List<User> findAllByJpqlQuery() {
//        return userService.findAllByJpqlQuery();
//    }
//
////    @GetMapping(value = "/test3")
////    public List<User> index3(@RequestParam String active, @RequestParam String city) {
////        return userService.findAllByParamsQuery(Integer.parseInt(active), city);
////    }
//    @GetMapping(value = "/test3")
//    public List<User> findAllByParamsQuery() {
//       return userService.findAllByParamsQuery(0, "nakornpathom");
//    }
//
//    @GetMapping(value = "/test4")
//    public List<User> findAllByQuery() {
//        return userService.findAllByQuery();
//    }
//
////    @GetMapping(value = "/test5")
////    public List<User> findByAgeIn() {
////        List<Integer> ages = new ArrayList<Integer>(Arrays.asList(20, 21, 22));
////        List<User> users = userService.findByAgeIn(ages);
////        return users;
////    }
//    @GetMapping(value = "/test5")
//    public List<User> findByAgeIn(@RequestBody Map<String ,Object> dataInput) {
//        return userService.findByAgeIn((List<Integer>) dataInput.get("age"));
//    }
//
////    @GetMapping(value = "/test6")
////    public List<User> index6(@RequestParam String city,@RequestParam String active,@RequestParam String age) {
////        return userService.findByCityAndActiveAndAge(city, Integer.parseInt(active), Integer.parseInt(age));
////    }
//    @GetMapping(value = "/test6/{city}/{active}/{age}")
//    public List<User> findByCityAndActiveAndAge(@PathVariable String city,@PathVariable String active,@PathVariable String age) {
//        return userService.findByCityAndActiveAndAge(city, Integer.parseInt(active), Integer.parseInt(age));
//    }
//
//
//    @GetMapping(value = "/test7")
//    public Page<User> findAllByLimit1(@RequestParam Integer start,@RequestParam Integer limit,@RequestParam  String field) {
//        PageRequest page = PageRequest.of(start, limit, Sort.by(Sort.Direction.ASC, field));
//        return userService.findAllByLimit(start, limit, field);
//    }
//
//    @GetMapping(value = "/test8/{id}")
//    public Optional<User> findById(@PathVariable String id) {
//        Optional<User> user = userService.findById(Integer.parseInt(id));
//        System.out.println("############### Find User By ID (In Console)###############");
//        return user;
//    }
//
//    @GetMapping(value = "/test9")
//    public List<User> findAll() {
//        List<User> users = userService.findAll();
//        return users;
//    }
//}
package com.training.platform.controllers.api;

import com.training.platform.entities.User;
import com.training.platform.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("api-user")
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "")
    public List<User> index() throws Exception {
        return userService.findAll();
    }
}
