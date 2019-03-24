package com.example.thumikipratyusha.capstone_stage2.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "important")
public class ImportantModel {


    public ImportantModel(int id, String title, boolean favorite) {
        this.id = id;
        this.title=title;
        this.favourite=favorite;
    }

    @Ignore
    public ImportantModel(String impid,boolean favourite) {
        this.impid=impid;
        this.favourite=favourite;

    }

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name="title")
    private String title;
    @ColumnInfo(name="impid")
    private String impid;

    private boolean favourite;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImpid(String impid) {
        this.impid = impid;
    }


    public String getImpid() {
        return impid;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }
}

