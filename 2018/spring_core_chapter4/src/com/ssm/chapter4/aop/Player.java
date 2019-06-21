package com.ssm.chapter4.aop;

import org.springframework.stereotype.Component;

@Component
public class Player implements Performance{

	private String name="wangfeng";//选手姓名
	private String subject="记忆扑克牌";//比赛的题目（项目）
	@Override
	public void perform() {		
		System.out.println(name+"正在挑战"+subject);		
	}
}
