
/* First created by JCasGen Fri Nov 23 21:49:30 CET 2018 */
package de.averbis.tutorials;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** A Hello World AnnotationType
 * Updated by JCasGen Fri Nov 23 21:49:30 CET 2018
 * @generated */
public class HelloWorldAnnotation_Type extends Annotation_Type {
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = HelloWorldAnnotation.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("de.averbis.tutorials.HelloWorldAnnotation");
 
  /** @generated */
  final Feature casFeat_greeting;
  /** @generated */
  final int     casFeatCode_greeting;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getGreeting(int addr) {
        if (featOkTst && casFeat_greeting == null)
      jcas.throwFeatMissing("greeting", "de.averbis.tutorials.HelloWorldAnnotation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_greeting);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setGreeting(int addr, String v) {
        if (featOkTst && casFeat_greeting == null)
      jcas.throwFeatMissing("greeting", "de.averbis.tutorials.HelloWorldAnnotation");
    ll_cas.ll_setStringValue(addr, casFeatCode_greeting, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public HelloWorldAnnotation_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_greeting = jcas.getRequiredFeatureDE(casType, "greeting", "uima.cas.String", featOkTst);
    casFeatCode_greeting  = (null == casFeat_greeting) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_greeting).getCode();

  }
}



    