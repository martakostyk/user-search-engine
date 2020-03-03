package com.mrtk.client;

import com.mrtk.domain.Article;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("ARTICLE-SERVICES")
public interface ArticleServicesClient {

    @GetMapping("/articles/{id}")
    Article findById(@PathVariable(name = "id") long id);

    @GetMapping("/articles/")
    List<Article> findAll();
}
