package com.zhangkaihang.cms.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.listener.MessageListener;

import com.alibaba.fastjson.JSON;
import com.zhangkaihang.cms.domain.ArticleWithBLOBs;
import com.zhangkaihang.cms.service.ArticleService;

public class ArticlesListener implements MessageListener<String, String >{

	//注入一个service用来调用保存的方法
	@Autowired
	ArticleService articleService;
	
	//监听消息的方法
	@Override
	public void onMessage(ConsumerRecord<String, String> data) {
		//开始接受消息
		//String jsonString = data.value();
		//1.将接受的消息转成对象
		//ArticleWithBLOBs awb = JSON.parseObject(jsonString,ArticleWithBLOBs.class);
		//保存到数据库
		//articleService.insertSelective(awb);
		
		//收消息
	    String value = data.value();
	    System.out.println(value);
		System.err.println("接受到信息");
	    //如果以这个开头,说明是流量肖峰的业务
		if(value.startsWith("user_view")) {
			String[] split = value.split("==");
			String id = split[1];
			//1根据id查询文章,执行浏览量+1操作
			ArticleWithBLOBs articleWithBLOBs = articleService.selectByPrimaryKey(Integer.parseInt(id));
			//2执行+1操作
			articleWithBLOBs.setHits(articleWithBLOBs.getHits()+1);
			//3把执行后的+1数据再次更新到数据库
			articleService.updateByPrimaryKeySelective(articleWithBLOBs);
			System.out.println("浏览量+1成功");
			
		}else {
			//读取爬虫信息,保存到mysql数据库
			ArticleWithBLOBs parseObject = JSON.parseObject(value,ArticleWithBLOBs.class);
			System.out.println(parseObject);
			//保存到mysql
			
			articleService.insertSelective(parseObject);
		}
	}



}
