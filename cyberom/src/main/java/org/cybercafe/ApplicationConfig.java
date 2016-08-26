/**
 * 
 */
package org.cybercafe;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author Bablu Rajbhar
 *
 */
@Configuration
@EnableJpaRepositories
@PropertySource("classpath:application.properties")
public class ApplicationConfig {
	
	private static final String VIEW_RESOLVER_SUFFIX = ".jsp";

	private static final String VIEW_RESOLVER_PREFIX = "/jsp/";

	private static final String TRUE = "true";

	private static final String MAIL_SMTP_STARTTLS_ENABLE = "mail.smtp.starttls.enable";

	private static final String MAIL_SMTP_AUTH = "mail.smtp.auth";

	private static final String EMAIL_PASSWORD = "Cybercafe6596";

	private static final String EMAIL_USERNAME = "bablu.rajbhar87@gmail.com";

	private static final int EMAIL_PORT = 587;

	private static final String EMAIL_HOST = "smtp.gmail.com";
	
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty("spring.datasource.driver-class-name"));
		dataSource.setUrl(env.getRequiredProperty("spring.datasource.url"));
		dataSource.setUsername(env.getRequiredProperty("spring.datasource.username"));
		dataSource.setPassword(env.getRequiredProperty("spring.datasource.password"));
		return dataSource;
	}
	
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabase(Database.MYSQL);
		vendorAdapter.setGenerateDdl(false);
		
		LocalContainerEntityManagerFactoryBean factory = 
				new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("org.cybercafe");
		factory.setDataSource(dataSource());
		return factory;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}
	
	@Bean
	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
		javaMailSenderImpl.setHost(EMAIL_HOST);
		javaMailSenderImpl.setPort(EMAIL_PORT);
		javaMailSenderImpl.setUsername(EMAIL_USERNAME);
		javaMailSenderImpl.setPassword(EMAIL_PASSWORD);
		javaMailSenderImpl.setJavaMailProperties(getJavaMailProperties());
		return javaMailSenderImpl;
	}

	private Properties getJavaMailProperties() {
		Properties javaMailProperties = new Properties();
		javaMailProperties.put(MAIL_SMTP_AUTH, TRUE);
		javaMailProperties.put(MAIL_SMTP_STARTTLS_ENABLE, TRUE);
		return javaMailProperties;
	}
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix(VIEW_RESOLVER_PREFIX);
		viewResolver.setSuffix(VIEW_RESOLVER_SUFFIX);
		return viewResolver;
	}
	
	
}
