package com.clean.sharednode.data.repository.repositoryImpl.remote.retrofit;

import com.clean.sharednode.data.repository.repositoryImpl.remote.model.CommentJson;
import com.clean.sharednode.data.repository.repositoryImpl.remote.model.PostJson;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;


public interface PostApi {

    @GET("/posts/{postId}")
    Observable<PostJson> getPostById(@Path("postId") int postId);

    @GET("/posts/{postId}/comments")
    Observable<List<CommentJson>> getPostComments(@Path("postId") int postId);
}
