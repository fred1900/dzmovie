package com.android.meimi.bean;
/*文章详情
接口：article/getArticleInfo */
public class ArticleInfobean {

   private int code;
   private ArticleInfo data;


    public void setCode(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }
    

    public void setData(ArticleInfo data) {
        this.data = data;
    }
    public ArticleInfo getData() {
        return data;
    }
	@Override
	public String toString() {
		return "ArticleInfobean [code=" + code + ", data=" + data + "]";
	}
    
    
}