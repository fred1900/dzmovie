package com.android.meimi.adapter;

import java.util.ArrayList;
import java.util.List;

 

import com.android.dzdp.movie.R;
import com.android.meimi.bean.MovieBean;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView; 

/**
 * 
 * ��Ӱ�б�������
 * @author ��־��
 * @since JDK 1.7.0
 * @version 20130225-0426
 * @data ����ʱ�䣺2013-11-1 ʱ�䣺����4:51:27
 */
public class MoviesItemAdapter extends BaseAdapter {

	/**��Ӱ�б?��*/
	private List<MovieBean> movies = new ArrayList<MovieBean>();
	/**������*/
	private Context context;
	/**��Ӱ���ͣ�������ӳ ������ӳ��*/
	private int type;

	/**
	 * �����Ĺ��췽��
	 * @param movies ��Ӱ�б�
	 * @param context ������
	 * @param type ��Ӱ����
	 */
	public MoviesItemAdapter(List<MovieBean> movies, Context context, int type) {
		super();
		this.movies = movies;
		this.context = context;
		this.type = type;
	}

	@Override
	public int getCount() {
		return movies.size();
	}

	@Override
	public Object getItem(int position) {
		return movies.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	
	//��ȡ��ʾ��Ӱ�������ͼ
	@Override
	public View getView(int position, View view, ViewGroup parent) {
		//��Ӱ�б��ĳһ��
		MovieBean m = movies.get(position);	
		Holeder holeder = null;
		if (view == null) {
			holeder = new Holeder();
			view = LayoutInflater.from(context).inflate(
					R.layout.movie_item_layout, null);
			//��ʼ���ؼ�
			holeder.photo = (ImageView) view.findViewById(R.id.photo);
			holeder.tag = (ImageView) view.findViewById(R.id.tag);
			holeder.name = (TextView) view.findViewById(R.id.name);
			holeder.type = (TextView) view.findViewById(R.id.label);
			holeder.player = (TextView) view.findViewById(R.id.player);
			holeder.time = (TextView) view.findViewById(R.id.time);
			view.setTag(holeder);
		} else {
			holeder = (Holeder) view.getTag();
		}
		
		//�������
		holeder.name.setText(m.getName());
		holeder.type.setText("类型:" + m.getType());
		holeder.player.setText("主演:" + m.getPlayer());
		holeder.time.setText("时间:" + m.getTime());
		/*Bitmap bm = BitmapFactory.decodeFile(Constants.PIC_PATH + "/"
				+ m.getimage() + ".png");*/
		/*holeder.photo.setImageBitmap(bm);*/
		holeder.photo.setImageResource(R.drawable.head);
		if (type == 1) {
			if (position < 4) {
				holeder.tag.setImageResource(R.drawable.head);
			} else {
				holeder.tag.setImageResource(R.drawable.head);
			}
		} else {
			if (position < 4) {
				holeder.tag.setImageResource(R.drawable.head);
			} else {
				holeder.tag.setImageResource(R.drawable.head);
			}
		}

		return view;
	}

	/**
	 * �Զ����Ӱ�б�Ļ���
	 *����ʱ�� 2013-11-3 ����8:33:52
	 * @author ��־��
	 *
	 */
	class Holeder {
		/**��ӰͼƬ*/
		ImageView photo;
		/**ͼƬ��ǩ*/
		ImageView tag;
		/**��Ӱ���*/
		TextView name;
		/**��Ӱ����*/
		TextView type;
		/**��Ա*/
		TextView player;
		/**��ӳʱ��*/
		TextView time;
	}

}
