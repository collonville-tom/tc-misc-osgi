package org.tc.osgi.bundle.groovy.interf.module.service;

import java.util.Optional;

import org.tc.osgi.bundle.groovy.interf.exception.GroovyExecutionException;

import groovy.lang.Binding;

/**
 * IAptIoService.java.
 * @author collonville thomas
 * @version
 * @track
 */
public interface IGroovyService {

	public Optional<Object> execute(String path,Optional<Binding> binding) throws GroovyExecutionException;
}
