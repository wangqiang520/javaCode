package com.userService.cn.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

//@Service
public class SpringTask {
    private static final Logger log = LoggerFactory.getLogger(SpringTask.class);

	
	@Scheduled(cron="1/5 * * * * *")
	public void task1() {
		log.info("定时任务，每隔5s执行一次");
		SimpleDateFormat sdm=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("定时任务1"+sdm.format(new Date()));
		try {
			TimeTask.task();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Scheduled(initialDelay = 5000, fixedRate = 5000)
	public void task2() {
		log.info("定时任务，延迟1s,每隔1S执行一次");
		SimpleDateFormat sdm=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("定时任务2"+sdm.format(new Date()));
		try {
			TimeTask.task();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
