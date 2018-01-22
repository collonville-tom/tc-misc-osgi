package org.tc.osgi.bundle.drools.core;

import org.kie.api.runtime.KieSession;

public class RunnableSession implements Runnable {

	private KieSession kSession;
	
	public RunnableSession(KieSession kSession)
	{
		this.kSession=kSession;
	}
	
	@Override
	public void run() {
		this.kSession.fireUntilHalt();
	}
}
