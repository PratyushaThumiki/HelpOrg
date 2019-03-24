package com.example.thumikipratyusha.capstone_stage2.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ImpDao {

    @Query("SELECT * FROM important")
    LiveData<List<ImportantModel>> getAllSchemes();

    @Query("SELECT * FROM important WHERE imp_id = :impid")
    ImportantModel checkifExists(String impid);

    @Insert
    void insertImp(ImportantModel importantModel);

   // @Query("DELETE  FROM important WHERE id = :id")
   @Query("DELETE FROM important WHERE imp  _id = :impid")
    void deleteImp(String impid);
}
