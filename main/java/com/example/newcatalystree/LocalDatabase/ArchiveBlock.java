package com.example.newcatalystree.LocalDatabase;


//this is the ArchiveBlock class object definition
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.drawable.Drawable;

@Entity
public class ArchiveBlock {

    @PrimaryKey
    private int id;

    @ColumnInfo
    private String title;

    @ColumnInfo
    private Drawable thumb;

    @ColumnInfo
    private String info;

    @ColumnInfo
    private boolean show;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Drawable getThumb() {
        return thumb;
    }

    public String getInfo() {
        return info;
    }

    public String getTitle() {
        return title;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setThumb(Drawable thumb) {
        this.thumb = thumb;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
}
