package com.muratalarcin.navigationcomponentkullanimi;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;
import com.muratalarcin.navigationcomponentkullanimi.databinding.FragmentDetayBinding;

public class DetayFragment extends Fragment {
    private FragmentDetayBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetayBinding.inflate(inflater, container, false);

        DetayFragmentArgs bundle = DetayFragmentArgs.fromBundle(getArguments());
        String gelenAd = bundle.getAd();
        int gelenYas = bundle.getYas();
        float gelenBoy = bundle.getBoy();
        boolean gelenBekar = bundle.getBekar();

        Urunler gelenUrun = bundle.getUrun();
        int urunId = gelenUrun.getId();
        String urunAd = gelenUrun.getAd();

        binding.textViewDetay.setText(gelenAd +" - " + gelenBoy + " - " + gelenYas + " - " + gelenBekar + " - " + urunId + " - " + urunAd);

        OnBackPressedCallback geriTusu = new OnBackPressedCallback(true) {//true : geri dönüş aktif değil
            @Override
            public void handleOnBackPressed() {
                Snackbar.make(binding.textViewDetay, "Geri Dönmek İstiyor Musunuz?", Snackbar.LENGTH_SHORT)
                        .setAction("Evet", view -> {
                            setEnabled(false);
                            requireActivity().getOnBackPressedDispatcher().onBackPressed();
                        }).show();
            }
        };

        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), geriTusu);

        return binding.getRoot();
    }
}