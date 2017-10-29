package com.Jogmedia.Jogmedia.model;

public class Book_Image {
    private  int bookimage_id;
    private String image_desc, image_add;

    public Book_Image(int bookimage_id, String image_desc, String image_add) {
        this.bookimage_id = bookimage_id;
        this.image_desc = image_desc;
        this.image_add = image_add;
    }

    public int getBookimage_id() {
        return bookimage_id;
    }

    public void setBookimage_id(int bookimage_id) {
        this.bookimage_id = bookimage_id;
    }

    public String getImage_desc() {
        return image_desc;
    }

    public void setImage_desc(String image_desc) {
        this.image_desc = image_desc;
    }

    public String getImage_add() {
        return image_add;
    }

    public void setImage_add(String image_add) {
        this.image_add = image_add;
    }
}
