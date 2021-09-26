package generator;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class UserInterface implements ActionListener, ItemListener{
	
	JFrame f = new JFrame();
	JTextArea text;
	JButton generate;
	Settings s = new Settings();
	JCheckBox symbols;
	JCheckBox bigLetters;
	JCheckBox smallLetters;
	JCheckBox includeAll;
	JComboBox<Integer> howManyCharacters;
	

	public UserInterface() {
		generate = new JButton("Generate");
		generate.setBounds(50,50,100,50);
		generate.setBackground(Color.green);
		generate.addActionListener(this);
		
		text = new JTextArea();
		text.setBounds(20,120,250,20);
		
		JTextArea symbolsText = new JTextArea("Include Symbols?");
		symbolsText.setBounds(300,100,150,20);
		symbols  = new JCheckBox();
		symbols.setBounds(450,100,20,20);
		symbols.addItemListener(this);
		
		JTextArea bigLettersText = new JTextArea("Include UppercaseLetters?");
		bigLettersText.setBounds(300,150,150,20);
		bigLetters  = new JCheckBox();
		bigLetters.setBounds(450,150,20,20);
		bigLetters.addItemListener(this);
		
		JTextArea smallLettersText = new JTextArea("Include LowercaseLetters?");
		smallLettersText.setBounds(300,200,150,20);
		smallLetters  = new JCheckBox();
		smallLetters.setBounds(450,200,20,20);
		smallLetters.addItemListener(this);
		
		JTextArea includeAllText = new JTextArea("Include Everything?");
		includeAllText.setBounds(300,250,150,20);
		includeAll  = new JCheckBox();
		includeAll.setBounds(450,250,20,20);
		includeAll.addItemListener(this);
		
		JTextArea howManyCharactersText = new JTextArea("How long should the password be?");
		howManyCharactersText.setBounds(250,50,200,20);
		Integer[] choices = {8, 16, 24, 32};
		howManyCharacters  = new JComboBox<Integer>(choices);
		howManyCharacters.setBounds(450,50,50,20);
		howManyCharacters.addActionListener(this);
		
		f.add(text); f.add(generate); 
		f.add(symbols); f.add(symbolsText);
		f.add(bigLetters); f.add(bigLettersText);
		f.add(smallLetters); f.add(smallLettersText);
		f.add(includeAll); f.add(includeAllText);
		f.add(howManyCharacters); f.add(howManyCharactersText);

		f.setSize(600,400);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == generate) {
			text.setText(s.generate());
		}
		else if(e.getSource() == howManyCharacters) {
			int length = (int) howManyCharacters.getSelectedItem();
			s.setPasswordLength(length);
		}
	}
	
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() == symbols) {
			if(e.getStateChange() == ItemEvent.SELECTED) {
				s.setSymbolsInclude(true);
			} else {
				s.setSymbolsInclude(false);
				includeAll.setSelected(false);
			}
		}
		else if(e.getSource() == bigLetters) {
			if(e.getStateChange() == ItemEvent.SELECTED) {
				s.setUppercaseLettersInclude(true);
			} else {
				s.setUppercaseLettersInclude(false);
				includeAll.setSelected(false);
			}
		}
		else if(e.getSource() == smallLetters) {
			if(e.getStateChange() == ItemEvent.SELECTED) {
				s.setLowercaseLettersInclude(true);
			} else {
				s.setLowercaseLettersInclude(false);
				includeAll.setSelected(false);
			}
		}
		else if(e.getSource() == includeAll) {
			if(e.getStateChange() == ItemEvent.SELECTED) {
				symbols.setSelected(true);
				bigLetters.setSelected(true);
				smallLetters.setSelected(true);
				s.setSymbolsInclude(true);
				s.setLowercaseLettersInclude(true);
				s.setLowercaseLettersInclude(true);
			}
		}
        
    }
	
	public void checkWhichItemChanged(ItemEvent e) {
		e.getSource();
	}

}
