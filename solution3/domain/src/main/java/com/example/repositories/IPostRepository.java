package com.example.repositories;

import com.example.model.Comment;
import com.example.model.Post;

import java.util.List;

import rx.Observable;

public interface IPostRepository {
    Observable<Post> getPostById(int postId);
    Observable<List<Comment>> getPostComments(int postId);
}
