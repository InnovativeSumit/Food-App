package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.myapplication.Adapter.CategoryAdapter;
import com.example.myapplication.Adapter.RecommendedAdapter;
import com.example.myapplication.Domain.RecommendedDomains;
import com.example.myapplication.Domain.FoodDomain;
import com.example.myapplication.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView.Adapter adapter,adapter2;
private RecyclerView recyclerViewCategoryList,recyclerViewPopularList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        recyclerViewPopular();
        bottomNavigation();
    }

    private void bottomNavigation() {
        LinearLayout homeBtn=findViewById(R.id.homeBtn);
        LinearLayout cartBtn=findViewById(R.id.cartBtn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,CartActivity.class));
            }
        });
    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList=findViewById(R.id.View2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodlist=new ArrayList<>();
        foodlist.add(new FoodDomain("Pepperoni pizza","pizza","slices Pepperoni, mozzilla cheese, fresh oregano, ground black pepper, pizza sauce",13.2,5,20,1000));
        foodlist.add(new FoodDomain("Cheese Burger","Burger","Chicken, Gounda chesse, Special sauce, Lettuce, tomato",10.2,5,15,750));
        foodlist.add(new FoodDomain("Farm House pizza","pizza3","Corn, chesse, olive, capcsicum, peroproni, tomato, pizza sauce , basil",15.5,5,20,1100));

        adapter2=new RecommendedAdapter(foodlist);
        recyclerViewPopularList.setAdapter(adapter2);
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList=findViewById(R.id.View1);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<RecommendedDomains> categoryList= new ArrayList<>();
        categoryList.add(new RecommendedDomains("Pizza","cat_1"));
        categoryList.add(new RecommendedDomains("Burger","cat_2"));
        categoryList.add(new RecommendedDomains("HotDog","cat_3"));
        categoryList.add(new RecommendedDomains("Drink","cat_4"));
        categoryList.add(new RecommendedDomains("Donut","cat_5"));

       adapter= new CategoryAdapter(categoryList);
       recyclerViewCategoryList.setAdapter(adapter);

    }
}