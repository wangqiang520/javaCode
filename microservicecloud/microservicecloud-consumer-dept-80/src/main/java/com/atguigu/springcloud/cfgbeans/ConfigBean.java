package com.atguigu.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.shared.resolver.aws.ZoneAffinityClusterResolver;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import com.netflix.loadbalancer.ZoneAvoidanceRule;

@Configuration
public class ConfigBean {
	
	@Bean
	@LoadBalanced //spring cloud Ribbon是基于Netflix Ribbon实现的一套客户端负载均衡的工具
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	@Bean
	public IRule myRule() {
		return new RoundRobinRule(); //轮询
		//return new RandomRule(); //随机
		//return new AvailabilityFilteringRule(); //会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，还有并发的连接数量超过阈值的服务，然后对剩余的 服务列表按照轮询策略进行访问
		//return new WeightedResponseTimeRule(); //根据平均响应时间计算所有服务的权重，响应时间越快服务权重越大被选中的的概率越高。刚启动时如果统计信息不足，则使用RoundRobinRule策略，等统计信息足够，会切换到WeightedResponseTimeRule
		//return new RetryRule();  //行按照RoundRobinRule的策略获取服务，如果获取服务失败则在指定时间内会进行重试，获取可用的服务
		//return new BestAvailableRule(); //会先过滤掉由于多次访问故障而处于断路器跳闸的服务，然后选择一个并发量最小的服务
		//return new ZoneAvoidanceRule(); //默认规则，复合判断server所在区域的性能和server的可用性选择服务器
	}

}
