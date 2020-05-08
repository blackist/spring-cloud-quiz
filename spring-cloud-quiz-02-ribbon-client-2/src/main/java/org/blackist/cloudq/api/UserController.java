package org.blackist.cloudq.api;

import org.blackist.cloudq.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @RequestMapping(value = "/getUser", method = {RequestMethod.GET})
    public User getUser(@RequestParam("id") String id) {
        System.out.println("=== Client1 get --- id: " + id);
        return new User(id, "Three", 20);
    }

    @RequestMapping(value = "/postUser", method = {RequestMethod.POST})
    public User postUser(@RequestParam("id") String id) {
        System.out.println("=== Client1 post --- id: " + id);
        return new User(id, "Four", 24);
    }

    @RequestMapping(value = "/insertUser", produces = {"application/json;charset=UTF-8"},
            consumes = {"application/json;charset=UTF-8"}, method = {RequestMethod.POST})
    public User insertUser(@RequestBody User user) {
        System.out.println("=== Client1 insert --- id: " + user.getName());
        return user;
    }

    @RequestMapping(value = "/putUser", method = {RequestMethod.PUT})
    public void putUser(@RequestBody User user, @RequestParam("id") String id) {
        System.out.println("=== Client1 update --- id: " + user.getName());
    }

    @RequestMapping(value = "/deleteUser", method = {RequestMethod.DELETE})
    public void deleteUser(@RequestParam("id") String id) {
        System.out.println("=== Client1 delete --- id: " + id);
    }

    @GetMapping("/retry")
    public String retry() {
        System.out.println("=== client 2 call ...");
        // try {
        //     // sleep 6s
        //     Thread.sleep(6000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        return "Client2 Call";
    }
}
