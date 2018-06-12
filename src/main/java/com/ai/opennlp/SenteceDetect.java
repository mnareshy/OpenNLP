package com.ai.opennlp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.util.Span;

public class SenteceDetect {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		InputStream inputStream = new FileInputStream("/home/sairam/work/java/apache-opennlp-1.8.4/Models/en-sent.bin"); 
		SentenceModel model = new SentenceModel(inputStream);
		SentenceDetectorME detector = new SentenceDetectorME(model);
		
		String sentence = "Hi. How are you? what are you doing. " 
		         + "lets explore Open NLP." + "\nThe God is the creater!"+ "\nxxx xxuxuxuxjhjljkj;"; 
		       
		
		String sentences[] = detector.sentDetect(sentence);
		
		 for(String sent : sentences)        
	         System.out.println(sent); 

		 
		 Span span[] = detector.sentPosDetect(sentence);
		 
		 for (int i = 0; i < span.length; i++) {
			 
			 System.out.println(span[i].toString());
			 System.out.println(sentence.substring(span[i].getStart(),span[i].getEnd())); 
			
		}
		 
		double probablities[] =  detector.getSentenceProbabilities();
		
		for (int i = 0; i < probablities.length; i++) {
			
			System.out.println(probablities[i]);
			
		}
		
		
		 
	}

}
