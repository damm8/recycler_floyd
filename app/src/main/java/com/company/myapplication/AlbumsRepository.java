package com.company.myapplication;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlbumsRepository {

    LiveData<List<Album>> albumsLiveData;

    AlbumsRepository() {

        List<Album> albums = Arrays.asList(
                new Album("The Piper at the Gates of Dawn", "1967", R.drawable.piper),
                new Album("A Saucerful of Secrets","1968",R.drawable.secrets),
                new Album("Ummagumma","1969",R.drawable.ummagumma),
                new Album("Atom Heart Mother","1970",R.drawable.atom),
                new Album("Meddle","1971",R.drawable.meddle),
                new Album("Obscured by Clouds","1972",R.drawable.clouds),
                new Album("The Dark Side of the Moon","1973",R.drawable.dark),
                new Album("Wish You Were Here","1975",R.drawable.wish),
                new Album("Animals","1977",R.drawable.animals),
                new Album("The Wall","1979",R.drawable.wall),
                new Album("A Collection of Great Dance Songs","1981",R.drawable.dance),
                new Album("The Final Cut","1983",R.drawable.cut),
                new Album("A Momentary Lapse of Reason","1987",R.drawable.lapse),
                new Album("Delicate Sound of Thunder","1988",R.drawable.thunder),
                new Album("Shine On","1992",R.drawable.shineon),
                new Album("The Division Bell","1994",R.drawable.division),
                new Album("Pulse","1995",R.drawable.pulse),
                new Album("The Endless River","2014",R.drawable.river),
                new Album("The Late Years","2019",R.drawable.late)
        );

        albumsLiveData = new MutableLiveData<>(albums);
    }


    LiveData<List<Album>> albums() {
        return albumsLiveData;
    }
}
