package org.tc.osgi.bundle.drools.core;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.ReleaseId;
import org.kie.api.io.KieResources;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.tc.osgi.bundle.drools.interf.core.IInferenceEngine;
import org.tc.osgi.bundle.drools.interf.exception.RulesBuildingException;
import org.tc.osgi.bundle.drools.interf.exception.RunnableSessionException;

public class InferenceEngine implements IInferenceEngine{

	private KieServices kieServices;
    private KieResources kieResources;
    private KieFileSystem kieFileSystem;
    private KieSession kieSession;
    private Thread t;
	
    public InferenceEngine()
    {
    	this.kieServices = KieServices.Factory.get();
    	this.kieResources = kieServices.getResources();
    	this.kieFileSystem = kieServices.newKieFileSystem();
    }
    
    public void addResource(String resourcePath)
    {
    	  Resource resource=kieResources.newClassPathResource("rules/Regle.drl");
    	  this.kieFileSystem.write(resource);
    }
    
    public void buildRules() throws RulesBuildingException
    {
    	KieBuilder kb = kieServices.newKieBuilder(kieFileSystem);
        kb.buildAll();
            
        if (kb.getResults().hasMessages(org.kie.api.builder.Message.Level.ERROR)) {
            throw new RulesBuildingException("Build Errors:\n" + kb.getResults().toString());
        }
    }
    
 
    
    public void buildDefaultSession()
    {
    	ReleaseId ridOriginal = kieServices.newReleaseId("org.default", "artifact", "1.0.0-SNAPSHOT");
        this.kieSession=kieServices.newKieContainer(ridOriginal).newKieSession();
    }
    
    public void insertFact(Object object)
    {
    	this.kieSession.insert(object);
    }
    
    public void startRunnableSession() throws RunnableSessionException
    {
    	if(this.t==null)
    	{
    		this.t=new Thread(new RunnableSession(this.kieSession));
    		t.start();
    	}
    	else
    	{
    		throw new RunnableSessionException("RunnableSession allready start");
    	}
    }

	@Override
	public void fireAllRules() {
		this.kieSession.fireAllRules();
	}
    
}
