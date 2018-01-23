package org.tc.osgi.bundle.groovy.interf.exception;

public class GroovyExecutionException extends Exception {


  
    public GroovyExecutionException(final String _message) {
        super(_message);
    }

 
    public GroovyExecutionException(final String _message, final Throwable _e) {
        super(_message, _e);
    }
}
