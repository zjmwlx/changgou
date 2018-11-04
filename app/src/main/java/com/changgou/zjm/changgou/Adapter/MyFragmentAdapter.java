package com.changgou.zjm.changgou.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.changgou.zjm.changgou.Fragment.CartFragment;
import com.changgou.zjm.changgou.Fragment.HoemFragment;
import com.changgou.zjm.changgou.Fragment.HotFragment;
import com.changgou.zjm.changgou.Fragment.MyFragment;
import com.changgou.zjm.changgou.Fragment.SortFragment;

import java.util.List;

public class MyFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    public MyFragmentAdapter(FragmentManager fm, List fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = null;
        switch (i) {
            case 0:
                fragment = new HoemFragment();
                break;
            case 1:
                fragment = new HotFragment();
                break;
            case 2:
                fragment = new SortFragment();
                break;
            case 3:
                fragment = new CartFragment();
                break;
            case 4:
                fragment = new MyFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
