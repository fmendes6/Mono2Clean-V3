package com.clean.sharednode.solution3.home.presenters;

import com.clean.sharednode.solution3.home.model.CommentView;
import com.clean.sharednode.solution3.home.model.PostView;
import com.clean.sharednode.solution3.home.view.IHomeView;
import com.example.mappers.IMapper;
import com.example.model.Comment;
import com.example.model.Post;
import com.example.services.IPostService;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class HomePresenter implements IHomePresenter{

    private IHomeView mView;
    private IPostService mService;
    private IMapper<Post,PostView> mPostMapper;
    private IMapper<Comment,CommentView> mCommentMapper;

    public HomePresenter(IHomeView mView, IPostService mService, IMapper<Post, PostView> mPostMapper, IMapper<Comment, CommentView> mCommentMapper) {
        this.mView = mView;
        this.mService = mService;
        this.mPostMapper = mPostMapper;
        this.mCommentMapper = mCommentMapper;
    }

    public void loadPost(final int postId){
        mService.getPostById(postId)
            .subscribeOn(Schedulers.io())
            .map(new Func1<Post, PostView>() {
                @Override
                public PostView call(Post post) {
                    return mPostMapper.transform(post);
                }
            })
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Subscriber<PostView>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {
                    mView.onError(e.getLocalizedMessage());
                }

                @Override
                public void onNext(PostView postView) {
                    mView.onPostLoaded(postView);
                }
            });
    }


    public void loadComments(int postId){
        mService.getPostComments(postId)
                .subscribeOn(Schedulers.io())
                .map(new Func1<List<Comment>, List<CommentView>>() {
                    @Override
                    public List<CommentView> call(List<Comment> comments) {
                        return mCommentMapper.transformList(comments);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<CommentView>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onError(e.getLocalizedMessage());
                    }

                    @Override
                    public void onNext(List<CommentView> commentViews) {
                        mView.onCommentsLoaded(commentViews);
                    }
                });
    }


}
