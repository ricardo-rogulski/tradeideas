package br.com.tradeideas.handler;

public class PopularNumber {
	
	
	
	public static void main(String[] args) {
		
		int a[] = {34,31,34,77,82};
		
		PopularNumber popNumber = new PopularNumber();
		
		popNumber.mostPopularNumber(a, 5);
		
	}
	

	
	
	public void mostPopularNumber(int []numbers, int arraySize){
		
	
		int maxRepeats = 0;
		int mostRepeatedNumber = 0;
		int repeats = 0; 
		
		for (int i=0; i<arraySize; i++){
			for (int j=0; j<arraySize; j++){
				if (numbers[i]==numbers[j]){
					repeats++;
				}
			}
			if (repeats > maxRepeats){
				maxRepeats = repeats;
				mostRepeatedNumber = numbers[i];
			}
		}

		System.out.println(mostRepeatedNumber+" appears "+repeats+ "times");
	}
	
}


