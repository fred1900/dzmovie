package com.android.meimi.adapter;

import java.util.ArrayList;
import java.util.List;

 

import com.android.dzdp.movie.R;
import com.android.meimi.bean.Article; 
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ArticleAdapter extends MyBaseAdapter{
	
	List<Article> articleList=new ArrayList();

	public ArticleAdapter(List list, Context context) {
		super(list, context);
		articleList=list;
		// TODO Auto-generated constructor stub
	}

	@Override
	public View createView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder vh = null;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.article_item, parent,
					false);
			vh = new ViewHolder();
			ViewUtils.inject(vh, convertView);
			convertView.setTag(vh);
		} else {
			vh = (ViewHolder) convertView.getTag();
		}
 
		vh.articleTitle.setText(articleList.get(position).getTitle());
		vh.userName.setText(articleList.get(position).getUser_name());
		vh.articleOrigin.setText(articleList.get(position).getOrigin());
		vh.userHead.setImageResource(R.drawable.head);
		vh.articleCover.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.cover));
		return convertView; 
	}
	public static class ViewHolder {
		@ViewInject(R.id.article_title)
		private TextView articleTitle;
		@ViewInject(R.id.user_head)
		private ImageView userHead;
		@ViewInject(R.id.user_name)
		private TextView userName;
		@ViewInject(R.id.article_cover)
		private RelativeLayout articleCover;
		@ViewInject(R.id.article_origin)
		private TextView articleOrigin;
	}

}
