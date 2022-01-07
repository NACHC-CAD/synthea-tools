package org.nachc.tools.synthea.unittesttools;

import java.io.File;

public class TestingParams {

	public static String OUT_DIR = "/test/synthea-tools";

	public static File getOutDir() {
		return new File(OUT_DIR);
	}
	
	public static File getOutFile(String fileName) {
		return new File(getOutDir(), fileName);
	}
	
}
