package com.userService.cn.configure;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**   
 * @ClassName: SSLConfig   
 * @Description: 配置http和https
 * @author: 王强
 * @date: 2020年4月26日 上午1:08:38     
 */
@Configuration
public class SSLConfig {

	@Value("${server.http.port}")
    private int serverHttpPort;
    
    @Value("${server.port}")
    private int serverPort;

    @Bean
    public TomcatServletWebServerFactory servletContainer() { //springboot2 新变化
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint securityConstraint = new SecurityConstraint();
                securityConstraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                securityConstraint.addCollection(collection);
                context.addConstraint(securityConstraint);
            }
        };
        tomcat.addAdditionalTomcatConnectors(initiateHttpConnector());
        return tomcat;
    }

    private Connector initiateHttpConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        connector.setPort(serverHttpPort);//监听http端口号
        connector.setSecure(true);//true:不能转向到https端口，false:可能转向到https端口
        connector.setRedirectPort(serverPort);//监听到http端口号转向到https端口号
        return connector;
    }

}