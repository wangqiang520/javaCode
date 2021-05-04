package com.userService.cn.test;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import cn.gjing.tools.common.util.TimeUtils;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

//timer有2中方法schedule和scheduleAtFixedRate，前者会等任务结束在开始计算时间间隔，后者是在任务开始就计算时间，有并发的情况
public class TimeTask {
	public static void main(String[] args) throws Exception {
		//scheduleAtFixedRateMethod();
		//scheduleMethod();
		//scheduledExecutorServiceScheduleMethod();
		scheduledExecutorServiceScheduleAtFixedRateMethod();
		
	}
	//延迟1秒启动，每隔2秒执行一次，是前一个任务开始时就开始计算时间间隔，但是会等上一个任务结束在开始下一个
	public static void scheduledExecutorServiceScheduleAtFixedRateMethod() {
		ScheduledExecutorService scheduledExecutorService=Executors.newScheduledThreadPool(10);
		scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				SimpleDateFormat sdm=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				System.out.println(sdm.format(new Date()));
				try {
					task();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}, 1, 2, TimeUnit.SECONDS);
		
	}
	//延迟2s启动，执行一次
	public static void scheduledExecutorServiceScheduleMethod() {
		ScheduledExecutorService scheduleExecutorService=Executors.newScheduledThreadPool(10);
		scheduleExecutorService.schedule(new Runnable() {
			
			@Override
			public void run() {
				SimpleDateFormat sdm=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				System.out.println(sdm.format(new Date()));
				try {
					task();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}, 2, TimeUnit.SECONDS);
			
	}
	
	
	//date是开始时间，3000ms是定时任务周期，每3s执行一次
	public static void scheduleAtFixedRateMethod() throws Exception {
		SimpleDateFormat sdm=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=sdm.parse("2019-11-02 22:25:00");
		new Timer("scheduleAtFixedRate").scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println(sdm.format(new Date()));
				try {
					task();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, date, 3000);
	}
	//1000毫秒是延时启动时间，3000ms是定时任务周期，每3秒执行一次，
	public static void scheduleMethod() {
		new Timer("scheduleMethod").schedule(new TimerTask() {
			@Override
			public void run() {
				try {
					SimpleDateFormat sdm=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					System.out.println(sdm.format(new Date()));
					task();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}, 1000,3000);
	}
	public static void task() throws Exception {
		long time=System.currentTimeMillis();
		SimpleDateFormat sdm=new SimpleDateFormat("yyyyMMddHHmmss");
		String fileName=sdm.format(new Date())+".xls";
				
		
		//1:创建excel文件
        File file=new File("D:\\"+fileName);
        file.createNewFile();
        
        //2:创建工作簿
        WritableWorkbook workbook=Workbook.createWorkbook(file);
        //3:创建sheet,设置第二三四..个sheet，依次类推即可
        WritableSheet sheet=workbook.createSheet("用户管理", 0);
        //4：设置titles
        String[] titles={"编号","账号","密码"};
        //5:单元格
        Label label=null;
        //6:给第一行设置列名
        for(int i=0;i<titles.length;i++){
            //x,y,第一行的列名
            label=new Label(i,0,titles[i]);
            //7：添加单元格
            sheet.addCell(label);
        }
        //8：模拟数据库导入数据
        for(int i=1;i<10;i++){
            //添加编号，第二行第一列
            label=new Label(0,i,i+"");
            sheet.addCell(label);
            
            //添加账号
            label=new Label(1,i,"10010"+i);
            sheet.addCell(label);
            
            //添加密码
            label=new Label(2,i,"123456");
            sheet.addCell(label);
        }
        
        //写入数据，一定记得写入数据，不然你都开始怀疑世界了，excel里面啥都没有
        workbook.write();
        //最后一步，关闭工作簿
        workbook.close();
        Thread.currentThread().sleep(6000);
	}
}
