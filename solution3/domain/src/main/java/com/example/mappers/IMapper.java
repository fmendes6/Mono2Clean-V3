package com.example.mappers;

import java.util.List;

public interface IMapper<S,R> {
    List<R> transformList(List<S> source);
    R transform(S source);
}