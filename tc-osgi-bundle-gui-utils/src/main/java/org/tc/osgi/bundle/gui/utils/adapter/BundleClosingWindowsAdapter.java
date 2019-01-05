package org.tc.osgi.bundle.gui.utils.adapter;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import org.osgi.framework.BundleContext;
import org.tc.osgi.bundle.utils.interf.exception.TcOsgiException;
import org.tc.osgi.bundle.utils.interf.module.service.IBundleUtilsService;
import org.tc.osgi.bundle.utils.interf.module.service.ILoggerUtilsService;
import org.tc.osgi.bundle.utils.interf.module.utils.TcOsgiProxy;

/**
 * BundleClosingWindowsAdapter.java.
 * @author com.thalesgroup
 * @version 0.1.6
 */
public class BundleClosingWindowsAdapter extends WindowAdapter {

	private final String bName;
	private final BundleContext context;
	private TcOsgiProxy<ILoggerUtilsService> iLoggerUtilsService;
	private TcOsgiProxy<IBundleUtilsService> iBundleUtilsService;

	public BundleClosingWindowsAdapter(final BundleContext context, final String autoBundleName) throws TcOsgiException {
		bName = autoBundleName;
		this.context = context;
		iLoggerUtilsService = new TcOsgiProxy<ILoggerUtilsService>(context, ILoggerUtilsService.class);
		iBundleUtilsService = new TcOsgiProxy<IBundleUtilsService>(context, IBundleUtilsService.class);
	}

	@Override
	public void windowClosing(final WindowEvent evt) {
		try {
			iBundleUtilsService.getInstance().getBundleKiller().processOnBundle(context, bName,null);// TODO a corriger
		} catch (final TcOsgiException e) {
			iLoggerUtilsService.getInstance().getLogger(BundleClosingWindowsAdapter.class).error("Probleme lors de l'arret du bundle " + bName, e);
		}
	}

}
