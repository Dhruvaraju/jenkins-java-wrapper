package com.jenkins.jenkinsjavawrapper.controller;

import com.jenkins.jenkinsjavawrapper.service.JenkinsRemoteApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JenkinsOps {

    @Autowired
    private JenkinsRemoteApiService jenkinsService;

    @RequestMapping(value = "/version",method = RequestMethod.GET)
    public String jenkinsVersion(){
        return jenkinsService.fetchJenkinsVersion();
    }
}
