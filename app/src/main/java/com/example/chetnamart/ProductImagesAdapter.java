package com.example.chetnamart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.security.AccessController;
import java.util.List;

public class ProductImagesAdapter extends RecyclerView.Adapter<ProductImagesAdapter.ProductImageViewHolder>{

    private List<Integer> productImages;
    private ViewPager2 viewPager2;

    public ProductImagesAdapter(List<Integer> productImages) {
        this.productImages = productImages;
        //this.viewPager2 = viewPager2;
    }



    @NonNull
    @Override
    public ProductImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        parent.addView((View) productImages,0);
        return new ProductImageViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.product_images_layout,parent,false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ProductImageViewHolder holder, int position) {

        //ImageView productImage = new ImageView(container.getContext());
        holder.setImage(productImages.get(position));
    }

    @Override
    public int getItemCount() {
        return productImages.size();
    }

    public class ProductImageViewHolder extends RecyclerView.ViewHolder{

        private ImageView productImage;
        public ProductImageViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = new ImageView(itemView.getContext());
        }


        void setImage(Integer integer) {
            productImage.setImageResource(integer);
        }
    }




    /*public ProductImagesAdapter(List<Integer> productImages) {
        this.productImages = productImages;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView productImage = new ImageView(container.getContext());
        productImage.setImageResource(productImages.get(position));
        container.addView(productImage,0);
        return productImage;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView)object);
    }

    @Override
    public int getCount() {
        return productImages.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

     */
}
