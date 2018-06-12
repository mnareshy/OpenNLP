package com.ai.opennlp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.SimpleTokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.Span;

public class Tokanize {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		

		String sentence = "Hi. How are you? what are you doing. " 
				+ "lets explore Open NLP." + "\nThe God is the creater!"+ "\nxxx xxuxuxuxjhjljkj;"; 


		SimpleTokenizer simpleTokanizer =  SimpleTokenizer.INSTANCE;

		String tokens[] = simpleTokanizer.tokenize(sentence);

		for (int i = 0; i < tokens.length; i++) {

			System.out.println(tokens[i]);

		}

		WhitespaceTokenizer whitespaceTokenizer =  WhitespaceTokenizer.INSTANCE;

		tokens = whitespaceTokenizer.tokenize(sentence);

		for (int i = 0; i < tokens.length; i++) {

			System.out.println(tokens[i]);

		}


		
		InputStream inputStream = new FileInputStream("/home/sairam/work/java/apache-opennlp-1.8.4/Models/da-token.bin"); 
		TokenizerModel model = new TokenizerModel(inputStream);
		TokenizerME tokenizer = new TokenizerME(model);
		
		tokens = tokenizer.tokenize(sentence);
		
		for (int i = 0; i < tokens.length; i++) {

			System.out.println(tokens[i]);

		}
		
		Span span[] = tokenizer.tokenizePos(sentence);
		
		for (int i = 0; i < span.length; i++) {
			
			System.out.println(sentence.substring(span[i].getStart(),span[i].getEnd())+ "  " + span[i]);
			
		}
		
		double prababilities[] = tokenizer.getTokenProbabilities();
		
		for (int j = 0; j < prababilities.length; j++) {
			
			System.out.println(prababilities[j]);

		}
		
	
	}

}
