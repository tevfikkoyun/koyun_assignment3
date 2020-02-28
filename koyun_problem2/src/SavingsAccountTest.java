
public class SavingsAccountTest {

	public static void main(String[] args) {
		SavingsAccount save1 = new SavingsAccount();
		SavingsAccount save2 = new SavingsAccount();

		save1.setSavingsBalance(2000.00);
		save2.setSavingsBalance(3000.00);
		
		SavingsAccount.modifyInterestRate(0.04);
		
		System.out.printf("Inital Balance:%n save1: %.2f     save2: %.2f%n", save1.getSavingsBalance(), save2.getSavingsBalance());
		
		System.out.printf("12 Months of %.0f%% Annual Interest Monthly:%n", (SavingsAccount.getAnnualInterestRate() * 100));
		for(int i = 0; i < 12; i++) {
			save1.calculateMonthlyInterest();
			save2.calculateMonthlyInterest();
			System.out.printf("Month %d: save1: %.2f     save2: %.2f%n", (i + 1), save1.getSavingsBalance(), save2.getSavingsBalance());
		}
		
		SavingsAccount.modifyInterestRate(0.05);
		
		System.out.printf("12 Months of %.0f%% Annual Interest Monthly:%n", (SavingsAccount.getAnnualInterestRate() * 100));
		for(int i = 0; i < 12; i++) {
			save1.calculateMonthlyInterest();
			save2.calculateMonthlyInterest();
			System.out.printf("Month %d: save1: %.2f     save2: %.2f%n", (i + 1), save1.getSavingsBalance(), save2.getSavingsBalance());
		}
	}

}
