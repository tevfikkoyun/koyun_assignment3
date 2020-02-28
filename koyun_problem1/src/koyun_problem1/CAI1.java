package koyun_problem1;
import java.security.SecureRandom;
import java.util.Scanner;

public class CAI1 {

	static SecureRandom randomNumbers = new SecureRandom();
	
	static int result;
	static int userAnswer;
	static int num1,num2;
	
	public void quiz() {

		num1 = randomNumbers.nextInt(10);
		
		num2 = randomNumbers.nextInt(10);
		
		result = num1 * num2;
		askQuestion();
		while(true){
			
			if(readResponse(result)==true){
				
				displayCorrectResponse();
				break;
			}
			else{
				
			displayCorrectResponse();
			askQuestion();
			}
			
		}
	}
	
	public void askQuestion(){
		
		System.out.println("What is " + num1 +" multiplied by " + num2 + "?");
		}
	
	public boolean readResponse(int result) {		
		
		@SuppressWarnings("resource")
		Scanner userInput = new Scanner(System.in);
		userAnswer =userInput.nextInt();
		
		if( isAnswerCorrect(userAnswer,result)==true)
			return true;
		else
			return false;
	}
	
	
	public boolean isAnswerCorrect(int userAnswer, int result ){
		
		if(userAnswer==result){
			
		return true;	
		}
		
		else{
			
		return false;	
		}
		
	}
	
	public void displayCorrectResponse() {
		System.out.println("Very Good!");
	}
	
	public void displayIncorrectResponse() {
		System.out.println("No. Please try again.");
	}

	 
}