package com.parcom.notifier_agent_email.user;

import com.parcom.rest_template.RestTemplateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@Service
@RequiredArgsConstructor
public class UserService {


    private  final RestTemplate restTemplate;

    @Value("${parcom.services.classroom.host}")
    private String classRoomHost;

    @Value("${parcom.services.classroom.port}")
    private String classRoomPort;


    @Secured({"ROLE_ADMIN","ROLE_MEMBER"})
    public User getById(Long id ){

        URI uri = UriComponentsBuilder.newInstance().scheme(RestTemplateUtils.scheme).
                host(classRoomHost).
                port(classRoomPort).path("/users/").path(id.toString()).build().toUri();

        ResponseEntity<User> userResponseEntity =restTemplate.exchange(uri, HttpMethod.GET, RestTemplateUtils.getHttpEntity(), User.class);

        if (userResponseEntity.getStatusCode()== HttpStatus.OK) {
             return userResponseEntity.getBody();
        }
        else
        {
            throw new RuntimeException(userResponseEntity.getBody().toString());
        }
    }









}