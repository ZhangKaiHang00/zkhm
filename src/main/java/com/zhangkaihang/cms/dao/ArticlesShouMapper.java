package com.zhangkaihang.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhangkaihang.cms.domain.ArticlesShou;


public interface ArticlesShouMapper {

	//查询所有数据
	List<ArticlesShou> selects();
	int insert(ArticlesShou articlesShou);
	
	ArticlesShou select(@Param("id")Integer id);
}
