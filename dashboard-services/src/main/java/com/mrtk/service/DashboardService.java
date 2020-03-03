package com.mrtk.service;

import com.mrtk.client.ArticleServicesClient;
import com.mrtk.client.UserServicesClient;
import com.mrtk.domain.Article;
import com.mrtk.domain.ArticleInfo;
import com.mrtk.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DashboardService {

    private static final Logger log = LoggerFactory.getLogger(DashboardService.class);

    @Autowired
    private ArticleServicesClient articleServicesClient;

    @Autowired
    private UserServicesClient userServicesClient;

    public List<ArticleInfo> findAllArticles() {
        List<Article> articles = articleServicesClient.findAll();
        log.info(String.format("Found %d articles", articles.size()));
        List<User> users = userServicesClient.findAll();
        Map<Long, User> usersMap = new HashMap<>();
        users.forEach(user -> usersMap.put(user.getId(), user));
        return articles.stream()
                .map(article -> new ArticleInfo(article.getTitle(), usersMap.get(article.getUserId()).getLogin()))
                .collect(Collectors.toList());
    }

    public ArticleInfo findArticleById(long id) {
        Article article = articleServicesClient.findById(id);
        User user = userServicesClient.findById(article.getUserId());
        return new ArticleInfo(article.getTitle(), user.getLogin());
    }

    public List<ArticleInfo> findArticlesByUserId(long id) {
        List<Article> articles = articleServicesClient.findAll();
        User user = userServicesClient.findById(id);
        return articles.stream()
                .filter(article -> article.getUserId() == user.getId())
                .map(article -> new ArticleInfo(article.getTitle(), user.getLogin()))
                .collect(Collectors.toList());
    }
}
