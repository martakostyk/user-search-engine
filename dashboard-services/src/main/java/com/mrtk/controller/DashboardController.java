package com.mrtk.controller;

import com.mrtk.domain.ArticleInfo;
import com.mrtk.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/")
    public List<ArticleInfo> findAll() {
        return dashboardService.findAllArticles();
    }

    @GetMapping("/articles/{id}")
    public ArticleInfo findById(@PathVariable("id") long id) {
        return dashboardService.findArticleById(id);
    }

    @GetMapping("/users/{id}/articles")
    public List<ArticleInfo> findByuserId(@PathVariable("id") long id) {
        return dashboardService.findArticlesByUserId(id);
    }
}
