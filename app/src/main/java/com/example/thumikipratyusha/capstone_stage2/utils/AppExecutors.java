package com.example.thumikipratyusha.capstone_stage2.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppExecutors {


    //for singleton instatition
    private static final Object LOCK=new Object();
    private static AppExecutors sInstance;
    private final Executor diskIO;

    //diskio is a single thread executor and this ensures our
    //databse transactions are done in order
    public AppExecutors(Executor diskIO) {
        this.diskIO = diskIO;
    }
    public static AppExecutors getInstance(){
        if (sInstance==null){
            synchronized (LOCK){
                sInstance=new AppExecutors(Executors.newSingleThreadExecutor());
            }
        }
        return sInstance;
    }

    public Executor diskIO() {
        return diskIO;
    }
}