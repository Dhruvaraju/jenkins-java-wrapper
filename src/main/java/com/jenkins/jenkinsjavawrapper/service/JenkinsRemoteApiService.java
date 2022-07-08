package com.jenkins.jenkinsjavawrapper.service;

import com.cdancy.jenkins.rest.JenkinsClient;
import com.cdancy.jenkins.rest.domain.system.SystemInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JenkinsRemoteApiService {
    @Value("${jenkins.cred}")
    private String jenkinsApiCredential;
    @Value("${jenkins.endpoint}")
    private String jenkinsUrl;



    public String fetchJenkinsVersion(){
        JenkinsClient jenkinsClient = JenkinsClient.builder()
                .endPoint(jenkinsUrl)
                .apiToken(jenkinsApiCredential)
                .build();
        SystemInfo systemInfo = jenkinsClient.api().systemApi().systemInfo();
        return systemInfo.jenkinsVersion();
    }
}
