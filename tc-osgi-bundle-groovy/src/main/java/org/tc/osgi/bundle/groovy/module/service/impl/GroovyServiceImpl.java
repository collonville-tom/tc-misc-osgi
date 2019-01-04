package org.tc.osgi.bundle.groovy.module.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.codehaus.groovy.control.CompilationFailedException;
import org.tc.osgi.bundle.groovy.interf.exception.GroovyExecutionException;
import org.tc.osgi.bundle.groovy.interf.module.service.IGroovyService;

import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyCodeSource;
import groovy.lang.GroovyObject;
import groovy.lang.GroovyShell;
import groovy.lang.MetaClass;
import groovy.lang.Script;

/**
 * DroolsServiceImpl.java.
 * http://mrhaki.blogspot.com/2009/11/groovy-goodness-running-groovy-scripts.html
 * 
 * @author collonville thomas
 * @version
 * @track
 */
public class GroovyServiceImpl implements IGroovyService {

	private final GroovyClassLoader classLoader = new GroovyClassLoader();
	private static GroovyServiceImpl instance = null;

	public static GroovyServiceImpl getInstance() {
		if (GroovyServiceImpl.instance == null) {
			GroovyServiceImpl.instance = new GroovyServiceImpl();
		}
		return GroovyServiceImpl.instance;
	}

	// le binding c'est le contenu des parametres a pousser dans le script
	@Override
	public Optional<Object> executeSpecificScript(String path, Optional<Map<String, Object>> binding)
			throws GroovyExecutionException {
		GroovyShell shell;
		if (binding.isPresent()) {
			Binding b = new Binding();
			for (String s : binding.get().keySet())
				b.setProperty(s, binding.get().get(s));
			shell = new GroovyShell(b);
		} else {
			shell = new GroovyShell();
		}
		try {
			// Chargement du script groovy
			Script s = shell.parse(new File(path));
			// Exécution du script
			return Optional.ofNullable(s.run());
		} catch (CompilationFailedException | IOException e) {
			throw new GroovyExecutionException("Une erreur s'est produite lors de l'excution du script groovy " + path,
					e);
		}
	}

	@Override
	public void executeGroovyDirectory(String path, Optional<Map<String, Object>> binding)
			throws GroovyExecutionException {
		GroovyShell shell;
		if (binding.isPresent()) {
			Binding b = new Binding();
			for (String s : binding.get().keySet())
				b.setProperty(s, binding.get().get(s));
			shell = new GroovyShell(b);
		} else {
			shell = new GroovyShell();
		}
		try {

			File dir = new File(path);
			List<File> lsgroovyFile = new ArrayList<>();
			if (dir.isDirectory()) {
				File[] lsFile = dir.listFiles();
				for (File lsf : lsFile) {
					if (lsf.isFile()) {
						lsgroovyFile.add(lsf);
					}
				}
			}
			for (File f : lsgroovyFile) {
				Script s = shell.parse(new File(path));
				s.run();
			}
		} catch (CompilationFailedException | IOException e) {
			throw new GroovyExecutionException("Une erreur s'est produite lors de l'excution du script groovy " + path,
					e);
		}
	}
	
	public void loadGroovyDirectoryClassLib(String path) throws GroovyExecutionException {
		File dir = new File(path);
		List<File> lsgroovyFile = new ArrayList<>();
		if (dir.isDirectory()) {
			File[] lsFile = dir.listFiles();
			for (File lsf : lsFile) {
				if (lsf.isFile()) {
					this.loadGroovyClassLib(lsf.getAbsolutePath());
				}
			}
		}
	}
	
	
	public void loadGroovyClassLib(String path) throws GroovyExecutionException {
		try {
			this.classLoader.parseClass(new File(path));
		} catch (IOException  e) {
			throw new GroovyExecutionException("Une erreur s'est produite lors de l'excution du script groovy " + path,e);
		}
	}

	@Override
	public List<Class> getClassesFrom(Class type) {
		Class[] classes=this.classLoader.getLoadedClasses();
		List<Class> result=new ArrayList<>();
		for(Class c:classes)
		{
			if(c.getSuperclass().equals(type))
			{
				result.add(c);
			}
			for(Class ci:c.getInterfaces())
			if(ci.equals(type))
			{
				result.add(c);
			}
		}
		return result;
	}
	
	@Override
	public ClassLoader getGroovyClassLoader() {
		return this.classLoader;
	}

}
