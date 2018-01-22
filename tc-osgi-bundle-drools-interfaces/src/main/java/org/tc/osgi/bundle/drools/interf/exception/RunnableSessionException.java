package org.tc.osgi.bundle.drools.interf.exception;

public class RunnableSessionException extends Exception {


  
    public RunnableSessionException(final String _message) {
        super(_message);
    }

 
    public RunnableSessionException(final String _message, final Throwable _e) {
        super(_message, _e);
    }
}
