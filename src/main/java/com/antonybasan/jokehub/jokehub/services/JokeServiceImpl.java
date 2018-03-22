package com.antonybasan.jokehub.jokehub.services;

import com.antonybasan.jokehub.jokehub.domain.Joke;
import com.antonybasan.jokehub.jokehub.domain.icanhazdadjoke.IcanDadJoke;
import com.antonybasan.jokehub.jokehub.services.util.HttpUtilsService;
import org.springframework.stereotype.Service;

@Service
public class JokeServiceImpl implements JokeService {

    private HttpUtilsService httpUtilsService;

    public JokeServiceImpl(HttpUtilsService httpUtilsService) {
        this.httpUtilsService = httpUtilsService;
    }

    @Override
    public Joke getRandomJoke() {
        Joke j = getJokeByType(JokeServiceEnum.DAD);
        return j;
    }

    public Joke getJokeByType(JokeServiceEnum jokeType) {
        if (jokeType == JokeServiceEnum.DAD) {
            return getDadJoke();
        }

        return null;
    }

    private Joke getDadJoke() {

        IcanDadJoke dadJoke = httpUtilsService.sendRequest("https://icanhazdadjoke.com/", IcanDadJoke.class);

        Joke j = new Joke();
        j.setName(dadJoke.getId());
        j.setDescription(dadJoke.getJoke());
        return j;
    }
}
