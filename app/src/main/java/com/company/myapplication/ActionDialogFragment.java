package com.company.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.company.myapplication.databinding.FragmentActionDialogBinding;
import com.company.myapplication.databinding.FragmentAlbumsBinding;


public class ActionDialogFragment extends DialogFragment {

    private AlbumsViewModel albumsViewModel;
    private NavController navController;
    private FragmentActionDialogBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentActionDialogBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        albumsViewModel = new ViewModelProvider(this).get(AlbumsViewModel.class);
        navController = Navigation.findNavController(getParentFragment().getView());

        binding.eliminar.setOnClickListener(v -> {
            // tenemos el albumseleccionado en la variable   albumsViewModel.selectedAlbum;
        });

        binding.editar.setOnClickListener(v -> {
            // tenemos el albumseleccionado en la variable   albumsViewModel.selectedAlbum;
        });
    }
}