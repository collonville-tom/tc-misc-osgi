package org.tc.osgi.bundle.drools.conf;

import org.tc.osgi.bundle.utils.interf.conf.AbstractPropertyFile;
import org.tc.osgi.bundle.utils.interf.conf.exception.FieldTrackingAssignementException;

/**
 * AptConfiguration.java.
 * @author collonville thomas
 * @version 0.0.1
 */
public final class DroolsPropertyFile extends AbstractPropertyFile {
	/**
	 * String EQUINOXLOADERFILE.
	 */
	public static final String DROOLS_FILE = "drools";

	/**
	 * String BUNDLE_RACINE.
	 */
	public final static String BUNDLE_RACINE = "tc.osgi.bundle.drools.";

	/**
	 * DefaultConfig conf.
	 */
	private static DroolsPropertyFile instance = null;

	/**
	 * getInstance.
	 * @return DefaultConfig
	 * @throws EquinoxConfigException
	 * @throws FieldTrackingAssignementException
	 */
	public static DroolsPropertyFile getInstance() {
		if (DroolsPropertyFile.instance == null) {
			DroolsPropertyFile.instance = new DroolsPropertyFile();
		}
		return DroolsPropertyFile.instance;
	}


	/**
	 * AptConfiguration constructor.
	 */
	private DroolsPropertyFile() {
		super(DroolsPropertyFile.DROOLS_FILE, DroolsPropertyFile.class.getClassLoader());
	}

	

	/**
	 * @return String
	 * @see org.tc.osgi.bundle.utils.conf.AbstractPropertyFile#getBundleRacine()
	 */
	@Override
	public String getBundleRacine() {
		return DroolsPropertyFile.BUNDLE_RACINE;
	}

	/**
	 * @return String
	 * @see org.tc.osgi.bundle.utils.conf.AbstractPropertyFile#getConfFile()
	 */
	@Override
	public String getConfFile() {
		return DroolsPropertyFile.DROOLS_FILE;
	}

	/**
	 * @return String
	 * @see org.tc.osgi.bundle.utils.conf.AbstractPropertyFile#getXMLFile()
	 */
	@Override
	public String getXMLFile() {
		return DroolsPropertyFile.getInstance().getConfigDirectory() + getConfFile();
	}

}
