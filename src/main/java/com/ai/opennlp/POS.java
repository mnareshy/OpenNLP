package com.ai.opennlp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinder;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSSample;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.SimpleTokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.Span;

public class POS {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub



		
		
		String sentance = "Hi Robert, i and Mike are working on DROBES! . Anil knows that too! . we all based on Chicago, Just kidding! +"
				+ "We are based on Bengaluru"; 
		

		
		InputStream inputStream1 = new FileInputStream("/home/sairam/work/java/apache-opennlp-1.8.4/Models/da-token.bin"); 
		TokenizerModel model = new TokenizerModel(inputStream1);
		TokenizerME tokenizer = new TokenizerME(model);
		
		String tokens[] = tokenizer.tokenize(sentance);
		
		
		
		
		InputStream inputStreamPos = new FileInputStream("/home/sairam/work/java/apache-opennlp-1.8.4/Models/en-pos-maxent.bin"); 
		POSModel posModel = new POSModel(inputStreamPos);
		
		POSTaggerME posTaggerME = new POSTaggerME(posModel);
		
		

		
		String[] posTags = posTaggerME.tag(tokens);
		
		POSSample posSample = new POSSample(tokens, posTags);
		System.out.println(posSample);
		
		
		
	

	}

}
