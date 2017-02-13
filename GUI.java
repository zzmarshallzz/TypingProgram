import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUI extends JFrame implements KeyListener {

//Variables of text field and label for output and input.
	JTextField keyText = new JTextField(20);
	JLabel keyLabel = new JLabel("Type in the correct letters");
	
//creating object to use method from WorldList class.
	WordList wordListObj = new WordList();
	String wordPulled = wordListObj.pickWord();
	
	JLabel wordPulledLabel = new JLabel("Type in the Letters of this word: 			" + wordPulled);

//variables for the keyTyped Method within the KeyListener Interface
	public char keyChar;
//Counters: i = location of which character you are on for the word at hand, ii = check against length of word, iii = iteration of checkNoNewNumbers method.
	private int i = 0;
	private int ii = i+1;
	private int iii = 0;
	
//Variable to display the Timer via JLabel's Text String output.
	JLabel timerLabel = new JLabel("");

//ArrayList to check if a word has been typed or not, in effort to prevent user from typing in the same word twice.
	ArrayList<String> flagNoNewNumbers = new ArrayList<String>();
	
	
//Sets up new canvas and layout(text output boxes and input text fields)
	public GUI () {
		keyText.addKeyListener(this);
		setSize (400, 400);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BorderLayout layout= new BorderLayout();
		setLayout(layout);
		add(keyLabel, BorderLayout.CENTER);
		add(wordPulledLabel, BorderLayout.NORTH);
		add(keyText, BorderLayout.SOUTH);
		add(timerLabel, BorderLayout.EAST);
		flagNoNewNumbers.add(wordPulled);		
	}

//part of the interface for KeyListener, this is where the logic is executed
	public void keyTyped (KeyEvent e){
		keyChar = e.getKeyChar(); 
		getWord();
	}
		
	public void getWord(){
			
		
		System.out.println(flagNoNewNumbers);
		
		if (keyChar == wordPulled.charAt(i)){	
			
			keyLabel.setText("You typed it correctly!");
			System.out.println(wordPulled.length());
			System.out.println(i);
			System.out.println(ii);
			System.out.println(flagNoNewNumbers);	
			
			if (ii == wordPulled.length()){
				resetWord();
				keyLabel.setText("You typed it correctly!");
				checkFinish();
					}
			i++;
			ii++;
			}
		else
			{
				keyLabel.setText("Try another key...");
				
			}
		keyText.setText("");
		
		}

//method to reset the word that has been pulled from the WordList Class.
	void resetWord(){
		i=0;
		ii=i+1;
		wordPulledLabel.setText("");
		wordPulled = wordListObj.pickWord();
			checkNoNewNumbers();
		wordPulledLabel.setText("Type in the Letters of this word: 			" + wordPulled);
			getWord();
		
	}
	
//method that checks an ArrayList (used to keep track of words already used) to see if pulled words were inserted or used already.
	void checkNoNewNumbers(){
		
		if (flagNoNewNumbers.contains(wordPulled) && (flagNoNewNumbers.size()!=wordListObj.arrLength))
			{
			resetWord();
			}
		else if (flagNoNewNumbers.contains(wordPulled) &&(flagNoNewNumbers.size()==wordListObj.arrLength)){
			wordPulledLabel.setText("You've typed all the words! Congratulations.");
		}
		else
			{
			flagNoNewNumbers.add(wordPulled);
			}
	}
	
//method to check what word the user is typing, whether it is the next to alst word or the user has typed all the words.	
	void checkFinish(){
		if (flagNoNewNumbers.contains(wordPulled) && (flagNoNewNumbers.size()==wordListObj.arrLength) && (iii==0)) {
			wordPulledLabel.setText("Almost there... Last word:      " + wordPulled);
			iii++;
		}else if (flagNoNewNumbers.contains(wordPulled) && (flagNoNewNumbers.size() == wordListObj.arrLength) && (iii==1))
		{
			wordPulledLabel.setText("You've typed all the words! Congratulations.");
			long end = System.currentTimeMillis( );
			long diff = (end - AppStart.start);
			String diff2 = String.valueOf(diff);
			timerLabel.setText("You completed in "+ diff2 + " milliseconds");
		}
		}	
	
	
//Not used
	public void  keyPressed (KeyEvent e){
	}
//Not used
	public void keyReleased(KeyEvent txt) {
	}
}
