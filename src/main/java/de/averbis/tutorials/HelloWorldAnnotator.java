/**
 * Hello World Annotator implementation
 */
package de.averbis.tutorials;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import de.averbis.tutorials.typesystem.HelloWorldAnnotation;

public class HelloWorldAnnotator extends JCasAnnotator_ImplBase {

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		
		/*
		 * Adds a new HelloWorldAnnotation with a greeting that spans the entire document text
		 */
		String documentText = jcas.getDocumentText();
		
		HelloWorldAnnotation annotation = new HelloWorldAnnotation(jcas);
		annotation.setBegin(0);
		annotation.setEnd(documentText.length());
		annotation.setGreeting("Greetings from the HelloWorldAnnotator");
		annotation.addToIndexes();
	}
}
