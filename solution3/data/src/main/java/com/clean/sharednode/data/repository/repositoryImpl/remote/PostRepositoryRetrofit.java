package com.clean.sharednode.data.repository.repositoryImpl.remote;

import com.clean.sharednode.data.repository.repositoryImpl.remote.model.CommentJson;
import com.clean.sharednode.data.repository.repositoryImpl.remote.model.PostJson;
import com.clean.sharednode.data.repository.repositoryImpl.remote.retrofit.ApiProvider;
import com.clean.sharednode.data.repository.repositoryImpl.remote.retrofit.PostApi;
import com.example.model.Comment;
import com.example.model.Post;
import com.example.mappers.IMapper;
import com.example.repositories.IPostRepository;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;


public class PostRepositoryRetrofit implements IPostRepository {

    private PostApi mApi;
    private IMapper<PostJson,Post> mPostMapper;
    private IMapper<CommentJson, Comment> mCommentMapper;

    public PostRepositoryRetrofit(IMapper<PostJson, Post> postMapper, IMapper<CommentJson, Comment> commentMapper) {
        mApi = ApiProvider.getApi().create(PostApi.class);
        mPostMapper = postMapper;
        mCommentMapper = commentMapper;
    }

    @Override
    public Observable<Post> getPostById(int postId) {
        return mApi.getPostById(postId)
                .map(new Func1<PostJson, Post>() {
                    @Override
                    public Post call(PostJson postJson) {
                        return mPostMapper.transform(postJson);
                    }
                });
    }

    @Override
    public Observable<List<Comment>> getPostComments(int postId) {
        return mApi.getPostComments(postId).
                map(new Func1<List<CommentJson>, List<Comment>>() {
                    @Override
                    public List<Comment> call(List<CommentJson> commentJsons) {
                        return mCommentMapper.transformList(commentJsons);
                    }
                });
    }
}
