package com.antonybasan.jokehub.jokehub.controllers;

import com.antonybasan.jokehub.jokehub.domain.Joke;
import com.antonybasan.jokehub.jokehub.services.JokeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    private JokeService jokeService;

    public MainController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping("")
    public String index(Model model) {
        Joke joke = jokeService.getRandomJoke();

        model.addAttribute("joke", joke);
        return "index";
    }
}
