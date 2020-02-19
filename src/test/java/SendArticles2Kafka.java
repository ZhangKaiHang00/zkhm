import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.zhangkaihang.cms.dao.ArticleRes;
import com.zhangkaihang.cms.dao.ArticlesRepository;
import com.zhangkaihang.cms.util.ArticleWithBLOBs;
import com.zhangkaihang.cms.util.FileUtilIO;
import com.zhangkaihang.common.utils.StreamUtil;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:producer.xml")
public class SendArticles2Kafka {

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	ArticlesRepository articlesRepository;
	
	@Test
	public void testSend() throws Exception {
		// TODO Auto-generated method stub
         File file = new File("D:/1708D22");
         File[] listFiles = file.listFiles();
		 for (File file2 : listFiles) {
	      System.out.println(file2.getName());
		  String title = file2.getName().replace(".txt", "");
	      String content = FileUtilIO.readFile(file2, "utf8");
	      System.out.println(content);
	      //声明一个对象
	      ArticleWithBLOBs awb = new ArticleWithBLOBs();
	        awb.setTitle(title);
	        awb.setContent(content);
	        awb.setChannelId(1);
	        awb.setPicture("a0c693a4-21d6-4d1f-b55f-9c1c179bf03e.jpg");
	        awb.setUserId(153);
	        awb.setCategoryId(1);
	       String string = JSON.toJSONString(awb);
	       kafkaTemplate.send("articles",string);
	       
		}
		 System.err.println("发送完毕！！！！");
         
	}
	
	@Test
	public void testSendArticles() throws IOException {
		File file = new File("D:/1708D22");
		File[] listFiles = file.listFiles();
		for (File file2 : listFiles) {
			String title = file2.getName().replace(".txt", "");
			String content = FileUtilIO.readFile(file2, "utf8");
			ArticleWithBLOBs awb = new ArticleWithBLOBs();
			awb.setTitle(title);
			awb.setContent(content);
			String jsonString = JSON.toJSONString(awb);
			kafkaTemplate.send("articles",jsonString);
			
		}
		
		
	}
	
}
