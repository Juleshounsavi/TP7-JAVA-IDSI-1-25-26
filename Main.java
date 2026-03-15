

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LesPersonnes gestionPersonnes = new LesPersonnes();
        int choix;

        do {
            afficherMenu();
            System.out.print("Votre choix: ");
            choix = lireEntier(scanner);

            switch(choix) {
                case 1:
                    ajouterPersonne(scanner, gestionPersonnes);
                    break;
                case 2:
                    ajouterPersonneResp(scanner, gestionPersonnes);
                    break;
                case 3:
                    gestionPersonnes.printLesPersonnes();
                    break;
                case 4:
                    rechercherPersonne(scanner, gestionPersonnes);
                    break;
                case 5:
                    supprimerPersonne(scanner, gestionPersonnes);
                    break;
                case 6:
                    modifierSalairePersonne(scanner, gestionPersonnes);
                    break;
                case 7:
                    System.out.println("Au revoir!");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while(choix != 7);

        scanner.close();
    }

    private static void afficherMenu() {
        System.out.println("\n=== MENU GESTION DES PERSONNES ===");
        System.out.println("1. Ajouter une personne");
        System.out.println("2. Ajouter un responsable");
        System.out.println("3. Afficher toutes les personnes");
        System.out.println("4. Rechercher une personne par matricule");
        System.out.println("5. Supprimer une personne");
        System.out.println("6. Modifier le salaire d'une personne");
        System.out.println("7. Quitter");
    }

    private static void ajouterPersonne(Scanner scanner, LesPersonnes gestionPersonnes) {
        System.out.println("\n--- Ajout d'une personne ---");
        System.out.print("Nom: ");
        String nom = scanner.nextLine();
        System.out.print("Prénom: ");
        String prenom = scanner.nextLine();
        System.out.print("Téléphone: ");
        String tel = scanner.nextLine();
        System.out.print("Âge: ");
        int age = lireEntier(scanner);

        Personne p = new Personne(nom, prenom, tel, age);
        gestionPersonnes.addPersonne(p);
    }

    private static void ajouterPersonneResp(Scanner scanner, LesPersonnes gestionPersonnes) {
        System.out.println("\n--- Ajout d'un responsable ---");
        System.out.print("Nom: ");
        String nom = scanner.nextLine();
        System.out.print("Prénom: ");
        String prenom = scanner.nextLine();
        System.out.print("Téléphone: ");
        String tel = scanner.nextLine();
        System.out.print("Âge: ");
        int age = lireEntier(scanner);
        System.out.print("Prime responsable: ");
        double primeResp = lireDouble(scanner);

        PersonneResp pr = new PersonneResp(nom, prenom, tel, age, primeResp);
        gestionPersonnes.addPersonne(pr);
    }

    private static void rechercherPersonne(Scanner scanner, LesPersonnes gestionPersonnes) {
        System.out.print("\nEntrez le matricule à rechercher: ");
        int matricule = lireEntier(scanner);

        Personne p = gestionPersonnes.SearchForPersonne(matricule);
        if (p != null) {
            System.out.println("Personne trouvée:");
            System.out.println(p);
        } else {
            System.out.println("Aucune personne trouvée avec le matricule " + matricule);
        }
    }

    private static void supprimerPersonne(Scanner scanner, LesPersonnes gestionPersonnes) {
        System.out.print("\nEntrez le matricule à supprimer: ");
        int matricule = lireEntier(scanner);
        gestionPersonnes.Remove(matricule);
    }

    private static void modifierSalairePersonne(Scanner scanner, LesPersonnes gestionPersonnes) {
        System.out.print("\nEntrez le matricule de la personne: ");
        int matricule = lireEntier(scanner);
        System.out.print("Entrez la prime: ");
        double prime = lireDouble(scanner);
        System.out.print("Entrez le salaire de base: ");
        double salaire = lireDouble(scanner);

        gestionPersonnes.modifierSalaire(matricule, prime, salaire);
    }

    private static int lireEntier(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Veuillez entrer un nombre valide: ");
            scanner.next();
        }
        int valeur = scanner.nextInt();
        scanner.nextLine(); // Consommer la ligne restante
        return valeur;
    }

    private static double lireDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("Veuillez entrer un nombre valide: ");
            scanner.next();
        }
        double valeur = scanner.nextDouble();
        scanner.nextLine(); // Consommer la ligne restante
        return valeur;
    }
}