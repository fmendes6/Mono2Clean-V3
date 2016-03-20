package com.clean.sharednode.data.repository.repositoryImpl.remote.mappers;

import com.clean.sharednode.data.repository.repositoryImpl.remote.model.CommentJson;
import com.example.model.Comment;
import com.example.mappers.Mapper;


public class CommentJsonMapper extends Mapper<CommentJson,Comment> {
    @Override
    public Comment transform(CommentJson source) {
        return new Comment(source.getPostId(),source.getId(),source.getName(),source.getEmail(),source.getBody());
    }
}
