package org.tc.osgi.bundle.gui.utils.interf.module.service;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;

import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import org.osgi.framework.BundleContext;
import org.tc.osgi.bundle.gui.utils.interf.location.IDialogLocationControl;
import org.tc.osgi.bundle.utils.interf.exception.TcOsgiException;


/**
 * UtilsService.java.
 *
 * @author Collonville Thomas
 * @version 0.1.6
 * @track SDD_BUNDLE_GUI_UTILS_020
 */
public interface IGuiUtilsService {

	/**
	 * getBasicMouseAdapter.
	 * @param menu JMenuItem
	 * @return BasicMouseAdapter
	 */
	public MouseAdapter getBasicMouseAdapter(final JMenuItem menu);

	/**
	 * getBundleClosingWindowsAdapter.
	 * @param context BundleContext
	 * @param autoBundleName String
	 * @return WindowListener
	 * @throws TcOsgiException 
	 */
	public WindowAdapter getBundleClosingWindowsAdapter(BundleContext context, String autoBundleName) throws TcOsgiException;

	/**
	 * getImagePane.
	 * @param image Image
	 * @return ImagePane
	 */
	public JPanel getImagePane(final Image image);

	/**
	 * getLocationControl.
	 * @param dialog JDialog
	 * @return DialogLocationControl
	 */
	public IDialogLocationControl getLocationControl(final JDialog dialog);

}
