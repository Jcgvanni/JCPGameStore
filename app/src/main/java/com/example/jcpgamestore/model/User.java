package com.example.jcpgamestore.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class User implements Serializable {

    private int id;

    private String fullName;

    private String email;

    private String address;

    private String password;

    public User() {
    }

    protected User(Parcel in) {
        id = in.readInt();
        fullName = in.readString();
        email = in.readString();
        address = in.readString();
        password = in.readString();
    }

//    public static final Creator<User> CREATOR = new Creator<User>() {
//        @Override
//        public User createFromParcel(Parcel in) {
//            return new User( in );
//        }
//
//        @Override
//        public User[] newArray(int size) {
//            return new User[size];
//        }
//    };
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeInt( id );
//        dest.writeString( fullName );
//        dest.writeString( email );
//        dest.writeString( address );
//        dest.writeString( password );
//    }
//
//    @Override
//    public int describeContents() {
//        return 0;
//    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
