package fr.afpa.account;

import java.util.ArrayList;

/**
 * Classe qui représente un client, propriétaire de comptes bancaires
 */
public class Customer {

    // TODO compléter la classe
    // Declarer les attributs

    private int id;
    private String firstName;
    private String lastName;
    private ArrayList<Account> accounts = new ArrayList<Account>();

    // Appeler les objet
    // compléter le constructeur de la classe
    public Customer(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // declaration des getters
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ArrayList<Account> getAccount() {
        return accounts;
    }

    // Declaration des setters
    public void setFirstName(String FirstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String ToString() {
        return "Client {"
                + "identifiant" + getId()
                + "Prenom" + getFirstName()
                + "Nom de famille" + getLastName()
                + "}";

    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public boolean removeAccount(Account account) {
        if (this.accounts.size() >= 1) {
            accounts.remove((account));
            // accounts.removeIf(account -> account.getAccount().equals(account));
        }
        return true;
    }
}
