package com.android.meimi.activity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.android.dzdp.movie.R;
import com.android.meimi.adapter.ArticleAdapter;
import com.android.meimi.adapter.MoviesItemAdapter;
import com.android.meimi.bean.Article;
import com.android.meimi.bean.MovieBean;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.LocationClientOption.LocationMode;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.handmark.pulltorefresh.library.PullToRefreshExpandableListView;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

public class MainActivity extends Activity implements
		OnRefreshListener2<ListView>, OnClickListener {
	private LocationClient mLocationClient;

	private LocationMode tempMode = LocationMode.Hight_Accuracy;

	@ViewInject(R.id.article_list)
	private PullToRefreshListView listView;
	@ViewInject(R.id.location)
	private TextView locationText;
	Handler myHandler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 1:
				locationText
						.setText(((LocationApplication) getApplication()).myLocation
								.getCity()
								+ "longtitude"
								+ String.valueOf(((LocationApplication) getApplication()).myLocation
										.getLongitude())
								+ "latitude"
								+ String.valueOf(((LocationApplication) getApplication()).myLocation
										.getLatitude()));

				break;
			}
			super.handleMessage(msg);
		}
	};

	@SuppressLint("InlinedApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ViewUtils.inject(this);
		List<MovieBean> movieList = new ArrayList();
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		MovieBean movie = new MovieBean(11, "dasheng", "武侠", dateString,
				"asfsdf", R.drawable.head);
		movieList.add(movie);
		movieList.add(movie);
		movieList.add(movie);
		movieList.add(movie);
		movieList.add(movie);
		movieList.add(movie);
		final MoviesItemAdapter movieAdapter = new MoviesItemAdapter(movieList,
				this, 1);
		listView.setAdapter(movieAdapter);
		// 沉侵
		if (VERSION.SDK_INT >= VERSION_CODES.KITKAT) {
			getWindow().addFlags(
					WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			getWindow().addFlags(
					WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
		}
		listView.setMode(Mode.BOTH);
		listView.setOnRefreshListener(this);
		// refresh初始化
		init();
		myHandler.sendEmptyMessageDelayed(1, 30000);
	}

	private void init() {
		ILoadingLayout startLabels = listView
				.getLoadingLayoutProxy(true, false);
		startLabels.setPullLabel("下拉刷新...");// 刚下拉时，显示的提示
		startLabels.setRefreshingLabel("正在载入...");// 刷新时
		startLabels.setReleaseLabel("放开刷新...");// 下来达到一定距离时，显示的提示
		ILoadingLayout endLabels = listView.getLoadingLayoutProxy(false, true);
		endLabels.setPullLabel("上拉刷新...");// 刚下拉时，显示的提示
		endLabels.setRefreshingLabel("正在载入...");// 刷新时
		endLabels.setReleaseLabel("放开刷新...");// 下来达到一定距离时，显示的提示
		// 百度地图初始化
		mLocationClient =((LocationApplication) this.getApplication()).mLocationClient;
		initLocation();
		mLocationClient.start();// 定位SDK
								// start之后会默认发起一次定位请求，开发者无须判断isstart并主动调用request
		mLocationClient.requestLocation();
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		}
	}
	@Override
	public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
		// TODO Auto-generated method stub
		Toast.makeText(getBaseContext(), "下拉刷新", Toast.LENGTH_SHORT).show();
		new AsyncTask<Void, Void, Void>() {
			@Override
			protected Void doInBackground(Void... params) {
				// 处理刷新任务
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return null;
			}

			@Override
			protected void onPostExecute(Void reslst) {
				// 更行内容，通知 PullToRefresh 刷新结束
				listView.onRefreshComplete();
			}
		}.execute();
	}

	@Override
	public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
		// TODO Auto-generated method stub
		Toast.makeText(getBaseContext(), "上拉刷新", Toast.LENGTH_SHORT).show();
		new AsyncTask<Void, Void, Void>() {
			@Override
			protected Void doInBackground(Void... params) {
				// 处理刷新任务
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return null;
			}

			@Override
			protected void onPostExecute(Void reslst) {
				// 更行内容，通知 PullToRefresh 刷新结束
				listView.onRefreshComplete();
			}
		}.execute();
	}

	private void initLocation() {
		LocationClientOption option = new LocationClientOption();
		option.setLocationMode(tempMode);// 可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
		option.setCoorType("gcj02");// 可选，默认gcj02，设置返回的定位结果坐标系，
		int span = 1000;
		option.setIsNeedAddress(true);
		option.setScanSpan(span);// 可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
		// option.setIsNeedAddress(checkGeoLocation.isChecked());//可选，设置是否需要地址信息，默认不需要
		option.setOpenGps(true);// 可选，默认false,设置是否使用gps
		option.setLocationNotify(true);// 可选，默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
		option.setIgnoreKillProcess(true);// 可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
		mLocationClient.setLocOption(option);
	}

}
