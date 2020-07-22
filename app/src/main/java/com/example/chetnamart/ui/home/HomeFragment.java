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

    ////////// Banner Slider
    private ViewPager2 bannerSliderViewPager;
    private List<SliderModel> sliderModelList;
    private int currentPage = 2;
    private Timer timer;
    final private long DELAY_TIME = 1500;
    final private long PERIOD_TIME = 1500;
    /////////Banner Slider

    /////////Strip Ad
    private ImageView stripAdImage;
    private ConstraintLayout stripAdContainer;
    ////////Strip Ad

    ////////Horizontal Product Layout

    private TextView horizontalLayoutTitle;
    private Button horizontalLayoutViewAllBtn;
    private RecyclerView horizontalRecyclerView;

    ////////Horizontal Product Layout



    @SuppressLint("ClickableViewAccessibility")
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home,container,false);

        categoryRecyclerView = view.findViewById(R.id.category_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);

        List<CategoryModel> categoryModelList = new ArrayList<CategoryModel>();
        categoryModelList.add(new CategoryModel("link","Home"));
        categoryModelList.add(new CategoryModel("link","Electronics"));
        categoryModelList.add(new CategoryModel("link","Appliences"));
        categoryModelList.add(new CategoryModel("link","Corona"));

        categoryAdapter = new CategoryAdapter(categoryModelList);
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();

        ////////// Banner Slider
        bannerSliderViewPager = view.findViewById(R.id.vpBannerSlider);
        sliderModelList = new ArrayList<>();

        sliderModelList.add(new SliderModel(R.drawable.banner_3));
        sliderModelList.add(new SliderModel(R.drawable.banner_4));

        sliderModelList.add(new SliderModel(R.drawable.items_banner));
        sliderModelList.add(new SliderModel(R.drawable.banner_2));
        sliderModelList.add(new SliderModel(R.drawable.banner_3));
        sliderModelList.add(new SliderModel(R.drawable.banner_4));

        sliderModelList.add(new SliderModel(R.drawable.items_banner));
        sliderModelList.add(new SliderModel(R.drawable.banner_2));

        //SliderAdapter sliderAdapter = new SliderAdapter(sliderModelList);
        bannerSliderViewPager.setAdapter(new SliderAdapter(sliderModelList,bannerSliderViewPager));
        bannerSliderViewPager.setClipToPadding(false);
        bannerSliderViewPager.setClipChildren(false);
        bannerSliderViewPager.setOffscreenPageLimit(3);
        bannerSliderViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });

        bannerSliderViewPager.setPageTransformer(compositePageTransformer);

        bannerSliderViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                currentPage = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
                if(state ==ViewPager2.SCROLL_STATE_IDLE){
                    pageLooper();
                }
            }
        });


        startBannerSlideShow();
        bannerSliderViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                pageLooper();
                stopBannerSlideShow();
                if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    startBannerSlideShow();
                }
                return false;
            }
        });
        ////////// Banner Slider

        /////////Strip Ad
        stripAdImage =  view.findViewById(R.id.strip_ad_image);
        stripAdContainer = view.findViewById(R.id.strip_ad_container);

        stripAdImage.setImageResource(R.drawable.strip_banner);
        stripAdImage.setBackgroundColor(getResources().getColor(R.color.backgroundGreen));
        /////////Strip Ad

        ////////Horizontal Product Layout

        horizontalLayoutTitle = view.findViewById(R.id.horizontal_scroll_layout_title);
        horizontalLayoutViewAllBtn = view.findViewById(R.id.horizontal_scroll_view_all_button);
        horizontalRecyclerView = view.findViewById(R.id.horizontal_scroll_layout_recyclerview);

        List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.horlicks,"Horlicks","Classic Malt","Rs. 225"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.horlicks,"Horlicks","Chocolate Delight Flavour","Rs. 185"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.horlicks,"Horlicks","Vanila Flavour","Rs. 284"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.horlicks,"Horlicks","Classic Malt","Rs. 225"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.horlicks,"Horlicks","Classic Malt","Rs. 225"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.horlicks,"Horlicks","Classic Malt","Rs. 225"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.horlicks,"Horlicks","Classic Malt","Rs. 225"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.horlicks,"Horlicks","Classic Malt","Rs. 225"));


        HorizontalProductScrollAdapter horizontalProductScrollAdapter = new HorizontalProductScrollAdapter(horizontalProductScrollModelList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        horizontalRecyclerView.setLayoutManager(linearLayoutManager);

        horizontalRecyclerView.setAdapter(horizontalProductScrollAdapter);
        horizontalProductScrollAdapter.notifyDataSetChanged();

        ////////Horizontal Product Layout

        ////////  Grid Product layout

        TextView gridLayoutTitle = view.findViewById(R.id.grid_product_layout_title);
        Button gridlayoutViewAllBtn = view.findViewById(R.id.grid_product_viewAll_btn);
        GridView gridView = view.findViewById(R.id.grid_product_layout_gridview);

        gridView.setAdapter(new GridProductLayoutAdapter(horizontalProductScrollModelList));

        //////// Grid Product layout

        return view;
    }

    ////////// Banner Slider
    private void pageLooper(){
        if(currentPage == sliderModelList.size()-2){
            currentPage = 2;
            bannerSliderViewPager.setCurrentItem(currentPage,false);
        }
        if(currentPage == 1){
            currentPage = sliderModelList.size() -3;
            bannerSliderViewPager.setCurrentItem(currentPage,false);
        }
    }

    private void startBannerSlideShow(){
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if(currentPage >=sliderModelList.size()){
                    currentPage = 1;
                }
                bannerSliderViewPager.setCurrentItem(currentPage++,true);
            }
        };
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        },DELAY_TIME,PERIOD_TIME);
    }
    private void stopBannerSlideShow(){
        timer.cancel();
    }
    ////////// Banner Slider
}