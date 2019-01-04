package org.tc.osgi.bundle.spark.module.activator;

import org.osgi.framework.BundleContext;
import org.tc.osgi.bundle.groovy.interf.module.service.IGroovyService;

import org.tc.osgi.bundle.spark.conf.SparkPropertyFile;
import org.tc.osgi.bundle.spark.module.service.LoggerServiceProxy;
import org.tc.osgi.bundle.spark.module.service.PropertyServiceProxy;
import org.tc.osgi.bundle.spark.module.service.impl.SparkServiceImpl;
import org.tc.osgi.bundle.utils.interf.conf.exception.FieldTrackingAssignementException;
import org.tc.osgi.bundle.utils.interf.exception.TcOsgiException;
import org.tc.osgi.bundle.utils.interf.module.service.ILoggerUtilsService;
import org.tc.osgi.bundle.utils.interf.module.service.IPropertyUtilsService;
import org.tc.osgi.bundle.utils.interf.module.utils.AbstractTcOsgiActivator;
import org.tc.osgi.bundle.utils.interf.module.utils.TcOsgiProxy;

import spark.Spark;

/**
 * Activator.java.
 * @author Collonville Thomas
 * @version 0.0.1
 */
public class SparkActivator extends AbstractTcOsgiActivator {

	private TcOsgiProxy<ILoggerUtilsService> iLoggerUtilsService;
	private TcOsgiProxy<IPropertyUtilsService> iPropertyUtilsService;
	private String restPort;
	
	public String getRestPort() throws FieldTrackingAssignementException {
		if (restPort == null) {
			this.iPropertyUtilsService.getInstance().getXMLPropertyFile(SparkPropertyFile.getInstance().getXMLFile())
					.fieldTraking(this, "restPort");
		}
		return restPort;
	}

	@Override
	protected void checkInitBundleUtilsService(BundleContext context) throws TcOsgiException {
		throw new TcOsgiException("checkInitBundleUtilsService not implemented");

	}

	@Override
	protected void initProxys(BundleContext context) throws TcOsgiException {
		this.iPropertyUtilsService = new TcOsgiProxy<>(context, IPropertyUtilsService.class);
		PropertyServiceProxy.getInstance().setService(this.iPropertyUtilsService.getInstance());
		this.iLoggerUtilsService = new TcOsgiProxy<>(context, ILoggerUtilsService.class);
		LoggerServiceProxy.getInstance().setService(this.iLoggerUtilsService.getInstance());

	}

	@Override
	protected void initServices(BundleContext context) throws TcOsgiException {

		
	}

	@Override
	protected void detachProxys(BundleContext context) throws TcOsgiException {
		this.iLoggerUtilsService.close();
		this.iPropertyUtilsService.close();

	}

	@Override
	protected void detachServices(BundleContext context) throws TcOsgiException {
		this.getIBundleUtilsService().getInstance().unregister(IGroovyService.class, this);

	}

	@Override
	protected void beforeStart(BundleContext context) throws TcOsgiException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void beforeStop(BundleContext context) throws TcOsgiException {

	}

	@Override
	protected void afterStart(BundleContext context) throws TcOsgiException {
		
		// peut etre que l'on peut pas faire comme ca... 
		Spark.port(Integer.parseInt(this.getRestPort()));
		// il faut peut etre donner la capacité a en gerer plusieur instance de SPark.... donc iici ca serai celui par defaut?
		// peut on meme en faire un multi instance?
		// probablement qu'il faudra by passer la classe static
		Spark.staticFiles.externalLocation(SparkPropertyFile.getInstance().getWorkDirectory());
	}

	@Override
	protected void afterStop(BundleContext context) throws TcOsgiException {
		// TODO Auto-generated method stub

	}

}
