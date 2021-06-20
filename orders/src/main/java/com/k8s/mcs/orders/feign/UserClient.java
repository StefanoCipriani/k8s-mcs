package com.k8s.mcs.orders.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.k8s.mcs.model.UserModel;

@FeignClient(name="kbs-mcs-user", url = "http://localhost:8060")
public interface UserClient {

	@PostMapping("/add")
	String addUser(@RequestParam String name, @RequestParam String email);
	
	@GetMapping("/all")
	List<UserModel> getAll();
}
