package com.work_with_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    RestTemplate restTemplate;

    public <T> T makeCall(String url, HttpMethod method, Object body, MediaType contentType) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(contentType);
        HttpEntity<Object> entity = new HttpEntity<>(body, httpHeaders);
        ParameterizedTypeReference<T> typeReference = new ParameterizedTypeReference<T>() {};
        return (T) restTemplate.exchange(url, method, entity, typeReference);
    }
}
