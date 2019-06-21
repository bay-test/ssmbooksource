package com.ssm.chapter4.test;

import static org.junit.Assert.fail;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.ssm.chapter4.aop.JavaConfig;
import com.ssm.chapter4.aop.Performance;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=JavaConfig.class)
public class AspectTest {

	@Resource
	Performance player;
	
	@Test
	public void test() {
		player.perform();
	}

}
