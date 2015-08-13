package com.android.meimi.bean;

 

public class ArticleInfoType {

   private int type;
   private String value;


    public void setType(int type) {
        this.type = type;
    }
    public int getType() {
        return type;
    }
    

    public void setValue(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
	@Override
	public String toString() {
		return "ArticleInfoType [type=" + type + ", value=" + value + "]";
	}
    
    
}