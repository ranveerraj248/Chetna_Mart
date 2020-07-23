package com.example.chetnamart.ui.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.example.chetnamart.CategoryAdapter;
import com.example.chetnamart.CategoryModel;
import com.example.chetnamart.GridProductLayoutAdapter;
import com.example.chetnamart.HorizontalProductScrollAdapter;
import com.example.chetnamart.HorizontalProductScrollModel;
import com.example.chetnamart.R;
import com.example.chetnamart.SliderAdapter;
import com.example.chetnamart.SliderModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {


    public HomeFragment() {

    }

    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;
    private RecyclerView testing;


    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home,container,false);

        categoryRecyclerView = view.findViewById(R.id.category_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);

        final List<CategoryModel> categoryModelList = new ArrayList<CategoryModel>();
        categoryModelList.add(new CategoryModel("link","Home"));
        categoryModelList.add(new CategoryModel("link","Electronics"));
        categoryModelList.add(new CategoryModel("link","Appliences"));
        categoryModelList.add(new CategoryModel("link","Corona"));

        categoryAdapter = new CategoryAdapter(categoryModelList);
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();

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
        testing = view.findViewById(R.id.home_page_recyclerview);
        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(getContext());
        testingLayoutManager.setOrientation(RecyclerView.VERTICAL);
        testing.setLayoutManager(testingLayoutManager);

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
        testing.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        /////////////////////////////////////////////////////////

        return view;
    }


}