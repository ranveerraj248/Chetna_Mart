package com.example.chetnamart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

import io.grpc.internal.ClientStream;

public class SliderAdapter  extends RecyclerView.Adapter<SliderAdapter.SliderViewHolder>{

    private List<SliderModel> sliderModelList;
    private ViewPager2 viewPager2;

    public SliderAdapter(List<SliderModel> sliderModelList, ViewPager2 viewPager2) {
        this.sliderModelList = sliderModelList;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.slide_image_container,parent,false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        holder.setImage(sliderModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return sliderModelList.size();
    }

    class SliderViewHolder extends RecyclerView.ViewHolder {

        private RoundedImageView imageView;

        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.bannerSlide);
        }
        void setImage(SliderModel sliderModel) {
            //image from the internet code here.

            imageView.setImageResource(sliderModel.getBanner());
        }

    }


}
