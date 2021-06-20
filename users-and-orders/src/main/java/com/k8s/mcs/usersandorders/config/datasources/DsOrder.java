package com.k8s.mcs.usersandorders.config.datasources;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@PropertySource({"classpath:persistence-multiple-db-boot.properties"})
@EnableJpaRepositories(
		basePackages = "com.k8s.mcs.usersandorders.repo.jpa.order", 
		entityManagerFactoryRef = "orderEntityManager", 
		transactionManagerRef = "orderTransactionManager"
		)
public class DsOrder {

	@Autowired
	private Environment env;

	@Bean
	public LocalContainerEntityManagerFactoryBean orderEntityManager() {
		LocalContainerEntityManagerFactoryBean em
		= new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(orderDataSource());
		em.setPackagesToScan(
				new String[] { "com.k8s.mcs.usersandorders.repo.entity" });

		HibernateJpaVendorAdapter vendorAdapter
		= new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto",
				env.getProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.dialect",
				env.getProperty("hibernate.dialect"));
		properties.put("spring.jpa.show-sql",
				env.getProperty("spring.jpa.show-sql"));
		
		em.setJpaPropertyMap(properties);

		return em;
	}

	@Bean
	public DataSource orderDataSource() {

		DriverManagerDataSource dataSource
		= new DriverManagerDataSource();
		dataSource.setDriverClassName(
				env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("spring.order-ds.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.order-ds.datasource.username"));
		dataSource.setPassword(env.getProperty("spring.order-ds.datasource.password"));

		return dataSource;
	}

	@Bean
	public PlatformTransactionManager orderTransactionManager() {

		JpaTransactionManager transactionManager
		= new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(
				orderEntityManager().getObject());
		return transactionManager;
	}
}
