package org.academiadecodigo.asciimos.factories;


import org.academiadecodigo.asciimos.model.account.Account;
import org.academiadecodigo.asciimos.model.account.AccountType;
import org.academiadecodigo.asciimos.model.account.CheckingAccount;
import org.academiadecodigo.asciimos.model.account.SavingsAccount;

/**
 * A factory for creating accounts of different types
 */
public class AccountFactory {

    /**
     * Creates a new {@link Account}
     *
     * @param accountType the account type
     * @return the new account
     */
    public Account createAccount(AccountType accountType) {

        Account newAccount;
        switch (accountType) {
            case CHECKING:
                newAccount = new CheckingAccount();
                break;
            case SAVINGS:
                newAccount = new SavingsAccount();
                break;
            default:
                newAccount = null;

        }

        return newAccount;
    }
}
