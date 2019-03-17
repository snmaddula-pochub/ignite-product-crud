/*package snmaddula.product.crud.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

//@Configuration
//@ConfigurationProperties("h2.datasource")
//@EnableJpaRepositories(basePackages = "org.baeldung.persistence.multiple.dao.user", entityManagerFactoryRef = "h2EntityManager", transactionManagerRef = "h2TransactionManager")
public class H2Config {

	private String url;
	private String username;
	private String password;
	private String driverClassName;

	@Bean
	public LocalContainerEntityManagerFactoryBean h2EntityManager(DataSource h2DataSource) {
		return new LocalContainerEntityManagerFactoryBean() {{
			setDataSource(h2DataSource);
			setPackagesToScan(new String[] { "org.baeldung.persistence.multiple.model.user" });
			setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		}};
	}

	@Bean
	public DataSource h2DataSource() {
		return DataSourceBuilder.create()
				.url(url).username(username).password(password)
				.driverClassName(driverClassName).build();
	}

	@Bean
	public PlatformTransactionManager h2TransactionManager(LocalContainerEntityManagerFactoryBean h2EntityManager) {
		return new JpaTransactionManager(h2EntityManager.getObject());
	}
}*/