package org.kodluyoruz.moviedb.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

public class HttpService {
    public static final String BASE_IMG_URL = "http://image.tmdb.org/t/p/w185/";
    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    private static final String API_KEY = "17bbf4c67d59f2a2e23a973560266b83";
    private static final Gson GSON = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

    private final LinkedHashMap<String, String> params = new LinkedHashMap<>();
    private final String endpoint;

    private HttpService(String endpoint) {
        this.endpoint = endpoint;
    }

    private String encode(String param) {
        try {
            return URLEncoder.encode(param, "utf-8");
        } catch (UnsupportedEncodingException e) {
            return param;
        }
    }

    private String buildURL() {
        /**
         *         BASE_URL             /endpoint?api_key=API_KEY                         &Key=Value
         * https://api.themoviedb.org/3/movie/550?api_key=17bbf4c67d59f2a2e23a973560266b83
         * */

        StringBuilder url = new StringBuilder()
                .append(BASE_URL)
                .append(endpoint)
                .append("?api_key=")
                .append(API_KEY);

        for (Map.Entry<String, String> entry : params.entrySet()) {
            url.append("&").append(entry.getKey()).append("=").append(entry.getValue());
        }
        return url.toString();
    }

    public HttpService params(String name, String value) {
        params.put(name, encode(value));
        return this;
    }

    public String get() throws UnirestException {
        return Unirest.get(buildURL()).asString().getBody();
    }

    //response'umuzu istediğimiz sınıfa dönüştürmek için
    public <T extends Serializable> T getAs(Class<T> type) throws UnirestException {
        String response = get();

        return GSON.fromJson(response, type);
    }

    public static HttpService connect(String endpoint) {
        return new HttpService(endpoint);
    }
}
