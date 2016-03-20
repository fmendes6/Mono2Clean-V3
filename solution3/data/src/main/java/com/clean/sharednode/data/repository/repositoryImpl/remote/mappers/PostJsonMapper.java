package com.clean.sharednode.data.repository.repositoryImpl.remote.mappers;

import com.clean.sharednode.data.repository.repositoryImpl.remote.model.PostJson;
import com.example.model.Post;
import com.example.mappers.Mapper;


public class PostJsonMapper extends Mapper<PostJson,Post> {

    @Override
    public Post transform(PostJson source) {
        return new Post(source.getUserId(),source.getId(),source.getTitle(),source.getBody());
    }
}
