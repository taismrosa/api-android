package br.edu.uniritter.a2app.model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

public class Todo implements Parcelable {
    private int userId, id;
    private String title;
    private boolean completed;

    public Todo(int userId, int id, String title, boolean completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    protected Todo(Parcel in) {
        userId = in.readInt();
        id = in.readInt();
        title = in.readString();
        completed = in.readByte() != 0;
    }

    public static final Creator<Todo> CREATOR = new Creator<Todo>() {
        @RequiresApi(api = Build.VERSION_CODES.Q)
        @Override
        public Todo createFromParcel(Parcel in) {
            return new Todo(in);
        }

        @Override
        public Todo[] newArray(int size) {
            return new Todo[size];
        }
    };

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(userId);
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeByte((byte) (completed ? 1 : 0));
    }
}
