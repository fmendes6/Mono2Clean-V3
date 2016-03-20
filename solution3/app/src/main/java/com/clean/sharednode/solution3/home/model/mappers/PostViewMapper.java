package com.clean.sharednode.solution3.home.model.mappers;

import com.clean.sharednode.solution3.home.model.PostView;
import com.example.mappers.Mapper;
import com.example.model.Post;

public class PostViewMapper extends Mapper<Post,PostView> {

    @Override
    public PostView transform(Post source) {
        return new PostView(source.getUserId(),source.getId(),source.getTitle(),source.getBody());
    }
}
