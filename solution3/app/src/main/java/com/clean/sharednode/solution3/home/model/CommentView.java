package com.clean.sharednode.solution3.home.model;


import android.os.Parcel;
import android.os.Parcelable;

public class CommentView implements Parcelable {

    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;

    public CommentView(int postId, int id, String name, String email, String body) {
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    protected CommentView(Parcel in) {
        postId = in.readInt();
        id = in.readInt();
        name = in.readString();
        email = in.readString();
        body = in.readString();
    }

    public int getPostId() {
        return postId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(postId);
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(email);
        dest.writeString(body);
    }

    @SuppressWarnings("unused")
    public static final Creator<CommentView> CREATOR = new Creator<CommentView>() {
        @Override
        public CommentView createFromParcel(Parcel in) {
            return new CommentView(in);
        }

        @Override
        public CommentView[] newArray(int size) {
            return new CommentView[size];
        }
    };
}