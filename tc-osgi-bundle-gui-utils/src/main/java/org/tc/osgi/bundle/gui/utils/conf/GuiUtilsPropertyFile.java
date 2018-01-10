package org.tc.osgi.bundle.gui.utils.conf;

import org.tc.osgi.bundle.gui.utils.module.service.GuiPropertyUtilsServiceProxy;
import org.tc.osgi.bundle.utils.interf.conf.AbstractPropertyFile;
import org.tc.osgi.bundle.utils.interf.conf.exception.FieldTrackingAssignementException;

/**
 * AptGuiPropertyFile.java.
 * @author collonville thomas
 * @version 0.0.1
 */
public final class GuiUtilsPropertyFile extends AbstractPropertyFile {
	/**
	 * String BUNDLE_RACINE.
	 */
	public final static String BUNDLE_RACINE = "tc.osgi.bundle.gui-utils.";

	/**
	 * String APT_GUI_FILE.
	 */
	public static final String GUI_UTILS_FILE = "gui-utils";

	/**
	 * DefaultConfig conf.
	 */
	private static GuiUtilsPropertyFile instance = null;

	/**
	 * getInstance.
	 * @return DefaultConfig
	 * @throws EquinoxConfigException
	 * @throws FieldTrackingAssignementException
	 */
	public static GuiUtilsPropertyFile getInstance() {
		if (GuiUtilsPropertyFile.instance == null) {
			GuiUtilsPropertyFile.instance = new GuiUtilsPropertyFile();
		}
		return GuiUtilsPropertyFile.instance;
	}

	/**
	 * String listOfExcludeDir.
	 */
	private String listOfExcludeDir;

	/**
	 * AptConfiguration constructor.
	 */
	private GuiUtilsPropertyFile() {
		super(GuiUtilsPropertyFile.GUI_UTILS_FILE, GuiUtilsPropertyFile.class.getClassLoader());
	}

	/**
	 * @return String
	 * @see org.tc.osgi.bundle.utils.conf.AbstractPropertyFile#getBundleRacine()
	 */
	@Override
	public String getBundleRacine() {
		return GuiUtilsPropertyFile.BUNDLE_RACINE;
	}

	/**
	 * @return String
	 * @see org.tc.osgi.bundle.utils.conf.AbstractPropertyFile#getConfFile()
	 */
	@Override
	public String getConfFile() {
		return GuiUtilsPropertyFile.GUI_UTILS_FILE;
	}

	/**
	 * getExcludeDir.
	 * @return String
	 * @throws FieldTrackingAssignementException
	 */
	public String getExcludeDir() throws FieldTrackingAssignementException {
		if (listOfExcludeDir == null) {
			GuiPropertyUtilsServiceProxy.getInstance().getXMLPropertyFile(getXMLFile()).fieldTraking(this, "listOfExcludeDir");
		}
		return listOfExcludeDir;
	}

	/**
	 * @return String
	 * @see org.tc.osgi.bundle.utils.conf.AbstractPropertyFile#getXMLFile()
	 */
	@Override
	public String getXMLFile() {
		return GuiUtilsPropertyFile.getInstance().getConfigDirectory() + getConfFile();
	}

}
