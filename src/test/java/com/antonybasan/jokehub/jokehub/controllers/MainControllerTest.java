package com.antonybasan.jokehub.jokehub.controllers;

import com.antonybasan.jokehub.jokehub.domain.Joke;
import com.antonybasan.jokehub.jokehub.services.JokeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.Assert.*;

public class MainControllerTest {

    private MainController mainController;

    @Mock
    private JokeService jokeService;

    @Mock
    private Model model;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        mainController = new MainController(jokeService);
    }

    @Test
    public void indexTest() throws Exception {

        Joke joke1 = new Joke();
        joke1.setName("t1");
        joke1.setDescription("d1");

        when(jokeService.getRandomJoke()).thenReturn(joke1);

        String viewName = mainController.index(model);

        assertEquals("index", viewName);

        verify(jokeService, times(1)).getRandomJoke();
        verify(model, times(1)).addAttribute("joke", joke1);
    }

}