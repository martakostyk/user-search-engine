package com.mrtk.service;

import com.mrtk.model.Article;
import com.mrtk.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> findAll() {
        return (List<Article>) articleRepository.findAll();
    }

    public Optional<Article> findById(long id) {
        return Optional.ofNullable(articleRepository.findOne(id));
    }
}
