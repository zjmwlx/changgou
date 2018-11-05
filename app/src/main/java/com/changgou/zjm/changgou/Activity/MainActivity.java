package com.changgou.zjm.changgou.Activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.changgou.zjm.changgou.Adapter.MyFragmentAdapter;
import com.changgou.zjm.changgou.Fragment.CartFragment;
import com.changgou.zjm.changgou.Fragment.HoemFragment;
import com.changgou.zjm.changgou.Fragment.HotFragment;
import com.changgou.zjm.changgou.Fragment.MyFragment;
import com.changgou.zjm.changgou.Fragment.SortFragment;
import com.changgou.zjm.changgou.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener{
    /**
     * 底部栏
     */
    private RadioGroup radioGroup;
    /**
     *
     */
    private FrameLayout frameLayout;
    /**
     * 存放fragment的集合
     */
    private List<Fragment> fragments;
    /**
     * fragment的adapter
     */
    private MyFragmentAdapter myFragmentAdapter;
    /**
     * 当前选中的fragment
     */
    private int position = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = findViewById(R.id.framelayout);
        //初始化集合，并添加所有的fragment
        fragments = new ArrayList<>();
        fragments.add(new HoemFragment());
        fragments.add(new HotFragment());
        fragments.add(new SortFragment());
        fragments.add(new CartFragment());
        fragments.add(new MyFragment());
        //初始化radioGroup，并设置监听
        radioGroup = findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(this);
        RBsetDrwable();
        //初始化fragment的adapter
        myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), fragments);
        //第一次进入时执行一次刷新方法，让显示首页
        updateFragment();
    }

    /**
     * radioGroup的监听方法
     * @param group 显示fragment的容器
     * @param checkedId 所选中按钮的ID
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId){
            case R.id.rb_home:
                position = 0;
                break;
            case R.id.rb_hot:
                position = 1;
                break;
            case R.id.rb_sort:
                position = 2;
                break;
            case R.id.rb_cart:
                position = 3;
                break;
            case R.id.rb_my:
                position = 4;
                break;
        }
        updateFragment();
    }

    /**
     * 刷新fragment的显示
     */
    public void updateFragment(){
        Object object =  myFragmentAdapter.instantiateItem(frameLayout,position);
        myFragmentAdapter.setPrimaryItem(frameLayout,0,object);
        myFragmentAdapter.finishUpdate(frameLayout);
    }
    public void RBsetDrwable(){
        RadioButton home = findViewById(R.id.rb_home);
        home.setCompoundDrawables(null,setDrawableSize(R.drawable.selector_home_iocn),null,null);
        RadioButton hot = findViewById(R.id.rb_hot);
        hot.setCompoundDrawables(null,setDrawableSize(R.drawable.selector_hot_iocn),null,null);
        RadioButton sort = findViewById(R.id.rb_sort);
        sort.setCompoundDrawables(null,setDrawableSize(R.drawable.selector_sort_iocn),null,null);
        RadioButton cart = findViewById(R.id.rb_cart);
        cart.setCompoundDrawables(null,setDrawableSize(R.drawable.selector_cart_iocn),null,null);
        RadioButton my = findViewById(R.id.rb_my);
        my.setCompoundDrawables(null,setDrawableSize(R.drawable.selector_my_iocn),null,null);
    }
    public  Drawable setDrawableSize(int drawableId) {
        Drawable drawable = getResources().getDrawable(drawableId);
        drawable.setBounds(0,0,40,40);
        return drawable;
    }

}
