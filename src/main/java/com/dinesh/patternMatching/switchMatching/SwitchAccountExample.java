package com.dinesh.patternMatching.switchMatching;

class Account{
    double getBalance(){
        return 0;
    }
}

class SavingsAccount extends Account{
    double getBalance(){
        return 100;
    }
}

class CheckingAccount extends Account{
    double getBalance(){
        return 200;
    }
}

class CurrentAccount extends Account{
    double getBalance(){
        return 300;
    }
}
/**
 * Demonstrates the use of Java 21’s <b>Pattern Matching for switch</b> feature
 * as specified in
 * <a href="https://openjdk.org/jeps/441" target="_blank">
 * JEP 441: Pattern Matching for switch</a>.
 *
 * <p>This example defines a simple account type hierarchy and shows how
 * pattern matching in a {@code switch} statement or expression can replace
 * traditional {@code instanceof} checks and casting, resulting in
 * more concise and type-safe code.</p>
 *
 * <h2>Features Demonstrated:</h2>
 * <ul>
 *   <li>Pattern Matching for {@code switch} (JEP 441, Java 21)</li>
 *   <li>Use of {@code case null} to safely handle {@code null} selectors</li>
 *   <li>Type patterns in {@code switch} case labels</li>
 *   <li>Exhaustive and expression-style {@code switch}</li>
 * </ul>
 *
 * <p><b>Requires:</b> Java 21 or later</p>
 *
 * @author Dinesh
 * @since Java 21
 */
public class SwitchAccountExample {

    /**
     * Calculates the balance using a traditional if/instanceof approach.
     * (For comparison only.)
     */
    static double getBalanceWithoutSwith(Account account){
        double amount = 0;
        if(account instanceof SavingsAccount savingsAccount){
            amount = savingsAccount.getBalance();
        }else if(account instanceof CheckingAccount checkingAccount){
            amount = checkingAccount.getBalance();
        }else if(account instanceof CurrentAccount currentAccount){
            amount = currentAccount.getBalance();
        }else {
            amount = account.getBalance();
        }
        return amount;
    }

    /**
     * Calculates the balance using the Java 21 pattern-matching switch.
     * Cleaner, more declarative, fewer casts.
     */
    static double getBalanceWithSwith(Account account){
        double amount = 0;
        switch (account) {
            case null -> throw new RuntimeException("Account is null");
            case SavingsAccount savingsAccount -> amount = savingsAccount.getBalance();
            case CheckingAccount checkingAccount -> amount = checkingAccount.getBalance();
            case CurrentAccount currentAccount -> amount = currentAccount.getBalance();
            default -> amount = account.getBalance();
        }
        return amount;
    }

    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount();
        CheckingAccount checkingAccount = new CheckingAccount();
        CurrentAccount currentAccount = new CurrentAccount();

        System.out.println("------------------------------------------");
        System.out.println("Balance with old method with if--else");

        System.out.println("Saving account balance :" +getBalanceWithoutSwith(savingsAccount));
        System.out.println("Checking account balance :" + getBalanceWithoutSwith(checkingAccount));
        System.out.println("Current account balance :"+ getBalanceWithoutSwith(currentAccount));

        System.out.println("------------------------------------------");

        System.out.println("Balance with new switch");

        System.out.println("Saving account balance :" +getBalanceWithSwith(savingsAccount));
        System.out.println("Checking account balance :" + getBalanceWithSwith(checkingAccount));
        System.out.println("Current account balance :"+ getBalanceWithSwith(currentAccount));
        System.out.println("Default account balance :"+ getBalanceWithSwith( new Account()));
        //Below code throws Runtime exception
        //System.out.println("Null Object passing: "+ getBalanceWithSwith(null));
        System.out.println("------------------------------------------");

    }
}
