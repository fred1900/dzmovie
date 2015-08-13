package com.android.meimi.bean;

import java.io.Serializable;

/*
  文章列表
  接口：article/getArticleList
  */
import java.util.List;

public class ArticleListBean implements Serializable{
	public Article data;
	public int code;
	public ArticleListBean() {}

	public ArticleListBean(Article data, int code){
		super();
		this.data = data;
		this.code = code;
	}

	public Article getData() {
		return data;
	}

	public void setData(Article data) {
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String toString() {
		return "ArticleListBean [data = " + data + ", code = " + code + "]";
	}
}