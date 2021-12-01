package com.example.submission2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.submission2.databinding.ActivityDetailBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class DetailActivity extends AppCompatActivity {

    public static final String GET_DATA = "get data";

    private ActivityDetailBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getParcelabel();
//        settingTab();
    }

//    private void settingTab() {
//        final int[] TAB_TITLE = new int[]{
//                R.string.follower,
//                R.string.following
//        };
//
//        SectionPagerAdapter sectionPagerAdapter = new SectionPagerAdapter(this);
//        ViewPager2 viewPager2 = binding.viewPager;
//        viewPager2.setAdapter(sectionPagerAdapter);
//
//        TabLayout tabs = binding.tabs;
//        new TabLayoutMediator(tabs, viewPager2, (tab, position) ->
//                tab.setText(getResources().getString(TAB_TITLE[position]))).attach();
//
//        if (getSupportActionBar() != null) {
//            getSupportActionBar().setElevation(0);
//        }
//    }

    private void getParcelabel() {
        Model model = getIntent().getParcelableExtra(GET_DATA);

        if (model != null) {
            binding.tvDetailUsername.setText(model.getUsername());
            binding.tvDetailName.setText(model.getName());
            binding.tvDetailLocation.setText(model.getLocation());
            binding.tvDetailCompany.setText(model.getCompany());
            binding.tvDetailRepository.setText(new StringBuilder(" ").append(model.getRepository()));

            Glide.with(this)
                    .load(model.getAvatar())
                    .circleCrop()
                    .into(binding.imgDetailPhoto);

        }
    }
}