package org.nachc.tools.synthea.tools;

import java.io.File;
import java.util.List;

import org.nachc.tools.synthea.util.pprl.ConvertJsonToPprlCsv;

import com.nach.core.util.file.FileUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConvertSyntheaJsonToPprlCsvInputTool {

	public static void exec(String rootDir, String outDir) {
		log.info("Generating csv from fhir patients");
		File dir = new File(rootDir);
		File out = new File(rootDir, outDir);
		// delete the existing output dir if it exists
		if(out.exists()) {
			FileUtil.rmdir(out);
		}
		// create the out file
		out = FileUtil.mkdirs(out);
		// write the files
		List<File> files = FileUtil.listFilesOnly(dir);
		int cnt = 0;
		int firstRecordNumber = 1;
		for(File file : files) {
			cnt++;
			log.info("----------------");
			log.info("File " + cnt + " of " + files.size());
			log.info("First Record Number: " + firstRecordNumber);
			ConvertJsonToPprlCsv con = new ConvertJsonToPprlCsv();
			String json = FileUtil.getAsString(file);
			String csv = con.exec(json, firstRecordNumber);
			writeFile(csv, file, out);
			firstRecordNumber = con.getLastRecordNumber();
		}
		// done
		log.info("Done.");
	}

	private static void writeFile(String csv, File srcFile, File outDir) {
		String fileName = FileUtil.changeSuffix(srcFile, "csv");
		File file = new File(outDir, fileName);
		FileUtil.write(csv, file);
		log.info("Writing CSV to: " + FileUtil.getCanonicalPath(file));
	}
	
}
