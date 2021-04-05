package br.edu.uniritter.a2app.model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

public class Album implements Parcelable {
    private int userId, id;
    private String title;

    public Album(int userId, int id, String title) {
        this.userId = userId;
        this.id = id;
        this.title = title;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    protected Album(Parcel in) {
        userId = in.readInt();
        id = in.readInt();
        title = in.readString();
    }

    public static final Creator<Album> CREATOR = new Creator<Album>() {
        @RequiresApi(api = Build.VERSION_CODES.Q)
        @Override
        public Album createFromParcel(Parcel in) {
            return new Album(in);
        }

        @Override
        public Album[] newArray(int size) {
            return new Album[size];
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

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
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
    }
}
