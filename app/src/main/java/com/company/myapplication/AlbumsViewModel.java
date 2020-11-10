package com.company.myapplication;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class AlbumsViewModel extends AndroidViewModel {

    AlbumsRepository albumsRepository;

    public AlbumsViewModel(@NonNull Application application) {
        super(application);

        albumsRepository = new AlbumsRepository();
    }


    LiveData<List<Album>> albums() {

        return albumsRepository.albums();
    }
}
