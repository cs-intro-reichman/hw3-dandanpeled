import java.util.Random;

/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));

		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String main_str = preProcess(str1);
		String secondary_str = preProcess(str2);

		for (int i = 0; i < main_str.length(); i++){
			for (int j = 0; j < secondary_str.length(); j++){
				if (main_str.charAt(i) == secondary_str.charAt(j)){

					secondary_str = secondary_str.replaceFirst(Character.toString(secondary_str.charAt(j)), "");

				}
			}

		}

		for (int a = 0; a < secondary_str.length(); a++){
			if (secondary_str.charAt(a) != ' '){
				return false;
			}
		}
		return true;

		}


	
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"

	public static String preProcess(String str) {
		String preProccessedString = "";
		char test_char;

		for (int i = 0; i < str.length(); i++){

			test_char = str.charAt(i);
			if (Character.isLetter(test_char)) {
				test_char = Character.toLowerCase(test_char);
				preProccessedString += test_char;
			}else if(test_char == ' '){
				preProccessedString += test_char;
			}
			
		}

		return preProccessedString;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String play_str = str;
		String new_anagram = "";

		while (play_str != ""){
			int rand_num = (int)(Math.random()*(play_str.length()));
			new_anagram = new_anagram + play_str.charAt(rand_num);
			play_str = play_str.replaceFirst(Character.toString(play_str.charAt(rand_num)), "");

		}


	return new_anagram;
	}
}
