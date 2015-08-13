package com.android.meimi.bean;

import java.io.Serializable; 

/**
 * ��Ӱʵ����
 * */
public class MovieBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**�������*/
	private int mid;
	/**��Ӱ���*/
	private String name;
	/**��Ӱ����*/
	private String type;
	/**��ӳʱ��*/
	private String time;
	/**��Ա*/
	private String player;
	/**��ӰͼƬ*/
	private int image;

	public MovieBean() {
	}

	/**
	 * �����Ĺ��췽��
	 * @param mid �������id
	 * @param name ��Ӱ���
	 * @param type ��Ӱ����
	 * @param time ��ӳʱ��
	 * @param player ��Ա���
	 * @param image ��ӰͼƬ  11,"dasheng","武侠",new Date(),"asfsdf",R.id.
	 */
	public MovieBean(int mid, String name, String type, String time,
			String player, int image) {
		super();
		this.mid = mid;
		this.name = name;
		this.type = type;
		this.time = time;
		this.player = player;
		this.image = image;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public int getimage() {
		return image;
	}

	public void setimage(int image) {
		this.image = image;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof MovieBean) {
			MovieBean m = (MovieBean) o;
			if (this.image == m.image && this.name.equals(m.name)
					&& this.type.equals(m.type) && this.time.equals(m.time)
					&& this.player.equals(m.player) && this.mid == m.mid) {
				return true;
			}
		}
		return false;
	}
}
