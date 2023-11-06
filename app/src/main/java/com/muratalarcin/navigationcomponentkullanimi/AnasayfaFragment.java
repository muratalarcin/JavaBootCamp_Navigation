package com.muratalarcin.navigationcomponentkullanimi;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.muratalarcin.navigationcomponentkullanimi.databinding.FragmentAnasayfaBinding;


public class AnasayfaFragment extends Fragment {
    private FragmentAnasayfaBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false);//attach to root başka tasarım ekleme durumunu soruyo

        binding.buttonDetay.setOnClickListener(view -> {//burada view görüntüyü taemsil ediyo, yanibuttuon edittext falan.
            //binding.textViewAnasayfa.setText("Merhaba");
            Urunler urun = new Urunler(100, "TV");

            AnasayfaFragmentDirections.DetayGecis gecis = AnasayfaFragmentDirections.detayGecis(urun);
            gecis.setAd("Ahmet");
            gecis.setYas(23);
            gecis.setBoy(1.78f);
            gecis.setBekar(true);

            Navigation.findNavController(view).navigate(gecis);// Buttonun içinde view olduğundan direkt aldık. Olmasaydı binding.buttonDetay dişycektik misal
        });

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("Yaşam Döngüsü", "onCreate");
        //Uygulama çalışınca 1 kez çalışır
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("Yaşam Döngüsü", "onResume");
        //Sayfa her görüntülendiğinde
        //sayfaya geri dönülmesi de dahil, ileri geri ful gezerken bu sayfa görüldüğünde içindekileri çalıştırır
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("Yaşam Döngüsü", "onPause");
        //sayfa her görünmez olduğunda. Yani başka sayfaya geçtik falan, o zaman bunun içi çalışır
    }

}