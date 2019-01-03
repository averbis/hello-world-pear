/*
 * Copyright 2018 Averbis GmbH
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.averbis.tutorials;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import de.averbis.tutorials.typesystem.HelloWorldAnnotation;

public class HelloWorldAnnotator extends JCasAnnotator_ImplBase {

	/*
	 * the greeting message
	 */
	private String greeting;
	
	/*
	 * parameters
	 */
	public static final String GREETING_PARAMETER_NAME = "greeting";
	
	
	@Override
	public void initialize(UimaContext uimaContext) throws ResourceInitializationException {
		
		super.initialize(uimaContext);
		
		this.greeting = (String) uimaContext.getConfigParameterValue(GREETING_PARAMETER_NAME);
	}
	
	
	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		
		/*
		 * Adds a new HelloWorldAnnotation with a greeting 
		 * that spans the entire document text
		 */
		String documentText = jcas.getDocumentText();
		
		HelloWorldAnnotation annotation = new HelloWorldAnnotation(jcas);
		annotation.setBegin(0);
		annotation.setEnd(documentText.length());
		annotation.setGreeting(this.greeting);
		annotation.addToIndexes();
		
		
	}
}
