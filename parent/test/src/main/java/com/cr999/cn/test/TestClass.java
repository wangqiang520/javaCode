package com.cr999.cn.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件描述：
 *
 * @version 1.0
 * @author wangqiang
 * @date 2021/4/8 16:02 
 */
public class TestClass {
    public static void main(String[] args) {
        List<Integer> integers=new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            integers.add(i);
        }
        t1(integers);
        t2(integers);
        t3(integers);
        t4(integers);
    }

    public static void t1(List<Integer> integers){
        long currentTimeMillis = System.currentTimeMillis();
        int max=integers.stream().mapToInt(v->v+v).max().getAsInt();
        long currentTimeMillis1 = System.currentTimeMillis();
        System.out.println("时间："+(currentTimeMillis1-currentTimeMillis)/60+" 最大值:"+max);
    }

    public static void t2(List<Integer> integers){
        long currentTimeMillis = System.currentTimeMillis();
        int max=-1;
        for (Integer i:integers) {
            if(i>max){
                max=i+i;
            }
        }
        long currentTimeMillis1 = System.currentTimeMillis();
        System.out.println("时间："+(currentTimeMillis1-currentTimeMillis)/60+" 最大值:"+max);
    }

    public static void t3(List<Integer> integers){
        long currentTimeMillis = System.currentTimeMillis();
        int max = integers.parallelStream().mapToInt(v -> v+v).max().getAsInt();
        long currentTimeMillis1 = System.currentTimeMillis();
        System.out.println("时间："+(currentTimeMillis1-currentTimeMillis)/60+" 最大值:"+max);
    }

    public static void t4(List<Integer> integers){
        integers.parallelStream().forEach(v->{
            System.out.println(Thread.currentThread().getName()+" 值："+v);
        });

    }

}
