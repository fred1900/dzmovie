package com.android.meimi.bean; 
import java.util.List; 

   
public class ArticleInfo {

   
   private int articleId;
  
   private int userId;
   
   private String userName;
   private String head;
   private String title;
   private String origin;
   private String cover;
   
   private int createTime;
   private List<List<ArticleInfoType>> item;


    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }
    public int getArticleId() {
        return articleId;
    }
    

    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getUserId() {
        return userId;
    }
    

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserName() {
        return userName;
    }
    

    public void setHead(String head) {
        this.head = head;
    }
    public String getHead() {
        return head;
    }
    

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    

    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public String getOrigin() {
        return origin;
    }
    

    public void setCover(String cover) {
        this.cover = cover;
    }
    public String getCover() {
        return cover;
    }
    

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }
    public int getCreateTime() {
        return createTime;
    }
    

    public void setItem(List<List<ArticleInfoType>> item) {
        this.item = item;
    }
    public List<List<ArticleInfoType>> getItem() {
        return item;
    }
	@Override
	public String toString() {
		return "ArticleInfo [articleId=" + articleId + ", userId=" + userId
				+ ", userName=" + userName + ", head=" + head + ", title="
				+ title + ", origin=" + origin + ", cover=" + cover
				+ ", createTime=" + createTime + ", item=" + item + "]";
	}
    
    
}