package generator;

import java.util.ArrayList;

public class PasswordGenerator {
	
	public String generatePassword(ArrayList<Integer> include, int lengthOfPassword) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<lengthOfPassword; i++) {
			sb = sb.append(getCharFromNumber(getRandomNumber(include)));
		}
		return sb.toString();
	}
	
	private char getCharFromNumber(int num) {
		return (char)num;
	}
	
	private int getRandomNumber(ArrayList<Integer> includeWhich) {
		int a = - 1;
		a = checkWhichSymbolsToInclude(includeWhich, a);
		switch(a) {
		case 1:
			return getRandomNumNumber();
		case 2:
			return getRandomSmallLetter();
		case 3:
			return getRandomBigLetter();
		case 4:
			return getRandomSymbol();
		default:
			return 1;
		}
	}

	private int checkWhichSymbolsToInclude(ArrayList<Integer> includeWhich, int a) {
		while(true) {
			a = (int) ((Math.random() * 4) + 1);
			for(int i = 0; i<includeWhich.size(); i++) {
				if(a == includeWhich.get(i)) {
					return a;
				}
			}
		}
	}
	
	private int getRandomNumNumber() {
		return (int) ((Math.random() * 10) + 48);
	}
	
	private int getRandomSmallLetter() {
		return (int) ((Math.random() * 26) + 97);
	}
	
	private int getRandomBigLetter() {
		return (int) ((Math.random() * 26) + 65);
	}
	
	private int getRandomSymbol() {
		return (int) ((Math.random() * 15) + 33);
	}
	
	public void showAllNumbersAsChars() {
		for(int i = 0; i < 200; i++) {
			System.out.println(i + " = " + (char)i);
		}
	}
	
}
