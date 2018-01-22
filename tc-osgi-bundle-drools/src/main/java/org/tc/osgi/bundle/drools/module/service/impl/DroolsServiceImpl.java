package org.tc.osgi.bundle.drools.module.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.tc.osgi.bundle.drools.core.InferenceEngine;

import org.tc.osgi.bundle.drools.interf.core.IInferenceEngine;
import org.tc.osgi.bundle.drools.interf.exception.RulesBuildingException;

import org.tc.osgi.bundle.drools.interf.module.service.IDroolsService;
import org.tc.osgi.bundle.drools.module.service.LoggerServiceProxy;

/**
 * DroolsServiceImpl.java.
 * @author collonville thomas
 * @version
 * @track
 */
public class DroolsServiceImpl implements IDroolsService {

	private Map<String,IInferenceEngine> registry=new HashMap<>();
	
	private static DroolsServiceImpl instance = null;

	public static DroolsServiceImpl getInstance() {
		if (DroolsServiceImpl.instance == null) {
			DroolsServiceImpl.instance = new DroolsServiceImpl();
		}
		return DroolsServiceImpl.instance;
	}

	public IInferenceEngine getInferenceEngine(String etiquette)
	{
		if(!this.registry.containsKey(etiquette))
		{
			this.registry.put(etiquette,new InferenceEngine());
		}
		return this.registry.get(etiquette);
	}
	
	public IInferenceEngine buildSessionForRules(String etiquette,String rulesPath)
	{
		IInferenceEngine engine=this.getInferenceEngine(etiquette);
		engine.addResource(rulesPath);

		try {
			engine.buildRules();
			engine.buildDefaultSession();
		} catch (RulesBuildingException e) {
			LoggerServiceProxy.getInstance().getLogger(DroolsServiceImpl.class).error("Les regles ne compile pas,"+e);
		}
		return engine;
	}
	
	
}
