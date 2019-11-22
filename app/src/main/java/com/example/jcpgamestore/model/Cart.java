package com.example.jcpgamestore.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Cart implements Serializable {

    private int userId;

    private User user;

    private int productId;

    private DataGame product;

    private Double quantity;

    public Cart() {
    }

    protected Cart(Parcel in) {
        userId = in.readInt();
        productId = in.readInt();
        product = in.readParcelable( DataGame.class.getClassLoader() );
        user = in.readParcelable( User.class.getClassLoader() );
        if (in.readByte() == 0) {
            quantity = null;
        } else {
            quantity = in.readDouble();
        }
    }

//    public static final Creator<Cart> CREATOR = new Creator<Cart>() {
//        @Override
//        public Cart createFromParcel(Parcel in) {
//            return new Cart( in );
//        }
//
//        @Override
//        public Cart[] newArray(int size) {
//            return new Cart[size];
//        }
//    };

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public DataGame getProduct() {
        return product;
    }

    public void setProduct(DataGame product) {
        this.product = product;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

//    @Override
    public int describeContents() {
        return 0;
    }

//    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeInt( userId );
        parcel.writeInt( productId );
        parcel.writeDouble( quantity );
        parcel.writeValue( product );
        parcel.writeValue( user );
    }

}
