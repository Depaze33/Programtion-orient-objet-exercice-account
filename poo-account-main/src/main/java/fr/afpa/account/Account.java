package fr.afpa.account;

import java.math.BigInteger;

/**
 * Classe représentant un compte bancaire
 */
public class Account {
    // Definir les attributs
    private String iban;
    private int balance;
    private int overdraftAuthorization;

    // Appeler les objet
    // compléter le constructeur de la classe
    public Account(String iban, int balance, int overdraftAuthorization) {
        this.iban = iban;
        this.balance = balance;
        this.overdraftAuthorization = overdraftAuthorization;
    }
    // implémenter les setters et getters de la classe (permet d'accéder aux
    // attributs privés)
    // decalare les getters

    public String getIban() {
        return iban;
    }

    public int getBalance() {
        return balance;
    }

    public int getOverdraftAuthorization() {
        return overdraftAuthorization;
    }

    // declare les setters
    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setOverdraftAuthorization(int overdraftAuthorization) {
        this.overdraftAuthorization = overdraftAuthorization;
    }
    // declarer le toString

    public String toString() {
        return "Compte { "
                + "\n iban " + getIban()
                + "\n balance " + getBalance()
                + "\n autorisation de découvert" + getOverdraftAuthorization()
                + '}';
    }

    /**
     * 
     * @param amount montant que l'on veux rentrer
     * @return ce qu'il y a après les operations sur le compte/ operation a
     *         effectuer
     */
    // Methode pour ajouter de l'argent
    public int addMoney(int amount) {
        this.balance = this.balance + amount;
        return this.balance;
    }

    /**
     * 
     * @param amount montant que l'on veux rentrer
     * @return ce qu'il reste après les operations sur le compte/ operation a
     *         effectuer
     */

    // methode pour retirer de l'argent
    public int removeMoney(int amount) {

        if (amount > balance - overdraftAuthorization) {
            int solde = 0;
            solde = balance - amount - overdraftAuthorization;
            System.out
                    .println("L'operation n'est pas possible, vous n'avez pas assez de sous sur votre compte" + solde);

        } else {
            this.balance = this.balance - amount;

        }

        return this.balance;
    }

    /**
     * 
     * @param otherAccount le deuxieme compte sur le quel transferer de l'argent
     * @param amount       le montant que l'on veux rentrer/ operation a effectuer
     */
    // methode pour verifier qu'il y a assez de sous sur le compte
    public void transfer(Account otherAccount, int amount) {

        if (amount > this.balance - this.overdraftAuthorization) {
            int solde = 0;
            solde = balance - amount - this.overdraftAuthorization;
            System.out.println(
                    "L'operation n'est pas possible, vous n'avez pas assez de sous sur votre compte cela va au dela de vos droit de : "
                            + solde + " euros");

        } else {
            otherAccount.addMoney(amount);
            this.balance = this.balance - amount;

        }

    }

    /**
     * 
     * @param ibanCheck iban a verifier
     * @return le reste de la division par 97 (modulo (%) 97)
     */
    public static boolean checkIban(String ibanCheck) {
        // verification de la taille de la chaine
        if (ibanCheck.length() > 35) {
            System.out.println("Votre IBAN n'est pas conforme");
            return false;
        }
        // enlever les espaces
        ibanCheck = ibanCheck.replace("\\s", "");
        // tout mettre en majuscule
        ibanCheck = ibanCheck.toUpperCase();
        // mettre les premier caractères a la fin
        ibanCheck = ibanCheck.substring(4) + ibanCheck.substring(0, 4);
        // convertir lettres en chiffre
        String total = "";
        for (int i = 0; i < ibanCheck.length(); i++) {
            int charValue = Character.getNumericValue(ibanCheck.charAt(i));

            total += charValue;
        }

        // verifier que le modulo 97 = 1
        BigInteger totalInt = new BigInteger(total);

        BigInteger moduloResult = totalInt.mod(new BigInteger("97"));
        if (moduloResult.intValue() == 1) {
            System.out.println("Votre IBAN est correct");
            return true; // c'est un IBAN correct
        } else {
            System.out.println("Votre IBAN n'est pas bon");
            return false; // c'est un IBAN incorrect
        }
    }
}
