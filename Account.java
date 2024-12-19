public class Account {
    public int accountNumber;
    public double balance;

    public Account (int accountNumber, double startingBalance) throws InvalidStartingBalanceError{
        this.accountNumber = accountNumber;
        if(startingBalance<=0){
            throw new InvalidStartingBalanceError();
        }
        balance = startingBalance;
    }
    public void deposit(double amount) throws InvalidAmountError{
        if(amount<=0){
        throw new InvalidAmountError();
        }
        balance += amount;
    }
    public void withdraw(double amount) throws InvalidAmountError, InsufficientBalanceError{
        if(amount<=0){
            throw new InvalidAmountError();
        }
        if(balance>=amount){
            balance -= amount;
        }else{
            throw new InsufficientBalanceError();
        }
    }
    public String toString(){
        return("Account : "+ accountNumber+"\nAvailableBalance : $"+balance);
    }
}