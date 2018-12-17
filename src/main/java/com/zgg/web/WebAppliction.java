package com.zgg.web;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;


//@EnableTransactionManagement					//通知Spring，@Transactional注解的类被事务的切面包围。这样@Transactional就可以使用了。
@SpringBootApplication							//@SpringBootConfiguration+@EnableAutoConfiguration+@ComponentScan

//@SpringBootConfiguration							//替代@Configuration
//@EnableAutoConfiguration							//启用自动配置，根据dependence自动配置jar
//@ComponentScan									//默认扫描当前类所在包内的同级类及子目录中的类所在对象

public class WebAppliction extends SpringBootServletInitializer{

	/**
	 * <pre>main(quickly start. )   
	 * @param args</pre>
	 */
    public static void main(String[] args) {
        SpringApplication.run(WebAppliction.class, args);
    }

	/**
	 * <pre>configure(extends SpringBootServletInitializer,override method configure ,for tomcat container Initializing. )   
	 * @param builder</pre>
	 */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(WebAppliction.class);
    }
    
}
 
