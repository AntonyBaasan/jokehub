package com.antonybasan.jokehub.jokehub.services;

import com.antonybasan.jokehub.jokehub.domain.Joke;
import org.springframework.stereotype.Service;

@Service
public class JokeServiceImpl implements JokeService{
    @Override
    public Joke getRandomJoke() {
        Joke j = new Joke();
        j.setName("Test joke");
        j.setName("Very long description");
        return j;
    }
}
