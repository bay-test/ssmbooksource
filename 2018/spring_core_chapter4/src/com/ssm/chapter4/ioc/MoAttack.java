package com.ssm.chapter4.ioc;

public class MoAttack implements ActorArrangable { 
	private GeLi geLi;
	/*public MoAttack(GeLi geLi){
		this.geLi = geLi;
	}*/
	
	public void cityGateAsk(){
		//LiuDeHua ldh = new LiuDeHua();
		//ldh.responseAsk("墨者革离");
		//GeLi geLi = new LiuDeHua();
		geLi.responseAsk("墨者革离");
	}

	//属性方法注入GeLi扮演者
	public void setGeLi(GeLi geLi) {
		this.geLi = geLi;
	}
	
	//实现接口方法，注入扮演GeLi角色的演员
	@Override
	public void injectGeLi(GeLi geLi) {
		 this.geLi = geLi;
	
	}
}  