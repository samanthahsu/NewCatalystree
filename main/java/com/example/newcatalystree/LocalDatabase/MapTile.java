package com.example.newcatalystree.LocalDatabase;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "map_tile")
public class MapTile {

    @PrimaryKey (autoGenerate = true)
    private int id;

    @ColumnInfo
    private int x_coordinate;

    @ColumnInfo
    private int y_coordinate;

    @ColumnInfo
    private int drawable_int;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX_coordinate() {
        return x_coordinate;
    }

    public void setX_coordinate(int x_coordinate) {
        this.x_coordinate = x_coordinate;
    }

    public int getY_coordinate() {
        return y_coordinate;
    }

    public void setY_coordinate(int y_coordinate) {
        this.y_coordinate = y_coordinate;
    }

    public int getDrawable_int() {
        return drawable_int;
    }

    public void setDrawable_int(int drawable_int) {
        this.drawable_int = drawable_int;
    }
}