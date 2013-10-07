import T1.lib.*;
import java.util.Scanner;
public class TrollGames 
{
	private static SuperChain<User> trollGamesList = new SuperChain<>();
	public static Scanner sn =  new Scanner( System.in );
	public static void main(String[] args) 
	{
		menu();
	}

	private class User implements Comparable<User>, Serializable
	{
		private String name;	
		private double accountNumber;
		private double funds;
		private String status;

		public User ( double accountNumber, String name,  double funds, String status)
		{
			this.name = name;
			this.accountNumber = accountNumber;
			this.funds = funds;
			this.status = status;
		}

		public User ( double accountNumber, String name,  double funds )
		{
			this.name = name;
			this.accountNumber = accountNumber;
			this.funds = funds;
		}

		@Override
		public int compareTo ( User user)
		{
			return this.accountNumber - user.accountNumber;
		}

		@Override
		public boolean equals ( Object o ) 
		{
			if (this == null )
			{
				return false;
			}
			if (this == o) 
			{
				return true;	
			}

			if (! ( o instanceof User)) 
			{
				return false;	
			}

			return this.accountNumber == ( ( User ) o).accountNumber;
		}
	}

	private class Methods
	{
		public static void apply_monthly_fee ( )
		{
			ChainNodeTaller1<T> currentNode = firstNode;
			for ( int i = 0 ; i < trollGamesList.size ; i++ ) 
			{
				if ( currentNode.status == "saving")
				{
					currentNode.funds -= 10000;
				}
				if ( currentNode.status == "checking" ) 
				{
					currentNode.funds -= 5000;	
				}
				currentNode = currentNode.next;
			}
		}

		public static void create( double accountNumber, String name, double deposit)
		{
			User newUser  = new User(accountNumber,name, deposit, status = "saving");
			trollGamesList.add( 0, newUser );
		}
		
		public static void create( double accountNumber, char a)
		{
			if (a == '*') 
			{
				createMenu( accountNumber );
			}
		}

		public static void createMenu( double accountNumber )
		{
			System.out.println(" Enter customer name: " );
			String name = sn.nextLine();
			System.out.println(" Enter deposit: ");
			double funds = sn.nextDouble();
			System.out.println(" Saving or Checking account [S/C]: ");
			String status = sn.nextLine();
			if ( status = "S") 
			{
				status = "saving";	
			}
			if ( status = "C" ) 
			{
				status = "checking";	
			}

			create ( accountNumber, name , funds , status);
		}

		public static void deposit( double accountNumberDeposit, double amount)
		{
			ChainNodeTaller1<T>currentNode =  firstNode;
			for( int i =  0 ; i < trollGamesList.size ; i++ )
			{
				if (currentNode.accountNumber = accountNumberDeposit)
				{
					currentNode.accountNumber +=  amount;
				}
				currentNode = currentNode.next;
			}
		}
		
		public static void edit ( double accountNumberEdit )
		{
			ChainNodeTaller1<T> currentNode = firstNode;
			for( int i =  0 ; i < trollGamesList.size ; i++ )
			{
				if ( currentNode.accountNumber == accountNumberEdit ) 
				{
					System.out.println( "customer_name: ");	
					currentNode.name = sn.nextLine();
					System.out.println("account_type [S/C]: ");
					String status = sn.nextLine();
					if ( status = "S") 
					{
						status = "saving";	
					}
					if ( status = "C" ) 
					{
						status = "checking";	
					}

					currentNode.status = status;
				}

				currentNode = currentNode.next;
			}
		}

		public static void remove( double accountNumber )
		{
			ChainNodeTaller1<T> currentNode = firstNode;
			while (currentNode.next = null)
			{
				if (currentNode.accountNumber == accountNumber) 
				{
					remove(currentNode)	;
				}
				currentNode.next;
			}
			System.out.println("Error - account"+ accountNumber+ " was not found");
		}

		public static void withdrawal( double accountNumber,double amount )
		{
			ChainNodeTaller1<T> currentNode = firstNode;
			for ( int  i = 0 ; i < trollGamesList.size ; i++ ) 
			{
				if ( currentNode.accountNumber == accountNumber ) 
				{
					if ( currentNode.accountNumber - accountNumber) < 0 
					{
						System.out.println("Error Insufficient funds ");
						return;
					}
					currentNode.accountNumber -= amount;	
				}	
			}
		}

		public static void quit ()
		{
			return 0;
		}

		public static void menu ( )
		{
			System.out.println( "------------------------------------------ MAIN MENU ------------------------------------------  ");
			System.out.println( "apply_monthly_fee - Apply monthly fee ($10.000 for saving accounts, $5.000 for checking accounts)");
			System.out.println( "create account_number name deposit - Create a new saving account with a given deposit");
			System.out.println( "create account_number * - Create an account and prompt for each field information");
			System.out.println( "deposit account_number amount - Deposit");
			System.out.println( "edit account_number - Allows to modify all account fields");
			System.out.println( "query account_number - Print account information");
			System.out.println( "menu - Print main menu");
			System.out.println( "print - Print out all bank accounts");
			System.out.println( "remove account_number - Remove an account");
			System.out.println( "withdrawal account_number amount - Withdraw");
			System.out.println( "quit - Quit the system");
			System.out.println( "------------------------------------------------------------------------------------------------");
		}




	}
}