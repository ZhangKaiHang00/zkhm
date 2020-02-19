package com.zhangkaihang.cms.domain;

public class Complian {

	private Integer id;
	private Integer article_id;
	private Integer user_id; 
	private String complaintype;
	private String urlip;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getArticle_id() {
		return article_id;
	}
	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getComplaintype() {
		return complaintype;
	}
	public void setComplaintype(String complaintype) {
		this.complaintype = complaintype;
	}
	public String getUrlip() {
		return urlip;
	}
	public void setUrlip(String urlip) {
		this.urlip = urlip;
	}
	@Override
	public String toString() {
		return "Complian [id=" + id + ", article_id=" + article_id + ", user_id=" + user_id + ", complaintype="
				+ complaintype + ", urlip=" + urlip + "]";
	}
	
	
	
}
