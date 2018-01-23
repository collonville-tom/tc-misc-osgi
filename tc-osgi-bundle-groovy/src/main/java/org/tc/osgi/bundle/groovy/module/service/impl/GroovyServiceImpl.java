package org.tc.osgi.bundle.groovy.module.service.impl;


import java.io.File;
import java.io.IOException;
import java.util.Optional;

import org.codehaus.groovy.control.CompilationFailedException;
import org.tc.osgi.bundle.groovy.interf.exception.GroovyExecutionException;
import org.tc.osgi.bundle.groovy.interf.module.service.IGroovyService;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.Script;

/**
 * DroolsServiceImpl.java.
 * @author collonville thomas
 * @version
 * @track
 */
public class GroovyServiceImpl implements IGroovyService {

	
	private static GroovyServiceImpl instance = null;

	public static GroovyServiceImpl getInstance() {
		if (GroovyServiceImpl.instance == null) {
			GroovyServiceImpl.instance = new GroovyServiceImpl();
		}
		return GroovyServiceImpl.instance;
	}
	
	
	
	public Optional<Object> execute(String path,Optional<Binding> binding) throws GroovyExecutionException
	{
		GroovyShell shell;
		if(binding.isPresent())
			shell = new GroovyShell(binding.get());
		else
			shell = new GroovyShell();
		
		try {
			// Chargement du script groovy
			Script s=shell.parse(new File(path));
			
			// Exécution du script
			return Optional.ofNullable(s.run());

		} catch (CompilationFailedException | IOException e) {
			throw new GroovyExecutionException("Une erreur s'est produite lors de l'excution du script groovy " +path,e);
		} 
	}
	
}
