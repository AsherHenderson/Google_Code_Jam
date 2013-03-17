import java.util.Scanner;


public class codejam {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int l = in.nextInt();
		int d = in.nextInt();
		int n = in.nextInt();
		
		String[] library = new String[d+1];
		String[] cases = new String[n];
		
		for(int i=0;i<d+1;i++){
			library[i]=in.nextLine();
		}
		for(int i=0;i<n;i++){
			cases[i]=in.nextLine();
		}
		
		for(int i=0;i<cases.length;i++){
			
			String thisCase = cases[i];
			
			String[] tempLibrary = new String[d];
			for(int k=0;k<d;k++){
				tempLibrary[k]=library[k];
			}
			
			String[] possibleLetters = getPossibleLetters(thisCase);
			
			/*System.out.print("\nCase #"+(i+1));
			for(int x=0;x<possibleLetters.length;x++){
				System.out.print("\n"+possibleLetters[x]);
			}*/
			
			
			tempLibrary = removeNotStartingWith(tempLibrary,possibleLetters);
			
			System.out.printf("Case #%d: %d\n",i+1,tempLibrary.length);
			
		}
		
		in.close();

	}
	
	public static String[] getPossibleLetters(String thisCase){
		
		String[] possibleLettersLong = new String[thisCase.length()];
		
		int i=0;
		while(thisCase.length()>0){
			
			possibleLettersLong[i]=getNextLetter(thisCase);
			thisCase=thisCase.substring(possibleLettersLong[i].length());
			i++;
			
		}
		
		String[] possibleLetters = new String[i];
		
		for(int k=0;k<possibleLetters.length;k++){
			possibleLetters[k]=possibleLettersLong[k];
		}
		
		return(possibleLetters);
		
	}
	
	public static String getNextLetter(String thisCase){
		
		String nextLetter="";
		
		if(thisCase.startsWith("(")){
			int i=0;
			while(thisCase.charAt(i)!=')'){
				i++;
			}
			nextLetter=thisCase.substring(0, i+1);
		}
		else{
			nextLetter=thisCase.substring(0,1);
		}
		
		return(nextLetter);
		
	}
	
	public static String[] removeNotStartingWith(String[] library, String[] letters){
		
		for(int i=0;i<library.length;i++){
			for(int k=0;k<letters.length;k++){
				if(!(beginsWith(library[i],letters[k]))){
					library[i]="0";
				}
			}
		}
		
		library=scrub(library);
		return(library);
		
	}
	
	public static boolean beginsWith(String word, String letters){
		
		char[] letterArray = letters.toCharArray();
		boolean flag=false;
		
		for(int i=0;i<letterArray.length;i++){
			String letter=charToString(letterArray[i]);
			if(word.startsWith(letter)){
				flag=true;
			}
		}
		
		return(flag);
		
	}
	
	public static String charToString(char letter){
		
		String string = "";
		string+=letter;
		
		return(string);
	}
	
	public static String[] scrub(String[] array){
		//Takes a string array, returns same array minus the elements that are equal to the character 0
		
		int count=0;
		for(int i=0;i<array.length;i++){
			if(array[i]=="0"){
				count++;
			}
		}
		
		String[] newArray = new String[array.length-count];
		count=0;
		
		for(int i=0;i<array.length;i++){
			if(array[i]!="0"){
				newArray[count]=array[i];
				count++;
			}
			
		}
		
		return(newArray);
		
	}
	

}
