import java.util.List;

public class Bank {
    private String bankName;
    private List<Account> accounts;
    private int accountSequence=1000;
    private int totalDeposits=0;


    public Bank(String name){
        bankName = name;
    }

    public void createAccount(double initialDeposit) throws InvalidStartingBalanceError{
        Account a = new Account(accountSequence, initialDeposit);
        accounts.add(a);
        accountSequence++;
        totalDeposits+=initialDeposit;
    }
    public Account lookupAccount(int accountNumber) throws AccountNotFoundError{
        for(int i=0;i<accounts.size();i++){
            if(accountNumber == accounts.get(i).accountNumber){
                return accounts.get(i);
            }
        }
        throw new AccountNotFoundError("No Account Found!");
    }
    public void closeAccount(int accountNumber) throws AccountNotFoundError, NonZeroAccountBalanceError{
        Account a = lookupAccount(accountNumber);
        if(a.balance == 0){
            accounts.remove(a);
        }else{
            throw new NonZeroAccountBalanceError("Account still contains balance");
        }
    }
    public void deposit(int accountNumber, double amount) throws AccountNotFoundError, InvalidAmountError{
        Account a = lookupAccount(accountNumber);
        a.deposit(amount);
        totalDeposits+=amount;
    }
    public void withdraw(int accountNumber, double amount) throws AccountNotFoundError, InvalidAmountError, InsufficientBalanceError{
        Account a = lookupAccount(accountNumber);
        a.withdraw(amount);
    }
    public String toString(){
        return(bankName+"\nNumber of Account : "+accounts.size()+"\nTotal Deposits : $"+totalDeposits);
    }
}