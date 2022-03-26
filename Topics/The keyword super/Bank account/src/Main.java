
class BankAccount {

    protected String number;
    protected Long balance;

    public BankAccount(String number, Long balance) {
        this.number = number;
        this.balance = balance;
    }
}

class CheckingAccount extends BankAccount {

    protected Double fee;

    public CheckingAccount(String number, Long balance, Double fee) {
        super(number, balance);
        this.fee = fee;
    }
}


class SavingsAccount extends BankAccount {

    protected Double interestRate;

    public SavingsAccount (String number, Long balance, Double interestRate) {
        super(number, balance);
        this.interestRate = interestRate;
    }
}