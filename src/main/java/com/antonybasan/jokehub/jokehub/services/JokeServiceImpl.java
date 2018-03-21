package com.antonybasan.jokehub.jokehub.services;

import com.antonybasan.jokehub.jokehub.domain.Joke;
import com.antonybasan.jokehub.jokehub.domain.icanhazdadjoke.IcanDadJoke;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JokeServiceImpl implements JokeService {
    @Override
    public Joke getRandomJoke() {
        Joke j = new Joke();
        j.setName("Test joke");
        j.setDescription("Very long description");
        return j;
    }

    public Joke getJokeByType(String jokeType) {
        if (jokeType == "dad") {
            return getDadJoke();
        }

        return null;
    }

    private Joke getDadJoke() {
        RestTemplate restTemplate = new RestTemplate();
        IcanDadJoke dadJoke = restTemplate.getForObject("https://icanhazdadjoke.com/", IcanDadJoke.class);

        Joke j = new Joke();
        j.setName(dadJoke.getId());
        j.setDescription(dadJoke.getJoke());
        return j;
    }
}
