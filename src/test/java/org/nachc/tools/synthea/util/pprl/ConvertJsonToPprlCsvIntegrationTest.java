package org.nachc.tools.synthea.util.pprl;

import java.io.File;

import org.junit.Test;

import com.nach.core.util.file.FileUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConvertJsonToPprlCsvIntegrationTest {
	
	private static final String FILE_NAME = "/org/nachc/tools/synthea/patients/singlesegment/segment-1.json";
	
	@Test
	public void shouldCreateOutputFile() {
		log.info("Starting test...");
		String json = FileUtil.getAsString(FILE_NAME);
		log.info("Got json (length):" + json.length());
		ConvertJsonToPprlCsv convert = new ConvertJsonToPprlCsv();
		String patientsCsv = convert.exec(json, 1);
		log.info("Patients CSV: \n" + patientsCsv);
		log.info("Done.");
	}
	
}
