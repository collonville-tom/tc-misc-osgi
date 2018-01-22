package org.tc.osgi.bundle.drools.exemple;


import org.tc.osgi.bundle.drools.core.InferenceEngine;
import org.tc.osgi.bundle.drools.interf.exception.RulesBuildingException;
import org.tc.osgi.bundle.drools.interf.exception.RunnableSessionException;

public class DroolsExemple {

	public static void main(String[] args) {

		InferenceEngine engine = new InferenceEngine();

		engine.addResource("rules/Regle.drl");

		try {
			engine.buildRules();
			engine.buildDefaultSession();

			System.out.println("Bonjour, je suis un bot");
			Context context = new Context();
			engine.insertFact(context); 
			context.readMessage();
			
			engine.startRunnableSession();

		} catch (RulesBuildingException | RunnableSessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
