package com.helloandroid.yieron.yieron.ui.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.helloandroid.yieron.yieron.R;
import com.helloandroid.yieron.yieron.adapter.FruitAdapter;
import com.helloandroid.yieron.yieron.model.Fruit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecycleViewActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        initFruits();
        RecyclerView recyclerView = (RecyclerView) this.findViewById(R.id.id_recycleView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        FruitAdapter fruitAdapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(fruitAdapter);
    }

    private void initFruits() {
        for (int i = 0; i < 10; i++) {
            Fruit apple = new Fruit(getRandomLengthName("Apple"));
            fruitList.add(apple);
            Fruit banana = new Fruit(getRandomLengthName("banana"));
            fruitList.add(banana);
            Fruit orange = new Fruit(getRandomLengthName("orange"));
            fruitList.add(orange);
            Fruit grape = new Fruit(getRandomLengthName("grape"));
            fruitList.add(grape);
        }
    }

    private String getRandomLengthName(String name){
        Random random = new Random();
        int nameLength = random.nextInt(20) + 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < nameLength; i++) {
            stringBuilder.append(name);
        }
        return  stringBuilder.toString();
    }
}
