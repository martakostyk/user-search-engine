package com.mrtk.client;


import com.mrtk.domain.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("USER-SERVICES")
public interface UserServicesClient {

    @GetMapping("/users/{id}")
    User findById(@PathVariable(name = "id") long id);

    @GetMapping("/users/")
    List<User> findAll();
}
