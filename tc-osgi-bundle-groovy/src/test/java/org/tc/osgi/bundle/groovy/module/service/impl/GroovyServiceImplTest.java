package org.tc.osgi.bundle.groovy.module.service.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.tc.osgi.bundle.groovy.interf.exception.GroovyExecutionException;

public class GroovyServiceImplTest {

	@Test
	public void test() {
		String path="src/test/resources/test.groovy";
		
		try {
			GroovyServiceImpl.getInstance().loadGroovyClassLib(path);
			for(Class c:GroovyServiceImpl.getInstance().getClassesFrom(MonInterface.class))
			{
				assertEquals("Sample", c.getName());
			}
		} catch (GroovyExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
