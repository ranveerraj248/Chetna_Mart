package com.example.chetnamart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.chetnamart.ui.home.HomePageAdapter;
import com.example.chetnamart.ui.home.HomePageModel;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView categoryRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String title = getIntent().getStringExtra("CategoryName");
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        categoryRecyclerView = findViewById(R.id.category_recyclerview);


        ////////// Banner Slider
        List<SliderModel>sliderModelList = new ArrayList<>();

        sliderModelList.add(new SliderModel(R.drawable.banner_3));
        sliderModelList.add(new SliderModel(R.drawable.banner_4));

        sliderModelList.add(new SliderModel(R.drawable.items_banner));
        sliderModelList.add(new SliderModel(R.drawable.banner_2));
        sliderModelList.add(new SliderModel(R.drawable.banner_3));
        sliderModelList.add(new SliderModel(R.drawable.banner_4));

        sliderModelList.add(new SliderModel(R.drawable.items_banner));
        sliderModelList.add(new SliderModel(R.drawable.banner_2));

        //////////Banner Slider

        ////////Horizontal Product Layout


        List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.horlicks,"Horlicks","Classic Malt","Rs. 225"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.horlicks,"Horlicks","Chocolate Delight Flavour","Rs. 185"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.horlicks,"Horlicks","Vanila Flavour","Rs. 284"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.horlicks,"Horlicks","Classic Malt","Rs. 225"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.horlicks,"Horlicks","Classic Malt","Rs. 225"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.horlicks,"Horlicks","Classic Malt","Rs. 225"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.horlicks,"Horlicks","Classic Malt","Rs. 225"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.horlicks,"Horlicks","Classic Malt","Rs. 225"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.horlicks,"Horlicks","Classic Malt","Rs. 225"));


        ////////Horizontal Product Layout



        ///////////////////////////////////////////////////////

        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(this);
        testingLayoutManager.setOrientation(RecyclerView.VERTICAL);
        categoryRecyclerView.setLayoutManager(testingLayoutManager);

        List<HomePageModel> homePageModelList = new ArrayList<>();
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.strip_banner,"#000000"));
        homePageModelList.add(new HomePageModel(2,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3,"Trending Today",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.strip_banner,"#000000"));
        homePageModelList.add(new HomePageModel(3,"Trending Today",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(2,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.strip_banner,"#ff0000"));

        HomePageAdapter adapter = new HomePageAdapter(homePageModelList);
        categoryRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_icon, menu);
        return true;
    }

    //@Override
    public boolean OnOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.main_search_icon) {
            //todo: search
            return true;
        }else if(id==android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}