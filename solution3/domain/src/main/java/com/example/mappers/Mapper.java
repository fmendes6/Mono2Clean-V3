package com.example.mappers;

import java.util.LinkedList;
import java.util.List;

public abstract class Mapper<S,R> implements IMapper<S,R> {

    @Override
    public List<R> transformList(List<S> source) {
        List<R> news = new LinkedList<>();

        for(S json : source){
            news.add(transform(json));
        }

        return news;
    }
}
