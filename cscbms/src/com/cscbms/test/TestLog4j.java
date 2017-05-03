package com.cscbms.test;

import org.apache.log4j.Logger;

public class TestLog4j {

	private static Logger logger = Logger.getLogger(TestLog4j.class);

	public static void main(String[] args) {
		logger.debug("������Ϣ");
		logger.info("��ͨ��Ϣ");
		logger.warn("������Ϣ");
		logger.error("������Ϣ");
		logger.fatal("������Ϣ");
	}

}
