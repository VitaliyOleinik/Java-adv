package com.work_with_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Test {
    @Autowired
    static UserService userService;
    static RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/user")
    public ResponseEntity<UserDto> getUser() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> entity = new HttpEntity<>(UserDto.class, httpHeaders);
        ParameterizedTypeReference<UserDto> typeReference = new ParameterizedTypeReference<UserDto>() {};
        return restTemplate
                .exchange("http://jsonplaceholder.typicode.com/users/1", HttpMethod.GET, entity, typeReference);
    }


}
