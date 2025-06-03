package org.estore.estore;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class EstoreApplicationTests {


	@Test
	void contextLoads() {

	}

	@Test
	void testConnectToDatabase() {
		try(HikariDataSource dataSource = new HikariDataSource();){
			dataSource.setDriverClassName("org.postgresql.Driver");
			dataSource.setJdbcUrl("jdbc:postgresql://localhost/estore_db");
			dataSource.setUsername("postgres");
			dataSource.setPassword("passwd");
			assertThat(dataSource).isNotNull();
		}
	}

}
