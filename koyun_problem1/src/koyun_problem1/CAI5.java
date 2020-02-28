package koyun_problem1;
import java.security.SecureRandom;
import java.util.Scanner;

public class CAI5 {
	static SecureRandom randomNumbers = new SecureRandom();
	static Scanner userInput = new Scanner(System.in);
	
	static int result;
	static int userAnswer;
	static int num1,num2;
	int score = 0;
	int D=readDifficulty();
	int P=readProblemType();
	
	public void quiz(){
		
		while(true){
		
		for(int i=0;i<10;i++){
			
			num1 = randomNumbers.nextInt(D);	
			num2 = randomNumbers.nextInt(D);	
			 if(D==1){
			
				askQuestion( num1, num2,D);
				result=num1+num2;
			 }
			 
			 else if(D==2){
				 
				askQuestion( num1, num2,D);
				result=num1*num2;
			 }	 
				 
			 else if(D==3){
				 
				askQuestion( num1, num2,D);
				result=num1-num2;
			 }	
			 else if(D==4){
				while(num2 == 0){
					num2 = generateQuestionArgument(D);
				}
				askQuestion(num1, num2,P);
				result=(num1/num2);
			 }	
			 
			 else if(D==5){
				 
				 int mix = generateQuestionArgument(4);
				 mix++; // add 1 (no zero range is 1 to 4)
				 
				 if(mix==1){
					 
					askQuestion(num1,num2,D);
					result=num1+num2;
				 }
				 
				 else if(mix==2){
					 
					askQuestion(num1,num2,D);
					result=num1*num2;
				 }
				 
				 else if(mix==3){
					 
					askQuestion(num1,num2,D);
					result=num1-num2;
					 
				 }
				 
				 else if(mix==4){
					 while(num2 == 0){
						num2 = generateQuestionArgument(D);
					}
					askQuestion(num1, num2,mix);
					result=(num1/num2);
				 }

			 }	
			 
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
	public int generateQuestionArgument(int D){
		
		return randomNumbers.nextInt(D);
	}
	
	public void askQuestion(int num1,int num2,int P){


		if(P==1){
		
			System.out.println("How much is "+num1+" plus "+num2+"?");
		}

		else if(P==2){
		
			System.out.println("How much is "+num1+" times "+num2+"?");
		}	 
		 
		else if(P==3){
		
			System.out.println("How much is "+num1+" minus "+num2+"?"); 
		}	
		
		else if(P==4){
		
			System.out.println("How much is "+num1+" divide "+num2+"?");
			
		}	
		
	}
	public int readOperation(){
		
		
		System.out.println("Select Arithmetic Operation 1 => +, 2 => *, 3 => -, 4 => / and 5 => mix equations: ");
		Scanner userInput = new Scanner(System.in);
		int D=userInput.nextInt();
		return D;
		
	}
	public int readProblemType(){
		
		return readOperation();
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
		CAI5 app= new CAI5();
		app.quiz();
		
	}
}
	