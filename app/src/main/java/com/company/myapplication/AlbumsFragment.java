package com.company.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.company.myapplication.databinding.FragmentAlbumsBinding;
import com.company.myapplication.databinding.ViewholderAlbumBinding;

import java.util.List;
import java.util.NavigableMap;


public class AlbumsFragment extends Fragment {

    FragmentAlbumsBinding binding;
    AlbumsViewModel albumsViewModel;
    NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentAlbumsBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        albumsViewModel = new ViewModelProvider(this).get(AlbumsViewModel.class);
        navController = Navigation.findNavController(view);

        AlbumsAdapter albumsAdapter = new AlbumsAdapter();
        binding.recyclerView.setAdapter(albumsAdapter);

        //        binding.recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));

        albumsViewModel.albums().observe(getViewLifecycleOwner(), new Observer<List<Album>>() {
            @Override
            public void onChanged(List<Album> albums) {
                albumsAdapter.setAlbumList(albums);
            }
        });
    }


    class AlbumsAdapter extends RecyclerView.Adapter<AlbumViewHolder> {

        List<Album> albumList;

        @NonNull
        @Override
        public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AlbumViewHolder(ViewholderAlbumBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
            Album album = albumList.get(position);

            holder.binding.titulo.setText(album.titulo);
            holder.binding.anyo.setText(album.anyo);
            Glide.with(holder.itemView).load(album.portada).into(holder.binding.portada);

            holder.itemView.setOnLongClickListener(view -> {
                albumsViewModel.setSelectedAlbum(album);

                navController.navigate(R.id.actionDialogFragment);
                return false;
            });
        }

        @Override
        public int getItemCount() {
            return albumList == null ? 0 : albumList.size();
        }

        public void setAlbumList(List<Album> albumList) {
            this.albumList = albumList;
            notifyDataSetChanged();
        }
    }

    class AlbumViewHolder extends RecyclerView.ViewHolder {
        ViewholderAlbumBinding binding;

        public AlbumViewHolder(@NonNull ViewholderAlbumBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}