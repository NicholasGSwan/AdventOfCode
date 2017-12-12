import java.util.Scanner;

public class inverseCaptcha {
	
	static int evaluateCaptcha(String num) {
		int totalConsecutive = 0;
		
		String[] numArray = num.split("");
		System.out.println(numArray[numArray.length - 1]);
		System.out.println(numArray.length);
		System.out.println(String.valueOf(numArray[0]));
		for(int i = 0; i< numArray.length -1; i++) {
			if(Integer.valueOf(numArray[i]) == Integer.valueOf(numArray[i+1])) {
				totalConsecutive += Integer.valueOf(numArray[i]) ;
			}
			
		}
		if(Integer.valueOf(numArray[0]) == Integer.valueOf(numArray[(numArray.length-1)])) {
			totalConsecutive += Integer.valueOf(numArray[0]);
		}
		
		
		
		return totalConsecutive;
	}
	static int evaluateCaptchaForHalfWay(String num) {
		int totalHalfway = 0;
		
		String[] numArray = num.split("");
		System.out.println(numArray[numArray.length - 1]);
		System.out.println(numArray.length);
		System.out.println(String.valueOf(numArray[0]));
		int halfway = numArray.length/2;
		for(int i = 0; i< numArray.length; i++) {
			if(halfway<numArray.length) {
				
				if(Integer.valueOf(numArray[i]) == Integer.valueOf(numArray[halfway])) {
					
					totalHalfway += Integer.valueOf(numArray[i]) ;
				}
			}
			if(halfway>=numArray.length) {
				System.out.println("I've made it to the first part");
			int distanceFromBeginning = halfway - numArray.length;
			System.out.println("I should be in the second part");
				if(Integer.valueOf(numArray[i]) == Integer.valueOf(numArray[distanceFromBeginning])) {
					totalHalfway  += Integer.valueOf(numArray[distanceFromBeginning]);
				}
			}
			halfway++;
		}
		
		
		return totalHalfway;
	}
	
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("what is the captcha?");
		String numberToEvaluate = in.nextLine();
		int result = evaluateCaptcha(numberToEvaluate);
		int secondResult = evaluateCaptchaForHalfWay(numberToEvaluate);
		System.out.println("the number of consecutive characters are: "+ result);
		System.out.println("The number of matching digits equidistant from each other are: "+ secondResult);
		
		
	}

}
