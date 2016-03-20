package com.example.services;

import com.example.model.Comment;
import com.example.model.Post;
import com.example.repositories.IPostRepository;

import java.util.List;

import rx.Observable;


public class PostService implements IPostService{

    IPostRepository mRepository;

    public PostService(IPostRepository mRepository) {
        this.mRepository = mRepository;
    }

    @Override
    public Observable<Post> getPostById(int postId) {
        return mRepository.getPostById(postId);
    }

    @Override
    public Observable<List<Comment>> getPostComments(int postId) {
        return mRepository.getPostComments(postId);
    }
}
