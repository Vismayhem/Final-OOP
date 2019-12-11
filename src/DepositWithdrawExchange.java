import java.util.Scanner;

public class DepositWithdrawExchange {
	public static void main(String args[]) {

		int balance = 10000, Amount_Withdrawn, Amount_Deposited; // this ensures that that the balance is consistent
																	// with the amount of money that can be withdrawn
																	// and deposited
		Scanner ATM_Input = new Scanner(System.in);
		// a boolean that says run program
		
		boolean Run;
		
		Scanner loginCheck = new Scanner(System.in);
		System.out.println("Please enter your username here\n");
		String username = loginCheck.nextLine();
		System.out.println("Please enter your password here\n");
		String password = loginCheck.nextLine();
		if (username.equals("Henry") && password.equals("OOPisFun123")) {
			Run = true;
		}
		else{
			System.out.println("You did not enter your password correctly. You can answer your security question to gain login credentials to your account. Your security question is 'what is your dog's name'\n");
			String securityQuestion = loginCheck.nextLine();
			if(securityQuestion.equals("Sparky")) {
				System.out.println("Your username is 'Henry' and your password is 'OOPisFun123'\n");
				System.out.println(); // this line is added for aesthetic
				System.out.println("Welcome to the OOP ATM.");
				Run = true;
			}
			else {
				System.out.println("You answered your security question incorrectly. Please visit a branch to further troubleshoot this issue.\n");
				System.out.println(); // this line is added for aesthetic
				Run = false;
			}
		}
		
		while (Run) {
			System.out.println("Press 1 to check balance");
			System.out.println("Press 2 to Deposit");
			System.out.println("Press 3 to Withdraw");
			System.out.println("Press 4 to exchange currency");
			System.out.println("Press 5 to log out\n");

			int response = ATM_Input.nextInt();

			switch (response) {
			case 1:
				System.out.println("Your balance is $" + balance); // this is a very basic command for people who want
																	// to check their balance before making a
																	// transaction. We all know the worse feeling is
																	// when you try to make a transaction and it does
																	// not work
				break;
			case 2:
				System.out.println("Your current balance is $" + balance);
				System.out.println("Enter how much money you would like to deposit today.\n");
				Amount_Deposited = ATM_Input.nextInt();
				balance = balance + Amount_Deposited;
				System.out
						.println("Your money has been successfully deposited. Your new balance is $" + balance + "\n");
				break;
			case 3:
				System.out.println("Your current balance is $" + balance);
				System.out.println("Enter how much money you would like to withdraw today.\n");
				Amount_Withdrawn = ATM_Input.nextInt();
				if (balance >= Amount_Withdrawn) { // this is a simple check to make sure that you have enough money to
													// withdraw. Your amount withdrawn has to be less than your balance
					balance = balance - Amount_Withdrawn;
					System.out.println("Please look under the keypad to collect your money. Your new balance is $"
							+ balance + "\n");
				} else {
					System.out.println("Insufficient Balance\n"); // this lets the customer know that they do not have
																	// enough money in their account to withdraw the
																	// amount that they were looking to withdraw
				}
				break;
			case 4:
				System.out.println("Your current balance is $" + balance);
				System.out.println(
						"Which currency would you like to have your money to be exchanged to? Press 6 to have your currency exchanged to Canadian dollars or press 7 to have your currency exchanged to British pounds\n");
				int CurrencyExchangeResponse = ATM_Input.nextInt();
				double AmountToBeExchanged;
				if (CurrencyExchangeResponse == 6) {
					double CanadianExchangeRate = 1.32;
					System.out.println("The current exchange rate for Canadian Dollars is $1 USD = $1.32 CAD\n");
					System.out.println("How much money (USD) would you like to conver to Canadian Dollars (CAD)\n");
					AmountToBeExchanged = ATM_Input.nextDouble();
					if (balance >= AmountToBeExchanged) {
						balance = (int) (balance - AmountToBeExchanged);
						AmountToBeExchanged = (AmountToBeExchanged * CanadianExchangeRate);
						System.out.println(
								"You have successfully exchanged your money. You now have $" + AmountToBeExchanged
										+ " Canadian dollars now. Your new balance is $" + balance + "\n");
					} else {
						System.out.println("Insufficient Balance\n"); // this lets the customer know that they do not
																		// have enough money in their account to
																		// exchange the amount they are looking to
																		// exchange
					}

				} else if (CurrencyExchangeResponse == 7) {
					double BritishExchangeRate = 0.76;
					System.out
							.println("The current exchange rate for British Pounds is $1 USD = £0.76 British Pounds\n");
					System.out.println("How much money (USD) would you like to conver to British Pounds\n");
					AmountToBeExchanged = ATM_Input.nextDouble();
					if (balance >= AmountToBeExchanged) {
						balance = (int) (balance - AmountToBeExchanged);
						AmountToBeExchanged = (AmountToBeExchanged * BritishExchangeRate);
						System.out.println(
								"You have successfully exchanged your money. You now have £" + AmountToBeExchanged
										+ " British Pounds now. Your new balance is $" + balance + "\n");
					} else {
						System.out.println("Insufficient Balance\n"); // this lets the customer know that they do not
																		// have enough money in their account to
																		// exchange the amount they are looking to
																		//H/ exchange
					}
				} else {
					System.out.println("Invalid input\n");
				}

				break;
			case 5:
				System.out.println("Thank you for using OOP ATM");
				Run = false;
				break;
			}
		}
	}
}


