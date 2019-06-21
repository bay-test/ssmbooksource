import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.bean.People;

public class Test {

	public static void main(String[] args) {	
		ApplicationContext context = new ClassPathXmlApplicationContext("cfg/applicationContext.xml");
	    People people = (People)context.getBean("people");
       	//第一个空隙，方法还未开始调用
        //可以用Before前置通知对eat进行增强	
		String result = people.eat("zhangsan");	
		//第五个空隙，方法已经退出(正常或异常)。
		 //可以用After后置通知对eat进行增强		
	}

	private static void eat(String...s) {
		// TODO Auto-generated method stub
		
	}

}
