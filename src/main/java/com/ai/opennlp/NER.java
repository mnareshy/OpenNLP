package com.ai.opennlp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinder;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.SimpleTokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.Span;

public class NER {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub



		String names[] = new String[]{"SriRama","sairam","naresh","Mike","I"}; 


		InputStream inputStream = new FileInputStream("/home/sairam/work/java/apache-opennlp-1.8.4/Models/en-ner-person.bin"); 
		TokenNameFinderModel tokenNameFinderModel = new TokenNameFinderModel(inputStream);
		
		NameFinderME nameFinderME = new NameFinderME(tokenNameFinderModel);
		
		Span namesSpans[] = nameFinderME.find(names);
		
		for (int i = 0; i < namesSpans.length; i++) {
			
			System.out.println(namesSpans[i].toString());
	
			
			
		}
		
		
		String sentance = "Hi Robert, i and Mike are working on DROBES! . Anil knows that too! . we all based on Chicago, Just kidding! +"
				+ "We are based on Bengaluru"; 
		
// Finding Names
		
		InputStream inputStream1 = new FileInputStream("/home/sairam/work/java/apache-opennlp-1.8.4/Models/da-token.bin"); 
		TokenizerModel model = new TokenizerModel(inputStream1);
		TokenizerME tokenizer = new TokenizerME(model);
		
		String tokens[] = tokenizer.tokenize(sentance);
		
		Span[] names1 = nameFinderME.find(tokens);
		
		for (int i = 0; i < names1.length; i++) {

			System.out.println(names1[i].toString() + " " + tokens[names1[i].getStart()]);

		}
		
		
// Finding Locations
		
		InputStream inputStreamLoc = new FileInputStream("/home/sairam/work/java/apache-opennlp-1.8.4/Models/en-ner-location.bin"); 
		TokenNameFinderModel tokenNameFinderModelLoc = new TokenNameFinderModel(inputStreamLoc);
		
		NameFinderME nameFinderMELoc = new NameFinderME(tokenNameFinderModelLoc);
		

		
		Span[] locations = nameFinderMELoc.find(tokens);
		
		for (int i = 0; i < locations.length; i++) {

			System.out.println(locations[i].toString() + " " + tokens[locations[i].getStart()]);

		}
		
	/*	double probabilities[] = nameFinderMELoc.probs();
		
		for (int i = 0; i < probabilities.length; i++) {
			
			System.out.println(probabilities[i]);
			
		}
*/

	}

}
