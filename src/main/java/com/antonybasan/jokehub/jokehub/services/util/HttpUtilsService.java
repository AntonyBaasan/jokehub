package com.antonybasan.jokehub.jokehub.services.util;

public interface HttpUtilsService {
    <T> T sendRequest(String url, Class<T> type);
}
