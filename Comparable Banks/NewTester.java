import java.util.*;
/**
 * Write a description of class NewTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NewTester
{
    public static void main(String[] args)
    {
        Bank b= new Bank("Bank of OSSM",2);

        b.addAccount(new SavingsAccount("dave", 500, 8));
        b.addAccount(new BankAccount("Ferd", 4560, 420));
        b.addAccount(new SavingsAccount("Opple", 1337, 69));
        b.addAccount(new BankAccount("dave", 417735, 7));

        
        BankAccount[] accounts=new BankAccount[1];
        accounts=b.getAccounts().toArray(accounts);
        
        AccountNameComparator anc=new AccountNameComparator();
        
        Arrays.sort(accounts,anc);
        for(int i=0; i<accounts.length; i++)
        {
         System.out.println(accounts[i]);   
        }
    }

}
