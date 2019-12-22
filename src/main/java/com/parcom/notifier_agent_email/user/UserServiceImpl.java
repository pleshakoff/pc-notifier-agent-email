package com.parcom.notifier_agent_email.user;

import com.parcom.network.Network;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private  final Network network;


    @Override
    public User getById(Long id){
        return network.callGet("classroom",User.class,"users").getBody();
    }









}