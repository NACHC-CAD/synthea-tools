package org.nachc.tools.synthea.util.db.mysql;

import java.sql.Connection;

import org.junit.Test;
import org.yaorma.database.Data;
import org.yaorma.database.Database;
import org.yaorma.database.Row;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MySqlDatabaseConnectionFactoryIntegrationTest {

	@Test
	public void shouldGetConnection() {
		log.info("Starting test...");
		Connection conn = null;
		try {
			log.info("Getting connection");
			conn = MySqlDatabaseConnectionFactory.getSyntheaConnection();
			String queryString = "select table_name from information_schema.tables where table_schema = 'information_schema' order by table_name";
			Data data = Database.query(queryString, conn);
			log.info("Got " + data.size() + " rows.");
			for(Row row : data) {
				log.info("\t" + data.get(0));
			}
		} finally {
			log.info("Closing connection...");
			Database.close(conn);
			log.info("Connection closed");
		}
		log.info("Done.");
	}
	
}
