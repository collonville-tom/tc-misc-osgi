package org.tc.osgi.bundle.drools.interf.core;


import org.tc.osgi.bundle.drools.interf.exception.RulesBuildingException;
import org.tc.osgi.bundle.drools.interf.exception.RunnableSessionException;

public interface IInferenceEngine {

	
	public void addResource(String resourcePath);
    
    public void buildRules() throws RulesBuildingException;
    
    public void buildDefaultSession();
    
    public void insertFact(Object object);
    
    public void startRunnableSession() throws RunnableSessionException;
    
    public void fireAllRules();
}
