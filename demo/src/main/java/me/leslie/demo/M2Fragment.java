package me.leslie.demo;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import me.leslie.afv.now.BaseAfvFragment;

/**
 * 介绍：
 * 作者：xjzhao
 * 邮箱：mr.feeling.heart@gmail.com
 * 时间: 2017-02-07  16:49
 */

public class M2Fragment extends BaseAfvFragment {
    private WebView webView;

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected View getLayout() {
        return webView = new WebView(getContext());
    }

    @Override
    protected void initView() {
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                onLoadFinish();
            }
        });
    }

    @Override
    public void onLoad() {
        webView.loadUrl("https://www.baidu.com/");
    }
}