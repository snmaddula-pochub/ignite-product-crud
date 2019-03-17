/*package snmaddula.product.crud.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

//@Configuration
//@ConfigurationProperties("ignite.datasource")
//@EnableJpaRepositories(basePackages = "org.baeldung.persistence.multiple.dao.user", entityManagerFactoryRef = "igniteEntityManager", transactionManagerRef = "igniteTransactionManager")
public class IgniteConfig {

	private String url;
	private String username;
	private String password;
	private String driverClassName;

	@Bean
	public LocalContainerEntityManagerFactoryBean igniteEntityManager(DataSource igniteDataSource) {
		return new LocalContainerEntityManagerFactoryBean() {{
			setDataSource(igniteDataSource);
			setPackagesToScan(new String[] { "org.baeldung.persistence.multiple.model.user" });
			setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		}};
	}

	@Bean
	public DataSource igniteDataSource() {
		return DataSourceBuilder.create()
				.url(url).username(username).password(password)
				.driverClassName(driverClassName).build();
	}

	@Bean
	public PlatformTransactionManager igniteTransactionManager(LocalContainerEntityManagerFactoryBean igniteEntityManager) {
		return new JpaTransactionManager(igniteEntityManager.getObject());
	}
}*/