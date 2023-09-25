package com.andrux.andrux.controller;


import com.andrux.andrux.entity.Issue;
import com.andrux.andrux.security.UserPrincipal;
import com.andrux.andrux.service.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class IssueController {

    private final IssueService issueService;

    @GetMapping("/issues/")
    public String list(Model model) {
        List<Issue> issues = issueService.findAll();
        model.addAttribute("issues", issues);
        return "issue/th_list";
    }

    @GetMapping("/issue/new")
    public String newIssue() {
        return "issue/th_newIssue";
    }

    @PostMapping("/issues/")
    public String create(Issue issue, @AuthenticationPrincipal UserPrincipal userPrincipal) {
        issueService.register(issue, userPrincipal.getUsername());
        return "redirect:/issues/";
    }
}
