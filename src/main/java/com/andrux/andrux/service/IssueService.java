package com.andrux.andrux.service;


import com.andrux.andrux.entity.Issue;

import java.util.List;


public interface IssueService {

    public List<Issue> findAll();

    public void register(Issue issue, String account);

}
