package com.ssm.chapter4.ioc;

public class Director {	
	  public void direct(){  
	       GeLi geli = new LiuDeHua();  
	       MoAttack moAttack = new MoAttack(); 
	       //通过接口方法注入GeLi扮演者
	       moAttack.injectGeLi (geli);  
	       moAttack.cityGateAsk();  
	   }  
}
