package br.com.tradeideas.handler;

public class Palindrono {
	
	
	
	public static void main(String[] args) {
		
		String a = "abccba";
		String b = "abccbx";
		String c = "abccfg";
		String d = "arara";
		String e = "arajb";
		
		Palindrono palin = new Palindrono();
		
		System.out.println(palin.isAlmostPalindrome(a));
		System.out.println(palin.isAlmostPalindrome(b));
		System.out.println(palin.isAlmostPalindrome(c));
		System.out.println(palin.isAlmostPalindrome(d));
		System.out.println(palin.isAlmostPalindrome(e));
		
		
	}
	

boolean isAlmostPalindrome (String text){
  Integer numberOfWrong = 0;
  for (int i=0; i<text.length(); i++){
    char a = text.charAt(i);
    char b = text.charAt(text.length() -1 -i);
    if (a != b){
      numberOfWrong ++;
    }
  }
  if (numberOfWrong <=2){
    return true;
  }
  return false;
}
	

}
