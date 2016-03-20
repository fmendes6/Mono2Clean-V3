package com.clean.sharednode.solution3.home.model.mappers;

import com.clean.sharednode.solution3.home.model.CommentView;
import com.example.mappers.Mapper;
import com.example.model.Comment;

public class CommentViewMapper extends Mapper<Comment,CommentView> {
    @Override
    public CommentView transform(Comment source) {
        return new CommentView(source.getPostId(),source.getId(),source.getName(),source.getEmail(),source.getBody());
    }
}
