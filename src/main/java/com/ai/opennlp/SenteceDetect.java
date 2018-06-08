package com.ai.opennlp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

public class SenteceDetect {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		InputStream inputStream = new FileInputStream("/home/sairam/work/java/langdetect-183 .bin"); 
		SentenceModel model = new SentenceModel(inputStream);
		SentenceDetectorME detector = new SentenceDetectorME(model);
		
		String sentence = "Hi. How are you? what are you doing. " 
		         + "lets explore Open NLP"; 
		       
		
		String sentences[] = detector.sentDetect(sentence);
		
		 for(String sent : sentences)        
	         System.out.println(sent); 

	}

}
