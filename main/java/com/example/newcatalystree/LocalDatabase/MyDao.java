package com.example.newcatalystree.LocalDatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface MyDao {

    @Insert
    public void addMapTile(MapTile mapTile);

    @Query("select * from map_tile") // map_table is table name
    public List<MapTile> getMap(); // todo error: There is a problem with the query: [SQLITE_ERROR] SQL error or missing database (no such table: map)

    @Delete
    public void deleteMapBlock(MapTile mapTile);

    @Update
    public void updateMapBlock(MapTile mapTile);

}