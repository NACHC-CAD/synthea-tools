package org.nachc.tools.synthea.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import com.nach.core.util.file.FileUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MergeFiles {

	private static final String DIR = "C:\\test\\synthea-patients\\test-sets\\patients-csv\\patients-1000";

	private static final String SUFFIX = "csv";

	public static void main(String[] args) {
		log.info("Doing merge...");
		File file = new File(DIR);
		merge(file, SUFFIX, true);
		log.info("Done.");
	}

	public static void merge(File dir, String outSuffix, boolean skipHeaderRow) {
		PrintWriter writer = null;
		try {
			List<File> files = FileUtil.listFilesOnly(dir);
			String outFileName = dir.getName() + "." + SUFFIX;
			File out = new File(dir.getParentFile(), outFileName);
			writer = new PrintWriter(new FileWriter(out));
			int cnt = 0;
			for (File file : files) {
				cnt++;
				log.info("Writing file " + cnt + " of " + files.size() + " to " + outFileName);
				if(cnt == 1) {
					writeFile(file, writer, false);
				} else {
					writeFile(file, writer, skipHeaderRow);
				}
			}
		} catch(Exception exp) {
			throw new RuntimeException(exp);
		} finally {
			if(writer != null) {
				writer.close();
			}
		}
	}

	private static void writeFile(File file, PrintWriter writer, boolean skipHeaderRow) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String line;
			int cnt = 0;
			while ((line = br.readLine()) != null) {
				cnt++;
				if(skipHeaderRow == true && cnt == 1) {
					continue;
				}
				writer.println(line);
				writer.flush();
			}
		} catch (Exception exp) {
			throw new RuntimeException(exp);
		} finally {
			try {
				br.close();
			} catch (Exception exp2) {
				throw new RuntimeException(exp2);
			}
		}
	}

}
