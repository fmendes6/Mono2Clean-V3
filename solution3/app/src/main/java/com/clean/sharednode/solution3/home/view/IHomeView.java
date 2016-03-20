package com.clean.sharednode.solution3.home.view;

import com.clean.sharednode.solution3.home.model.CommentView;
import com.clean.sharednode.solution3.home.model.PostView;

import java.util.List;


public interface IHomeView {

    void onPostLoaded(PostView post);

    void onCommentsLoaded(List<CommentView> comments);

    void onError(String error);
}
