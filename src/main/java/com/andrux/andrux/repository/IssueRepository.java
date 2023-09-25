package com.andrux.andrux.repository;


import com.andrux.andrux.entity.Issue;

import java.util.List;


public interface IssueRepository {

    public List<Issue> findAll();

    public void register(Issue issue, String account);
}
