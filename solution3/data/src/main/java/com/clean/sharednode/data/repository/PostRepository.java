package com.clean.sharednode.data.repository;


import com.example.model.Comment;
import com.example.model.Post;
import com.example.repositories.IPostRepository;

import java.util.List;

import rx.Observable;

public class PostRepository implements IPostRepository {

    IPostRepository mRemote; //Ex. retrofit
    IPostRepository mLocal;  //Ex. sqlite

    public PostRepository(IPostRepository mRemote, IPostRepository mLocal) {
        this.mRemote = mRemote;
        this.mLocal = mLocal;
    }

    @Override
    public Observable<Post> getPostById(int postId) {
        return mRemote.getPostById(postId);
    }

    @Override
    public Observable<List<Comment>> getPostComments(int postId) {
        return mRemote.getPostComments(postId);
    }
}
