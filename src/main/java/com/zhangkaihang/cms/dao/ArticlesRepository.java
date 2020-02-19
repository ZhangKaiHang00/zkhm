package com.zhangkaihang.cms.dao;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.zhangkaihang.cms.util.ArticleWithBLOBs;

public interface ArticlesRepository extends ElasticsearchRepository<ArticleWithBLOBs, Integer>{
	//实现复杂查询
	//按照标题查询,方法名称一定要按照规则写
	List<ArticleWithBLOBs> findByTitle(String key);
	//按照标题或者内容查询,方法名称一定要按照规则写
	//List<ArticleWithBLOBs> findByTitleOrContent(String title,String content);

	/* void saveAll(List<com.zhangkaihang.cms.domain.ArticleWithBLOBs> list); */
}
