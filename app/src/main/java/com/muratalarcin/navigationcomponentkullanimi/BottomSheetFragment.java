package com.muratalarcin.navigationcomponentkullanimi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.snackbar.Snackbar;
import com.muratalarcin.navigationcomponentkullanimi.databinding.FragmentBottomSheetBinding;

public class BottomSheetFragment extends BottomSheetDialogFragment {//burdaki extends i elle yazıyoruz
    private FragmentBottomSheetBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBottomSheetBinding.inflate(inflater, container,false);

        binding.imageViewPaylas.setOnClickListener(view -> {
            Snackbar.make(view, "Paylaşıldı", Snackbar.LENGTH_LONG).show();
        });

        binding.imageViewKopyala.setOnClickListener(view -> {
            Snackbar.make(view, "Kopyalandı", Snackbar.LENGTH_LONG).show();
        });

        return binding.getRoot();
    }
}