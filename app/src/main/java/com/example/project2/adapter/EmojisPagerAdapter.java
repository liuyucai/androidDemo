package com.example.project2.adapter;

import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.project2.MainActivity;
import com.example.project2.charPage.CollectEmojisFragment;
import com.example.project2.charPage.EmojisFragment;

/**
 * Created by Jay on 2015/8/31 0031.
 */
public class EmojisPagerAdapter extends FragmentPagerAdapter {

    private final int PAGER_COUNT = 2;
    private EmojisFragment emojisFragment = null;
    private CollectEmojisFragment collectEmojisFragment = null;

    public EmojisPagerAdapter(FragmentManager fm) {
        super(fm);
        emojisFragment = new EmojisFragment();
        collectEmojisFragment = new CollectEmojisFragment();
    }


    @Override
    public int getCount() {
        return PAGER_COUNT;
    }

    @Override
    public Object instantiateItem(ViewGroup vg, int position) {
        return super.instantiateItem(vg, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        System.out.println("position Destory" + position);
        super.destroyItem(container, position, object);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = emojisFragment;
                break;
            case 1:
                fragment = collectEmojisFragment;
                break;
        }
        return fragment;
    }


}

