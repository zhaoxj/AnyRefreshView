package me.leslie.afv.past;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import me.leslie.afv.base.BaseAnyRefreshViewFragment;
import me.leslie.afv.base.OnLoadListener;

/**
 * 介绍：
 * 作者：xjzhao
 * 邮箱：mr.feeling.heart@gmail.com
 * 时间: 2017-02-07  18:00
 */

public abstract class BasePastAfvFragment extends BaseAnyRefreshViewFragment implements OnLoadListener, OnPastScrollListener{
    private PastAfvScrollView scrollView;

    @Override
    public boolean isRefreshEnable() {
        return true;
    }

    @Override
    protected View getLayout() {
        return null;
    }

    @Override
    public void onAutoRefresh(){
        if (null != scrollView){
            scrollView.onAutoRefresh();
        }
    }

    @Override
    public void onLoadFinish(){
        if (null != scrollView){
            scrollView.stopRefresh(true);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        scrollView = new PastAfvScrollView(getContext());
        if (getLayoutId() > 0) {
            LayoutInflater.from(getContext()).inflate(getLayoutId(), scrollView, true);
        }else if (null != getLayout()){
            scrollView.addView(getLayout(), new ScrollView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        }
        scrollView.setOnLoadListener(this);
        scrollView.setOnScrollListener(this);
        scrollView.setEnabled(isRefreshEnable());
        initView();
        container.getHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onAutoRefresh();
            }
        }, 300);
        return scrollView;
    }


    @Override
    public void onScroll(float dy) {

    }

    @Override
    public void dissScroll(){

    }
}
