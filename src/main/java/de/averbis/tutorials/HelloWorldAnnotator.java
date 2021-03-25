/*
 * Copyright 2021 Averbis GmbH
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

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.jcas.JCas;

import de.averbis.tutorials.typesystem.HelloWorldAnnotation;

public class HelloWorldAnnotator extends JCasAnnotator_ImplBase {

	/**
	 * The greeting message.
	 */
	public static final String PARAM_GREETING = "greeting";
	@ConfigurationParameter(name = PARAM_GREETING, defaultValue = "Hi from the HelloWorldAnnotator")
	private String greeting;


	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {

		// Adds a new HelloWorldAnnotation with a greeting that spans the entire document text
		HelloWorldAnnotation annotation = new HelloWorldAnnotation(jcas, 0,
				jcas.getDocumentText().length());
		annotation.setGreeting(greeting);
		annotation.addToIndexes();
	}
}
