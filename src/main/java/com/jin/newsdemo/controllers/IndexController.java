package com.jin.newsdemo.controllers;

import com.jin.newsdemo.models.News;
import com.jin.newsdemo.models.User;
import com.jin.newsdemo.service.NewsRepository;
import com.jin.newsdemo.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class IndexController {


    @Autowired
    private UserRepository ur;

    @Autowired
    private NewsRepository nr;

    @RequestMapping(path = {"/", "/index"})
    @ResponseBody
    public String index(Model model) {
        //ns.getLatestNews(1, 0, 10);
        //model.addAttribute("vos", getNews(0, 0, 10));
        Iterable<User> users = ur.findAll();
        Iterator<User> usersi = users.iterator();
        StringBuilder sb = new StringBuilder();
        while(usersi.hasNext())
        {
            User u = usersi.next();
            sb.append("<h1>");
            sb.append("User Name: ");
            sb.append(u.getName());
            sb.append("</h1>");
        }

        Iterator<News> news = nr.findAll().iterator();
        while(news.hasNext())
        {
            News n = news.next();
            sb.append("<h1>");
            sb.append(String.format("News Title: %s \t  News Link: %s\t Belongs to User: %s",
                n.getTitle(), n.getLink(),
                ur.findById(n.getUserId()).get().getName()));
            sb.append("</h1>");

        }
        return sb.toString();
    }

}
