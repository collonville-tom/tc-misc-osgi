package org.tc.osgi.bundle.drools.interf.module.service;


import org.tc.osgi.bundle.drools.interf.core.IInferenceEngine;



/**
 * IAptIoService.java.
 * @author collonville thomas
 * @version
 * @track
 */
public interface IDroolsService {

	public IInferenceEngine getInferenceEngine(String etiquette);
	
	public IInferenceEngine buildSessionForRules(String etiquette,String rulesPath);
}
