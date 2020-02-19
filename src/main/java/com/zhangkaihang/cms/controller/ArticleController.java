package com.zhangkaihang .cms.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.zhangkaihang.cms.dao.ArticleRes;
import com.zhangkaihang.cms.domain.Article;
import com.zhangkaihang.cms.domain.Channel;
import com.zhangkaihang.cms.service.ChannelService;
import com.zhangkaihang.cms.util.HLUtils;


@RequestMapping("article")
@Controller
public class ArticleController {
	@Autowired
	ArticleRes articleRes;
	
	@Resource
	private ChannelService channelService;
	
	@Autowired
	ElasticsearchTemplate elasticsearchTemplate;
	@SuppressWarnings("unchecked")
	@RequestMapping("search")
	public String search(String key,Article article,Model model,@RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "3")Integer pageSize) {
		 //List<Article> list = articleRes.findByTitle(key);
		
		//显示栏目
				//0.封装查询条件
						article.setStatus(1);
						model.addAttribute("article", article);
						//1. 查询出所有的栏目
								List<Channel> channels = channelService.selects();
								model.addAttribute("channels", channels);
				//实现高亮显示
				//es搜索
								
				//定义一个开始时间
				long start = System.currentTimeMillis();
				PageInfo<Article> pageInfo = (PageInfo<Article>) HLUtils.findByHighLight(elasticsearchTemplate, Article.class, page, pageSize, new String[] {"title"}, "id", key);
				//定义一个结束时间
				long end = System.currentTimeMillis();
				System.err.println("es查询一共花费了"+(end-start)+"毫秒");
				model.addAttribute("key", key);
				model.addAttribute("info", pageInfo);
				return "index/index";
		/*
		 * PageInfo<Article> info = (PageInfo<Article>)
		 * HLUtils.findByHighLight(elasticsearchTemplate, Article.class, 1, 2, new
		 * String[] {"title"}, "id", key); model.addAttribute("key", key);
		 * model.addAttribute("info", info); return "index/index";
		 */
	}
	
	//es索引查询
//	@RequestMapping("search")
//	public String search(String key,Model model) {
//		List<Article> list = articleRes.findByTitle(key);
//		PageInfo<Article> info = new PageInfo<>(list);
//		model.addAttribute("info", info);
//		return "index/index";
//	}
	
	@GetMapping("selects")
	public String selects() {
		return "admin/article/articles";
	}
}
