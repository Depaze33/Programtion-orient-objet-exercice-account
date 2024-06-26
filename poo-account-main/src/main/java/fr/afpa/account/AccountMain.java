package fr.afpa.account;

/**
 * Classe principale du projet, contient la fonction "main"
 */
class AccountMain {
	public static void main(String[] args) {
		System.out.println("\n----- Exercice de programmation objet - classes \"Account\" & \"Customer\" -----");

		// TODO instancier des objets de la classe "Account"
		Account compte1 = new Account("compte1", 800, 0); //ex compte parent
		Account compte2 = new Account("compte2", 0, 0); //ex compte enfant
		// compte1.removeMoney(700);
		compte1.transfer(compte2, 20);
		// vérification de l'IBAN "FR76 4255 9000 0112 3456 78901 21"
boolean isCorrectIban = Account.checkIban("FR7642559000011234567890121");
		// TODO instancier des objets de la classe "Customer"
Customer client1 = new Customer(201457, "Farah", "Sari");
Customer client2 = new Customer(202545, "Azar", "Lucas");
Customer client3 = new Customer(451235, "Hemi", "Alexandre");
Customer client4 = new Customer(789652, "Atmane", "Julie");
Customer client5 = new Customer(456352, "Debi", "Max");


// System.out.println(client1.toString());
// System.out.println(client2.toString());
// System.out.println(client3.toString());
// System.out.println(client4.toString());
// System.out.println(client5.toString());
		// TODO ajouter un ou plusieurs objet de "Account" à des "Customer"
client1.addAccount.removeAccount()
		// TODO afficher les informations des clients avec System.out.println
	}
}
