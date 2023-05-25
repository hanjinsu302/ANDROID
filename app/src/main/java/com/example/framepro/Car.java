package com.example.framepro;

import android.graphics.drawable.Drawable;

public class Car {
    Drawable image;
    String title;
    String genre;

    public Car(Drawable image,String title, String genre){
        this.image= image;
        this.title= title;
        this.genre= genre;
    }

    public Drawable getImage(){ return image;}
    public void setImage(Drawable image){ this.image=image;}
    public String getTitle() {return  title;}
    public void setTitle(String title){this.title=title;}
    public String getGenre(){return genre;}
    public void setGenre(String genre){ this.genre=genre;}
}
