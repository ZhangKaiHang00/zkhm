package com.zkh.test;

import org.junit.Test;

import com.zhangkaihang.common.utils.StringUtil;

public class TestShou {

	@Test
	public void tests() {
		String url = "http://localhost:1111/complain?id=1";
		boolean ss = StringUtil.isHttpUrl(url);
		System.out.println(ss);
	}
}
