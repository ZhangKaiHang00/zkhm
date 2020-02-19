package com.zkh.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageInfo;
import com.zhangkaihang.cms.dao.ArticleRes;
import com.zhangkaihang.cms.domain.Article;
import com.zhangkaihang.cms.service.ArticleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class ImportMysql2Es {

	@Autowired
	ArticleRes articleRes;
	
	@Autowired
	ArticleService articleService;
	
	@Test
	public void testImportMysql2ES() {
		Article article = new Article();
		article.setStatus(1);
		PageInfo<Article> selects = articleService.selects(article, 1, 10000);
		
		articleRes.saveAll(selects.getList());
		
	}
	
	@Test
	public void testDel() {
		articleRes.deleteById(18);
		System.err.println("删除成功！！");
	}
	
	
}
