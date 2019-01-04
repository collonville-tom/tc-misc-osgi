package org.tc.osgi.bundle.spark.module.service.impl;


import java.io.File;
import java.io.IOException;
import java.util.Optional;

import org.tc.osgi.bundle.spark.interf.module.service.ISparkService;

/**
 * DroolsServiceImpl.java.
 * @author collonville thomas
 * @version
 * @track
 */
public class SparkServiceImpl implements ISparkService {

	
	private static SparkServiceImpl instance = null;

	public static SparkServiceImpl getInstance() {
		if (SparkServiceImpl.instance == null) {
			SparkServiceImpl.instance = new SparkServiceImpl();
		}
		return SparkServiceImpl.instance;
	}
	
	
	
	
}
