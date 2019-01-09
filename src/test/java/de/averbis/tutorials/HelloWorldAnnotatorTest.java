package de.averbis.tutorials;

import org.apache.uima.UIMAException;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.JCasFactory;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.averbis.tutorials.typesystem.HelloWorldAnnotation;


public class HelloWorldAnnotatorTest {
	
	
	private String documentText;
	private String greeting;
	private JCas jCas;
	
	@Before
	public void setUp() throws UIMAException {
		
		this.documentText = "Some sample text";
		this.greeting = "Hello World!";
		this.jCas = JCasFactory.createJCas();
		this.jCas.setDocumentText(this.documentText);
	}

	@Test
	public void testThatHelloWorldAnnotationIsAdded() throws AnalysisEngineProcessException, ResourceInitializationException {
		
		AnalysisEngine helloWorldAnnotator = AnalysisEngineFactory.createEngine(HelloWorldAnnotator.class, HelloWorldAnnotator.PARAM_GREETING, this.greeting);
		helloWorldAnnotator.process(this.jCas);
		
		AnnotationIndex<HelloWorldAnnotation> annotationIndex = this.jCas.getAnnotationIndex(HelloWorldAnnotation.class);
		Assert.assertEquals(1, annotationIndex.size());
		
		HelloWorldAnnotation helloWorldAnnotation = annotationIndex.iterator().get();
		Assert.assertNotNull(helloWorldAnnotation);
		Assert.assertEquals(0, helloWorldAnnotation.getBegin());
		Assert.assertEquals(this.documentText.length(), helloWorldAnnotation.getEnd());
		Assert.assertEquals(this.greeting, helloWorldAnnotation.getGreeting());
	}

}
