package org.tc.osgi.bundle.groovy.interf.module.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.tc.osgi.bundle.groovy.interf.exception.GroovyExecutionException;


/**
 * IAptIoService.java.
 * @author collonville thomas
 * @version
 * @track
 */
public interface IGroovyService {

	public Optional<Object> executeSpecificScript(String path,Optional<Map<String,Object>> binding) throws GroovyExecutionException;
	public void executeGroovyDirectory(String path,Optional<Map<String,Object>> binding) throws GroovyExecutionException;
	
	public void loadGroovyDirectoryClassLib(String path) throws GroovyExecutionException;
	public void loadGroovyClassLib(String path) throws GroovyExecutionException;
	
	public ClassLoader getGroovyClassLoader();
	public List<Class> getClassesFrom(Class type);
}
