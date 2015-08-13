package com.android.meimi.bean;

import java.io.Serializable;

/*文章bean*/
public class Article implements Serializable{
	public String cover;
	public String title;
	public String head;
	public String user_name;
	public String origin;
	public String article_id;
	public String user_id;
	public Article() {}

	public Article(String cover, String title, String head, String user_name, String origin, String article_id, String user_id){
		super();
		this.cover = cover;
		this.title = title;
		this.head = head;
		this.user_name = user_name;
		this.origin = origin;
		this.article_id = article_id;
		this.user_id = user_id;
	}

	
	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getArticle_id() {
		return article_id;
	}

	public void setArticle_id(String article_id) {
		this.article_id = article_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String toString() {
		return "Article [cover = " + cover + ", title = " + title + ", head = " + head + ", user_name = " + user_name + ", origin = " + origin + ", article_id = " + article_id + ", user_id = " + user_id + "]";
	}

}