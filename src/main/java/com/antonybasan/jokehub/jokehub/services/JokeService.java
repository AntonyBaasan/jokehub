package com.antonybasan.jokehub.jokehub.services;

import com.antonybasan.jokehub.jokehub.domain.Joke;

public interface JokeService {
    Joke getRandomJoke();
    Joke getJokeByType(JokeServiceEnum jokeType);
}
