package com.atguigu.myrule;

import java.util.List;
import java.util.Random;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

/**
 * @author 王强
 * 自定义负载均衡算法（依旧随机策略，参考RandomRule类，
 * 每个机器要求被调用5次，也就是说之前是每台机器调用一次，现在是每台机器要用调用5次）
 */
public class RandomRule_wangqiang extends AbstractLoadBalancerRule {
    Random rand;
    List<Server> upList = null;
    List<Server> allList = null;
    
    private int total=0; //总共调用的次数，目前是设置每台服务被调用5次
    private int currentIndex=0;//当前提供服务的机器号
    int index=-1;
    public RandomRule_wangqiang() {
        rand = new Random();
    }

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            if(upList==null || allList==null) {
            	upList = lb.getReachableServers();
            	allList = lb.getAllServers();
            }

            int serverCount = allList.size();
            if (serverCount == 0) {
                return null;
            }
            //轮询服务器，每个服务器需要调用5次
           /*if(total < 5) {
        	   server = upList.get(currentIndex);
        	   total++;
           }else {
        	   total=0;
        	   currentIndex++;
        	   if(currentIndex>=upList.size()) {
        		   currentIndex=0;
        		   
        	   }
           }
           server = upList.get(currentIndex);
           System.out.println("端口："+server.getPort()+"\t upList:"+upList.toString()+"\t total:"+total+"\t currentIndex:"+currentIndex);
           */
           
            
            
            //如果下标为-1，随机选出服务器，该服务需要被调用5次请求
           if(index==-1) {
            	index = rand.nextInt(serverCount);
            	System.out.println("index:"+index);
            }
            if(total < 5) {
            	if(currentIndex==-1) {
            		currentIndex=index;
            	}
            	total++;
            	server = upList.get(currentIndex);
            }else {
            	total=0;
            	currentIndex++;
            	//如果当前提供服务的机器号大于服务器总数，那么currentIndex等于-1，重新随机选择服务器
            	if(currentIndex>=serverCount) {
            		currentIndex=-1;
            		index=-1;
            	}
            }

            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
            	System.out.println("端口："+server.getPort()+"\t upList:"+upList.toString()+"\t total:"+total+"\t currentIndex:"+currentIndex);
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }

	@Override
	public Server choose(Object key) {
		return choose(getLoadBalancer(), key);
	}

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {
		// TODO Auto-generated method stub
		
	}
}
