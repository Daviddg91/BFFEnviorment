package com.keycloak.config;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
// 
//@Configuration
//public class Beans {
// 
//	@Bean(name = "entityManagerFactory")
//	public LocalSessionFactoryBean sessionFactory() {
//	    return new LocalSessionFactoryBean();
//	}
//	
//	@Bean
//	public RestTemplate restTemplate() {
//	    return new RestTemplate();
//	}
//	
//	//reactive web server bean 
//    @Bean(name = "mvcHandlerMappingIntrospector")
//    public HandlerMappingIntrospector mvcHandlerMappingIntrospector() {
//        return new HandlerMappingIntrospector();
//    }
//	
//	@Bean
//	public DataSourceInitializer dataSourceInitializer(@Qualifier("dataSource") final javax.sql.DataSource dataSource) {
//	    ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
//	    resourceDatabasePopulator.addScript(new ClassPathResource("/data.sql"));
//	    DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
//	    dataSourceInitializer.setDataSource(dataSource);
//	    dataSourceInitializer.setDatabasePopulator(resourceDatabasePopulator);
//	    return dataSourceInitializer;
//	}
//}

