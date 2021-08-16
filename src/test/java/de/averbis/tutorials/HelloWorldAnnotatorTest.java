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

import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngine;
import static org.apache.uima.fit.factory.JCasFactory.createText;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.jcas.JCas;
import org.junit.Test;

import de.averbis.tutorials.typesystem.HelloWorldAnnotation;

public class HelloWorldAnnotatorTest {

	@Test
	public void testThatHelloWorldAnnotationIsAdded() throws Exception {

		String greeting = "Hello World!";

		AnalysisEngine helloWorldAnnotator = createEngine(
				HelloWorldAnnotator.class,
				HelloWorldAnnotator.PARAM_GREETING, greeting);

		JCas jCas = createText("Some sample text.");

		helloWorldAnnotator.process(jCas);

		assertEquals(1, jCas.select(HelloWorldAnnotation.class).count());

		HelloWorldAnnotation helloWorldAnnotation = jCas.select(HelloWorldAnnotation.class)
				.single();
		assertNotNull(helloWorldAnnotation);
		assertEquals(0, helloWorldAnnotation.getBegin());
		assertEquals(jCas.getDocumentText().length(), helloWorldAnnotation.getEnd());
		assertEquals(greeting, helloWorldAnnotation.getGreeting());
	}
}
