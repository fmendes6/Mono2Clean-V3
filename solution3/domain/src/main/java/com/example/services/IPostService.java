package com.example.services;

import com.example.model.Comment;
import com.example.model.Post;

import java.util.List;

import rx.Observable;

public interface IPostService {
    Observable<Post> getPostById(int postId);
    Observable<List<Comment>> getPostComments(int postId);
}
