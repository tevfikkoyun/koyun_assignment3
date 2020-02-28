package koyun_problem1;
import java.security.SecureRandom;
import java.util.Scanner;

public class CAI2 {
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
	public static void displayCorrectResponse() {
		SecureRandom rand = new SecureRandom();
		int randNumber = (rand.nextInt(4) + 1);
		switch(randNumber) {
			case 1:
				System.out.println("Very good!");
				break;
			case 2:
				System.out.println("Excellent!");
				break;
			case 3:
				System.out.println("Nice work!");
				break;
			case 4:
				System.out.println("Keep up the good work!");
				break;
		}
	}
	public static void displayIncorrectResponse() {
		SecureRandom rand = new SecureRandom();
		int randNumber = (rand.nextInt(4) + 1);
		switch(randNumber) {
			case 1:
				System.out.println("No. Please try again.");
				break;
			case 2:
				System.out.println("Wrong. Try once more.");
				break;
			case 3:
				System.out.println("Don’t give up!");
				break;
			case 4:
				System.out.println("No. Keep trying.");
				break;
		}
	}
	public static void main(String[] args) {
		CAI2 app= new CAI2();
		app.quiz();
		
	}
}
