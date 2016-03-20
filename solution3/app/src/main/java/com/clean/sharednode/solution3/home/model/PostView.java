package com.clean.sharednode.solution3.home.model;

import android.os.Parcel;
import android.os.Parcelable;

public class PostView implements Parcelable {

    private int userId;
    private int id;
    private String title;
    private String body;

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }


    protected PostView(Parcel in) {
        userId = in.readInt();
        id = in.readInt();
        title = in.readString();
        body = in.readString();
    }

    public PostView(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(userId);
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(body);
    }

    @SuppressWarnings("unused")
    public static final Creator<PostView> CREATOR = new Creator<PostView>() {
        @Override
        public PostView createFromParcel(Parcel in) {
            return new PostView(in);
        }

        @Override
        public PostView[] newArray(int size) {
            return new PostView[size];
        }
    };
}