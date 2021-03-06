package com.zhangkaihang.cms.util;

import java.io.Serializable;

import com.zhangkaihang.cms.domain.Article;
/**
 * 
 * @ClassName: ArticleWithBLOBs 
 * @Description: 文章 -包含大文本
 * @author: zkh
 * @date: 2019年12月10日 下午3:08:35
 */
public class ArticleWithBLOBs extends Article implements Serializable {
    /**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 3784014497633443444L;

	private String content;//文章内容

    private String summary;//文章摘要

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }
}