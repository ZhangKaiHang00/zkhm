package com.zhangkaihang.cms.service;

import java.util.List;

import com.zhangkaihang.cms.domain.ArticlesShou;

public interface ShouService {

	//列表
	List<ArticlesShou> selects();
	//添加
	boolean insert(ArticlesShou articlesShou);
	ArticlesShou select(Integer id);
}
