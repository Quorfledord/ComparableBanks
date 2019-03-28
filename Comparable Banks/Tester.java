import java.io.*;
import java.util.*;
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tester
{
    public static void main(String[] args) throws IOException
    {
        String[] bankStuff=ReadFromFile.ReadFile("E:/temp_nerd/BankofOSSM.txt");
        String bankName=bankStuff[0].split("=")[1];
        int numEmploy=Integer.parseInt(bankStuff[1].split("=")[1]);

        Bank b=new Bank(bankName, numEmploy);

        BankAccount[] acc=new BankAccount[1];     
        acc=b.getAccounts().toArray(acc);

        for(int i=2; i<bankStuff.length;i++)
        {
            if(bankStuff[i].startsWith("SavingsAccount"))
            {
                String saversName=bankStuff[i].split("=")[1];
                //int accountNumber=Integer.parseInt(bankStuff[i+1].split("=")[1]);
                double balance=Double.parseDouble(bankStuff[i+2].split("=")[1]);
                double rate=Double.parseDouble(bankStuff[i+3].split("=")[1]);

                SavingsAccount saver=new SavingsAccount(saversName,balance,rate);
                b.addAccount(saver);
            }
            else if(bankStuff[i].startsWith("BankAccount"))
            {
                String bankerName=bankStuff[i].split("=")[1];
                //int accountNumber=Integer.parseInt(bankStuff[i+1].split("=")[1]);
                double balance=Double.parseDouble(bankStuff[i+2].split("=")[1]);
                BankAccount banker=new BankAccount(bankerName,balance);
                b.addAccount(banker);
            }

        }
        Scanner kbl= new Scanner (System.in);
        Scanner kb=new Scanner(System.in);
        do
        {
            System.out.println("Please input the number of your selection.");
            System.out.println("0: Exit");
            System.out.println("1: Create a Bank Account");
            System.out.println("2: Create a Savings Account");
            System.out.println("3: Sort Existing Accounts by account number: ");
            System.out.println("4: Sort Existing Accounts by account name: "); 
            System.out.println("5: Sort Existing Accounts by account type: ");
            
            int choice=kb.nextInt();
            if(choice==0)
                break;
            else if(choice==1)
            {
                System.out.print("Please enter the name for the account: ");   
                String bName=kbl.nextLine();
                System.out.print("Please enter the starting deposit for the account: ");
                double bDeposit=kb.nextDouble();
                BankAccount newBanker=new BankAccount(bName,bDeposit);
                b.addAccount(newBanker);
            }
            else if(choice==2)
            {
                System.out.print("Please enter the name for the account: ");   
                String sName=kbl.nextLine();
                System.out.print("Please enter the starting deposit for the account: ");
                double sDeposit=kb.nextDouble();
                System.out.print("Please enter the rate for the savings account: ");
                double sRate=kb.nextDouble();
                SavingsAccount newSaver=new SavingsAccount(sName,sDeposit,sRate);
                b.addAccount(newSaver);
            }
            else if(choice==3)
            {
              AccountNumComparator gegh=new AccountNumComparator();
              Arrays.sort(acc,gegh);
              b.updateAccounts(acc);
            }
            else if(choice==4)
            {
                AccountNameComparator gort=new AccountNameComparator();
                Arrays.sort(acc,gort);
                b.updateAccounts(acc);
            }
            else if(choice==5)
            {
               AccountTypeComparator terip=new AccountTypeComparator();
               Arrays.sort(acc,terip);
               b.updateAccounts(acc);
            }
            else
            System.out.println("Please enter one of the given numbers, ya rascal");
        }
        while (true);
        FileWriter fw = new FileWriter("E:/SortedAccounts.txt");
        PrintWriter pw = new PrintWriter(fw);
        String ss=b.toString();
        Scanner scan=new Scanner(ss);
        while(scan.hasNext())
        {
         pw.println(scan.hasNextLine());
        }
        pw.close();
        fw.close();
    }

}
 