package com.clean.sharednode.solution3.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.clean.sharednode.data.repository.repositoryImpl.remote.mappers.CommentJsonMapper;
import com.clean.sharednode.data.repository.repositoryImpl.remote.mappers.PostJsonMapper;
import com.clean.sharednode.data.repository.repositoryImpl.remote.model.CommentJson;
import com.clean.sharednode.data.repository.repositoryImpl.remote.model.PostJson;
import com.clean.sharednode.data.repository.PostRepository;
import com.clean.sharednode.data.repository.repositoryImpl.remote.PostRepositoryRetrofit;
import com.clean.sharednode.solution3.R;
import com.clean.sharednode.solution3.home.model.mappers.CommentViewMapper;
import com.clean.sharednode.solution3.home.model.mappers.PostViewMapper;
import com.clean.sharednode.solution3.home.model.CommentView;
import com.clean.sharednode.solution3.home.model.PostView;
import com.clean.sharednode.solution3.home.presenters.HomePresenter;
import com.clean.sharednode.solution3.home.presenters.IHomePresenter;
import com.clean.sharednode.solution3.home.view.IHomeView;
import com.example.mappers.IMapper;
import com.example.model.Comment;
import com.example.model.Post;
import com.example.repositories.IPostRepository;
import com.example.services.IPostService;
import com.example.services.PostService;

import java.util.List;


public class HomeActivity extends AppCompatActivity implements IHomeView {


    private IHomePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.loadPost(1);
    }

    @Override
    public void onPostLoaded(PostView post) {
        Toast.makeText(HomeActivity.this,post.getBody(),Toast.LENGTH_SHORT).show();
        mPresenter.loadComments(post.getId());
    }

    @Override
    public void onCommentsLoaded(List<CommentView> comments) {
        Toast.makeText(HomeActivity.this,"total comments="+comments.size(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String error) {
        //TODO handle error
        Toast.makeText(HomeActivity.this,error,Toast.LENGTH_SHORT).show();
    }

    private void initialize(){
        // [DATA LAYER] Remote initialization
        IMapper<PostJson,Post> postMapper = new PostJsonMapper();
        IMapper<CommentJson,Comment> commentMapper = new CommentJsonMapper();
        IPostRepository remote = new PostRepositoryRetrofit(postMapper,commentMapper);

        // [DATA LAYER] Base Repository (remote + local
        IPostRepository postRepository = new PostRepository(remote,null);

        // [DOMAIN LAYER] Post Service
        IPostService postService = new PostService(postRepository);

        // [APP LAYER] Presenter
        IMapper<Post,PostView> postViewMapper = new PostViewMapper();
        IMapper<Comment,CommentView> commentViewMapper = new CommentViewMapper();
        mPresenter = new HomePresenter(this, postService,postViewMapper,commentViewMapper);
    }
}
