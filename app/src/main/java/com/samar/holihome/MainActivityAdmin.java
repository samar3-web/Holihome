package com.samar.holihome;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.samar.holihome.adapter.DiscountedProductAdapter;
import com.samar.holihome.adapter.RecentlyViewedAdapter;
import com.samar.holihome.model.DiscountedProducts;
import com.samar.holihome.model.RecentlyViewed;

import java.util.ArrayList;
import java.util.List;

public class MainActivityAdmin extends AppCompatActivity {
    ImageView img;
    RecyclerView discountRecyclerView, recentlyViewedRecycler;
    DiscountedProductAdapter discountedProductAdapter;
    List<DiscountedProducts> discountedProductsList;


    RecentlyViewedAdapter recentlyViewedAdapter;
    List<RecentlyViewed> recentlyViewedList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        discountRecyclerView = findViewById(R.id.discountedRecycler);
        recentlyViewedRecycler = findViewById(R.id.recently_item);
        img = findViewById(R.id.imageView1);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivityAdmin.this, Add.class);
                startActivity(i);


            }
        });




        // adding data to model
        discountedProductsList = new ArrayList<>();
        discountedProductsList.add(new DiscountedProducts(1, R.drawable.dd));
        discountedProductsList.add(new DiscountedProducts(2, R.drawable.ss));
        discountedProductsList.add(new DiscountedProducts(3,R.drawable.discount30jpg));
        discountedProductsList.add(new DiscountedProducts(4, R.drawable.dd));
        discountedProductsList.add(new DiscountedProducts(5, R.drawable.ss));
        discountedProductsList.add(new DiscountedProducts(6,R.drawable.discount30jpg ));

        // adding data to model
        recentlyViewedList = new ArrayList<>();
        recentlyViewedList.add(new RecentlyViewed(" L???appartement du Palais ?? La Marsa", "Appartement avec entr??e Ind??pendante situ?? dans un palais du XIX si??cle en plein c??ur de la Marsa ", " 388 TND/Nuit", R.drawable.card1, R.drawable.discount1));
        recentlyViewedList.add(new RecentlyViewed("S??jour en classe affaire: Apt de luxe ?? Sidi Daoud", "S??jour en classe affaire! Ce superbe appartement, luxueux et ultra confortable se trouve dans une r??sidence haut de gamme ?? sidi Daoued", "210 TND/Nuit",R.drawable.card2,R.drawable.discount2));
        recentlyViewedList.add(new RecentlyViewed("Le Premium: Central, luxueux et tr??s confortable", "Luxueux appartement dans une r??sidence s??curis??e et tr??s bien situ??e ?? Sidi Daoud, La Marsa. Ce logement est d??cor?? avec beaucoup de go??t et est enti??rement ??quip??.", "329 TND/Nuit",R.drawable.card3,R.drawable.h2));
        recentlyViewedList.add(new RecentlyViewed("Les Ambassadeurs: Appartement grand luxe aux Berges du Lac 2", "Les Ambassadeurs est un des plus beaux appartements de la capitale. Situ??e dans une r??sidence ultra luxe .", "1.130TND/Nuit" ,R.drawable.card4,R.drawable.h4));

        setDiscountRecycler(discountedProductsList);
        setRecentlyViewedRecycler(recentlyViewedList);


    }

    private void setRecentlyViewedRecycler(List<RecentlyViewed> recentlyViewedDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recentlyViewedRecycler.setLayoutManager(layoutManager);
        recentlyViewedAdapter = new RecentlyViewedAdapter(this,recentlyViewedDataList);
        recentlyViewedRecycler.setAdapter(recentlyViewedAdapter);
    }

    private void setDiscountRecycler(List<DiscountedProducts> dataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        discountRecyclerView.setLayoutManager(layoutManager);
        discountedProductAdapter = new DiscountedProductAdapter(this,dataList);
        discountRecyclerView.setAdapter(discountedProductAdapter);
    }



}