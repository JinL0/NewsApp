package com.jin.newsdemo;

import com.jin.newsdemo.dao.NewsDAO;
import com.jin.newsdemo.models.News;
import com.jin.newsdemo.service.NewsRepository;
import com.jin.newsdemo.service.UserRepository;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jin.newsdemo.dao.UserDAO;
import com.jin.newsdemo.models.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import sun.net.www.content.image.png;

import java.util.Date;
import java.util.Random;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = NewsdemoApplication.class)
@Sql("/init-schema.sql")
public class DataBaseTest {

    @Autowired
    private UserRepository ur;

    @Autowired
    private NewsRepository nr;

    @Test
    public void initData() {
        Random random = new Random();
        for (int i = 0; i < 11; ++i) {
            User user = new User();
            user.setName(String.format("USER%d", i));
            user.setPassword("newpassword");
            ur.save(user);

            News news = new News();
            news.setCommentCount(i);
            Date date = new Date();
            date.setTime(date.getTime() + 1000*3600*5*i);
            news.setCreatedDate(date);
            news.setImage(String.format("http://images.com/%dm.png", random.nextInt(1000)));
            news.setLikeCount(i+1);
            news.setUserId(i+1);
            news.setTitle(String.format("Title %d", i));
            news.setLink(String.format("http://www.news.com/%d.html", i));
            nr.save(news);
        }
    }

}
