package in.ashokit.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "in.ashokit")
public class Appconfig {

	@Bean
	public DataSource dataSource() {

		DriverManagerDataSource ds = new DriverManagerDataSource();

		ds.setDriverClassName("com.mysql.cj.jdbc.Driver"); // SI
		ds.setUrl("jdbc:mysql://localhost:3306/Student"); // SI
		ds.setUsername("root"); // SI
		ds.setPassword("Santhu@1998"); // SI

		return ds;
	}

	@Bean
	public JdbcTemplate createJdbcTemplate(DataSource ds) {
		return new JdbcTemplate(ds); // CI
	}

}