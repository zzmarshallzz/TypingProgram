import java.util.Random;

public class WordList {

public String[] wordList = new String[5];
	
//array length
public int arrLength = wordList.length;
	
	
	public String pickWord() {	

		Random rand = new Random();
				

	
	wordList[0] = "hello";
	wordList[1] = "Dingo";
	wordList[2] = "Macintosh";
	wordList[3] = "Studying";
	wordList[4] = "Whoa!";
	
	return wordList[rand.nextInt(5)];

	}

}