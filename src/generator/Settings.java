package generator;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Settings{
	
	PasswordGenerator p;
	private boolean symbolsInclude = false;
	private boolean uppercaseLettersInclude = false;
	private boolean lowercaseLettersInclude = false;
	private int  passwordLength = 8;
	
	public Settings() {
		
		p = new PasswordGenerator();
	}
	
	public String generate() {
		ArrayList<Integer> include = new ArrayList<>();
		include.add(1);
		if(symbolsInclude) {
			include.add(4);
		}
		if(uppercaseLettersInclude) {
			include.add(3);
		}
		if(lowercaseLettersInclude) {
			include.add(2);
		}
		return p.generatePassword(include, passwordLength);
	}
}
