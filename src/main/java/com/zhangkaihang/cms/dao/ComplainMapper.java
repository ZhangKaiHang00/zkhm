package com.zhangkaihang.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhangkaihang.cms.domain.Complain;
import com.zhangkaihang.cms.vo.ComplainVO;

public interface ComplainMapper {
	
	int insert(Complain complain);
	
	//查询投诉
	List<Complain> selects(ComplainVO complainVO);

	Complain select(@Param("id")Integer id);
	
}
