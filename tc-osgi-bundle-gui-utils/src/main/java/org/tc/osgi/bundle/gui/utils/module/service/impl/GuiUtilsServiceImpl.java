/**
 */
package org.tc.osgi.bundle.gui.utils.module.service.impl;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;

import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import org.osgi.framework.BundleContext;
import org.tc.osgi.bundle.gui.utils.adapter.BasicMouseAdapter;
import org.tc.osgi.bundle.gui.utils.adapter.BundleClosingWindowsAdapter;
import org.tc.osgi.bundle.gui.utils.interf.location.IDialogLocationControl;
import org.tc.osgi.bundle.gui.utils.interf.module.service.IGuiUtilsService;
import org.tc.osgi.bundle.gui.utils.location.DialogLocationControl;
import org.tc.osgi.bundle.gui.utils.pane.ImagePane;
import org.tc.osgi.bundle.utils.interf.exception.TcOsgiException;
import org.tc.osgi.bundle.utils.interf.module.service.ILoggerUtilsService;

/**
 * GuiUtilsService.java.
 * @author collonville thomas
 * @version 0.1.5
 * @track SDD_BUNDLE_GUI_UTILS_020, SDD_BUNDLE_GUI_UTILS_010, SDD_BUNDLE_GUI_UTILS_030
 */
public class GuiUtilsServiceImpl implements IGuiUtilsService {

	private ILoggerUtilsService loggerUtilsService = null;

	public ILoggerUtilsService getLoggerUtilsService() {
		return loggerUtilsService;
	}

	public void setLoggerUtilsService(ILoggerUtilsService loggerUtilsService) {
		this.loggerUtilsService = loggerUtilsService;
	}

	/**
	 * @param menu JMenuItem
	 * @return BasicMouseAdapter
	 * @see org.tc.osgi.bundle.gui.utils.module.service.IGuiUtilsService#getBasicMouseAdapter(javax.swing.JMenuItem)
	 */
	@Override
	public MouseAdapter getBasicMouseAdapter(final JMenuItem menu) {
		loggerUtilsService.getLogger(GuiUtilsServiceImpl.class).debug("Getting BasicMouseAdapter object");
		return new BasicMouseAdapter(menu);
	}

	@Override
	public WindowAdapter getBundleClosingWindowsAdapter(final BundleContext context, final String autoBundleName) throws TcOsgiException {
		return new BundleClosingWindowsAdapter(context, autoBundleName);
	}

	/**
	 * @param image
	 * @return
	 * @see org.tc.osgi.bundle.gui.utils.module.service.IGuiUtilsService#getImagePane(java.awt.Image)
	 */
	@Override
	public JPanel getImagePane(final Image image) {
		loggerUtilsService.getLogger(GuiUtilsServiceImpl.class).debug("Getting DialogLocationControl object");
		return new ImagePane(image);
	}

	/**
	 * @return LocationControl
	 * @see org.tc.osgi.bundle.gui.utils.module.service.IGuiUtilsService#getLocationControl()
	 */
	@Override
	public IDialogLocationControl getLocationControl(final JDialog dialog) {
		loggerUtilsService.getLogger(GuiUtilsServiceImpl.class).debug("Getting DialogLocationControl object");
		return new DialogLocationControl(dialog);
	}

}
