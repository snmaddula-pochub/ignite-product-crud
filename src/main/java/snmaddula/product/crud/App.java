package snmaddula.product.crud;

import org.apache.ignite.cache.spring.SpringCacheManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import lombok.Setter;

@Setter
@EnableCaching
@SpringBootApplication
public class App {

	private String igniteConfigPath;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
/*
	@Bean
	public Ignite ignite() {
		System.out.println("=================== STARTING IGNITE ====================");
		Ignite ignite = Ignition.start(igniteConfigPath);
		System.out.println("=================== STARTED IGNITE ====================");
		return ignite;
	}
*/
/*
	@Bean
	@DependsOn("ignite")
	public SpringCacheManager cacheManager() {
		System.out.println("=======================CACHE MANAGER=======================");
		SpringCacheManager scm = new SpringCacheManager();
		scm.setIgniteInstanceName("products-poc");
		scm.setGridName("products-poc");
		return scm;
	}

*/

	@Bean 
	public SpringCacheManager cacheManager() throws Exception {
	    SpringCacheManager mgr = new SpringCacheManager();
	    mgr.setConfiguration(ServerConfigurationFactory.createConfiguration());
	    return mgr;
	}
	
}
