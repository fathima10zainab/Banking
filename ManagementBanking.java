import java.util.Scanner;
class BankDetails
{
	private String accno;
	private String name;
	private String acc_type;
	private long balance;
	Scanner sc = new Scanner(System.in);
	public void OpenAccount()
	{
		System.out.println("Enter Account No.= ");
		accno = sc.next();
		System.out.println("Enter Account type =");
		acc_type = sc.next();
		System.out.println("Enter Name= ");
		name = sc.next();
		System.out.println("Enter Account balance =");
		balance = sc.nextLong();
		
	}
	
	public void showAccount()
	{
		System.out.println("Name of account holder=" +name);
		System.out.println("Account no.=" +accno);
		System.out.println("Account type =" +acc_type);
		System.out.println("Balance=" +balance);

	}
	 public void deposit()
	{
		long amt;
		System.out.println("Enter the account you want to deposit = ");
		amt =sc.nextLong();
		balance = balance+amt;

	}
	  public void withdrawal()
		{
			long amt;
			System.out.println("Enter the account you want to withdrawal = ");
			amt =sc.nextLong();
			if(balance>=amt) {
				balance = balance - amt;
				System.out.println("Balance after withdrawal =" +balance);
				}
			else
			{
				System.out.println("Your balance is less than " + amt +"\tTransaction failed....!!!");
				
			}

		}
	  public boolean search(String acc_no)
	  {
		 if(accno.equals(acc_no)) {
			 showAccount();
			 return (true);
		 }
		 return (false);
		 
		 }
}
public class ManagementBanking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("How many number of customer do you want to input =");
		int n = sc.nextInt();
		BankDetails c[] = new BankDetails[n];
		for(int i=0;i<c.length;i++)
		{
			c[i] = new BankDetails();
		c[i].OpenAccount();
		}
		int ch;
       do
       {
    	   System.out.println("\n *****Management Banking System*****");
    	   System.out.println("1.Display all Account details \n 2. Search by Account Number \n 3.Deposite the Amount \n 4. Withdrawal the Amount \n 5.Exit");
    	   System.out.println("Enter your choice=");
    	   ch= sc.nextInt();
    	   switch(ch)
    	   {
    	   case 1:
    		   for(int i=0;i<c.length;i++)
    		   {
    			   c[i].showAccount();
    		   }
    		   break;
    	   case 2:
    		   System.out.println("Enter Account no. you want to search = ");
    		   String acc_no = sc.next();
    		   boolean found = false;
    		   for(int i=0;i<c.length;i++)
    		   {
    			   found = c[i].search(acc_no);
    			   if(found)
    			   {
    				   break;
    			   }
    		   }
    		   if(!found)
    		   {
    			   System.out.println("Search failed!!! Account does not exist.....!!!!");
    		   }
    		   break;
    	   case 3:
    		   System.out.println("Enter Account no. =");
    		   acc_no = sc.next();
    		   found=false;
    		   for(int i=0;i<c.length;i++)
    		   {
    			   found = c[i].search(acc_no);
    			   if(found) {
    				   c[i].deposit();
    				   break;
    			   }
    		   }
    		   if(!found)
    		   {
    			   System.out.println("Search failed! Account does not exist....!!!!");
    		   }
    		   break;
    	   case 4:
    		   System.out.println("Enter Account no.= ");
    		   acc_no = sc.next();
    		   found=false;
    		   for(int i=0;i<c.length;i++)
    		   {
    			   found=c[i].search(acc_no);
    			   if(found)
    			   {
    				   c[i].withdrawal();
    				   break;
    				   
    			   }
    		   }
    		   if(!found)
    		   {
    			   System.out.println("Search failed!!! Account does not exist.....!!!!");
    			   
    		   }
    		   break;
    	   case 5:
    		   System.out.println("Seee you soon.....");
    		   break;
    	   }
    	   
       }
       while(ch!=5);
	}
}
