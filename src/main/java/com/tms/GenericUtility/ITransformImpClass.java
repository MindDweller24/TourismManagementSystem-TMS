package com.tms.GenericUtility;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.IConfigurationAnnotation;
import org.testng.annotations.ITestAnnotation;

public class ITransformImpClass implements org.testng.internal.annotations.IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod,
			Class<?> occurringClazz) {
		annotation.setRetryAnalyzer(com.tms.GenericUtility.RetryImpClass.class);
	}

	
	

}
