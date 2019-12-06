package com.jin.newsdemo.service;


import com.jin.newsdemo.dao.NewsDAO;
import com.jin.newsdemo.models.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NewsRepository extends CrudRepository<News, Integer> {
}
