package com.antonybasan.jokehub.jokehub.services;

import com.antonybasan.jokehub.jokehub.domain.Joke;
import com.antonybasan.jokehub.jokehub.domain.icanhazdadjoke.IcanDadJoke;
import com.antonybasan.jokehub.jokehub.services.util.HttpUtilsService;
import com.antonybasan.jokehub.jokehub.services.util.HttpUtilsServiceImpl;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class JokeServiceImplTest {

    public JokeService jokeService;

    @Mock
    public HttpUtilsService httpUtilsService;

    public JokeServiceImplTest() {

        MockitoAnnotations.initMocks(this);

        this.jokeService = new JokeServiceImpl(httpUtilsService);
    }

    @Test
    public void getRandomJokeTest() {

        IcanDadJoke fakeJoke = new IcanDadJoke();
        fakeJoke.setId("1");
        fakeJoke.setJoke("hello");

        when(httpUtilsService.sendRequest(any(), any())).thenReturn(fakeJoke);

        Joke resultJoke = jokeService.getRandomJoke();

        assertEquals(fakeJoke.getId(), resultJoke.getName());
        assertEquals(fakeJoke.getJoke(), resultJoke.getDescription());
        verify(httpUtilsService, times(1)).sendRequest(any(), any());
    }

    @Test
    public void getJokeByTypeTest() {

        IcanDadJoke fakeJoke = new IcanDadJoke();
        fakeJoke.setId("1");
        fakeJoke.setJoke("hello");

        when(httpUtilsService.sendRequest("https://icanhazdadjoke.com/", IcanDadJoke.class)).thenReturn(fakeJoke);

        Joke resultJoke = jokeService.getJokeByType(JokeServiceEnum.DAD);

        assertEquals(fakeJoke.getId(), resultJoke.getName());
        assertEquals(fakeJoke.getJoke(), resultJoke.getDescription());
        verify(httpUtilsService, times(1)).sendRequest("https://icanhazdadjoke.com/", IcanDadJoke.class);
    }

//    @Test
//    public void restRequestTest() {
//
//        HttpUtilsService s = new HttpUtilsServiceImpl();
//        IcanDadJoke j = s.sendRequest("https://icanhazdadjoke.com/", IcanDadJoke.class);
//
//        System.out.println(j.getJoke().toString());
//    }


}