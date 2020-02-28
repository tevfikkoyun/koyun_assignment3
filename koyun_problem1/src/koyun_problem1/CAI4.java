package koyun_problem1;
import java.security.SecureRandom;
import java.util.Scanner;


public class CAI4 {
	static SecureRandom randomNumbers = new SecureRandom();
	static Scanner userInput = new Scanner(System.in);
	
	static int result;
	static int userAnswer;
	static int num1,num2;
	int score = 0;
	int D=readDifficulty();
	
	public void quiz() {
		
		while(true) {
		
			for(int i=0;i<10;i++) {
			
				num1 = randomNumbers.nextInt(D);	
				num2 = randomNumbers.nextInt(D);	
			
				askQuestion( num1, num2);
				result=num1*num2;
			
				if(readResponse(result)==true){
				
					score++;
					displayCorrectResponse();
				}
			
				else{
				
					displayIncorrectResponse();
				}
				
			}
		
		displayCompletionMessage(score);
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("Do you want to try again?(y/n): ");
		String userAnswer=userInput.next();
		
		if (userAnswer.equals("n"))
			break;
		
		}
	}
	public void askQuestion(int num1, int num2){
		
		System.out.println("What is " + num1 +" multiplied by " + num2 + "?");
		}
	
	public int readDifficulty(){
		
		
		System.out.println("Enter a difficulty level of 1 to 4 : ");
		
		int level=userInput.nextInt();
		int D=0;
		
		if(level==1){
			
			D=10;
		}
		
		else if(level==2){
			
			D=100;
		}
		
		else if(level==3){
			
			D=1000;
		}
		
		else if(level==4){
			
			D=10000;
		}
		
		return D;
	}
	
	
	
	public void displayCompletionMessage(int score){
		
		if(((float)score/10)>=0.75){
			
			System.out.println("Your Result is "+((float)score/10)*100+"%");
			System.out.println("Congratulations, you are ready to go to the next level!");
		}
		
		else{
			
		System.out.println("Your Result is "+((float)score/10)*100+"%");
		System.out.println("Please ask your teacher for extra help.");	
		}	
		
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
		CAI4 app= new CAI4();
		app.quiz();
		
	}
}
