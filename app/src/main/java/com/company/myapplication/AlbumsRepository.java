package com.company.myapplication;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class AlbumsRepository {

    LiveData<List<Album>> albumsLiveData;

    AlbumsRepository() {

        List<Album> albums = new ArrayList<>();
        albums.add(new Album("The Piper at the Gates of Dawn", "1967", R.drawable.piper));
        albums.add(new Album("A Saucerful of Secrets","1968",R.drawable.secrets));
        albums.add(new Album("Ummagumma","1969",R.drawable.ummagumma));
        albums.add(new Album("Atom Heart Mother","1970",R.drawable.atom));
        albums.add(new Album("Meddle","1971",R.drawable.meddle));
        albums.add(new Album("Obscured by Clouds","1972",R.drawable.clouds));
        albums.add(new Album("The Dark Side of the Moon","1973",R.drawable.dark));
        albums.add(new Album("Wish You Were Here","1975",R.drawable.wish));
        albums.add(new Album("Animals","1977",R.drawable.animals));
        albums.add(new Album("The Wall","1979",R.drawable.wall));
        albums.add(new Album("A Collection of Great Dance Songs","1981",R.drawable.dance));
        albums.add(new Album("The Final Cut","1983",R.drawable.cut));
        albums.add(new Album("A Momentary Lapse of Reason","1987",R.drawable.lapse));
        albums.add(new Album("Delicate Sound of Thunder","1988",R.drawable.thunder));
        albums.add(new Album("Shine On","1992",R.drawable.shineon));
        albums.add(new Album("The Division Bell","1994",R.drawable.division));
        albums.add(new Album("Pulse","1995",R.drawable.pulse));
        albums.add(new Album("The Endless River","2014",R.drawable.river));
        albums.add(new Album("The Late Years","2019",R.drawable.late));

        albumsLiveData = new MutableLiveData<>(albums);


    }


    LiveData<List<Album>> albums() {
        return albumsLiveData;
    }
}
