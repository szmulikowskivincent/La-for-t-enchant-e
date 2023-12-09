import javax.swing.*;
import java.util.Scanner;

public class Program {
    private static final String OUI = "oui";
    private static final String NON = "non";
    private String nombreLoupsTues;
    private double[][] cases;

    public static void main(String[] args) {
        Program game = new Program();
        game.startGame();
    }

    void startGame() {
        Scanner scanner = new Scanner(System.in);

        // Initialiser le nombre de loups tués à zéro
        nombreLoupsTues = String.valueOf(4);

        System.out.println("\uD83D\uDE00 Bienvenue dans le jeu! Appuyez sur Enter pour commencer...");
        scanner.nextLine();  // Attend que l'utilisateur appuie sur Enter
        afficherTeteLoup();  // Afficher la tête de loup
        System.out.println("Bienvenue dans la forêt enchantée! Vous allez devoir affronter une myriade de monstres...\uD83D\uDC3A\uD83D\uDC3A\uD83D\uDC3A\uD83D\uDC3A\uD83D\uDC3A\uD83D\uDC3A\uD83D\uDC3A\uD83D\uDC3A\uD83D\uDC3A\uD83D\uDC3A");
        System.out.println("Rencontrez le super-héros " + "\uD83E\uDD78"); // Utilisation de l'émoji superhéros
        System.out.println("Rencontrez le monstre " + "\uD83D\uDC7E"); // Utilisation de l'émoji démon

        System.out.print("Êtes-vous prêt? (" + OUI + "/" + NON + "): ");
        String reponse = scanner.nextLine().toLowerCase();

        if ( OUI.equals(reponse) ) {
            commenceGame(scanner);
        } else if ( NON.equals(reponse) ) {
            quitterJeu();
        } else {
            System.out.println("Réponse invalide. Merci d'avoir joué! À bientôt...✋");
            quitterJeu();
        }
    }

    private void commenceGame(Scanner scanner) {

        /*int centreForet = cases.length / 2;
        herosChoisi = new Heros("Alice", "humain", centreForet, centreForet);*/
        System.out.print("\n \uD83E\uDDB9\u200D♂\uFE0F Alice se trouve à l'entrée de la foret (50° nord-ouest)");
        System.out.print("\n \uD83E\uDDB9\u200D♂\uFE0F Bob se trouve à l'entrée de la foret ((50° nord-ouest)");
        System.out.print("\n \uD83E\uDDB8 La position de votre héro n'est pas encore connue!");

        System.out.print("\n=============================================================");
        System.out.println("\nExcellent choix! Vous pouvez maintenant choisir votre héros.");
        System.out.print("=============================================================");

        System.out.print("\nVoulez-vous jouer avec \uD83E\uDDB9\u200D♂\uFE0FAlice ou \uD83E\uDDB9\u200D♂\uFE0FBob? ");
        System.out.print("\nVous pouvez créer votre propre super héro! (choix: \uD83E\uDDB8 Mon héro)");
        String choixHeros = scanner.nextLine();

        InterfaceJeu.Heros herosChoisi = choisirHeros(choixHeros);

        // Affichage de la zone de jeu (forêt)
        System.out.println("\nBienvenue dans la forêt enchantée! Voici la zone de jeu :");
        System.out.println("\nLa zone contient au moins 10 loups et mesure 15 km/15km...\uD83C\uDFDE");
        System.out.println("\nLes loups sont à une distance de +- 200 mètres l'un de l'autre! \uD83D\uDC80");

        // Initialiser la matrice de cases
        cases = new double[15][15];  // 15x15, ajustez selon la taille de votre forêt
        for (int i = 0; i < cases.length; i++) {
            for (int j = 0; j < cases[i].length; j++) {
                cases[i][j] = Math.random();  // Exemple : chaque case est initialement une valeur aléatoire
            }
        }

        /*afficherForet();*/
        /*afficherForetAvecEspaces();*/
        afficherForetAvecEspacesEtLoups();

        // Reste du code avec le héros choisi
        // ...

        System.out.println("Vous avez choisi " + herosChoisi.nom + " en tant que héros.");
        System.out.println("Vous disposez d'un crédit de vie de 10 points \uD83E\uDE99\uD83E\uDE99\uD83E\uDE99\uD83E\uDE99\uD83E\uDE99\uD83E\uDE99\uD83E\uDE99\uD83E\uDE99\uD83E\uDE99\uD83E\uDE99..." + herosChoisi.nom + " en tant que héros. Que l'aventure commence!");
        System.out.println("Attention, la forêt enchantée regorge de loups voraces...\uD83D\uDC3A\uD83D\uDC3A\uD83D\uDC3A\uD83D\uDC3A\uD83D\uDC3A!");

        // Demander au joueur de choisir son arme
        choisirArme(scanner);

        // Message demandant au joueur s'il veut avancer dans la forêt ou attendre le combat
        System.out.print("Voulez-vous avancer dans la forêt? (" + OUI + "/" + NON + "): ");
        String choixAvancer = scanner.nextLine().toLowerCase();

        if ( OUI.equals(choixAvancer) ) {
            System.out.println("Vous avancez dans la forêt...");
            // Logique pour avancer dans la forêt
            // Exemple de combat
            System.out.println("-----------------------Combat 1-----------------------");
            afficherResultatCombat("Attaque", "Cible", "Résultat", "PV restants");
            herosChoisi.frapper(new InterfaceJeu.Monstre("Loup affamé", "loup"));
        } else if ( NON.equals(choixAvancer) ) {
            System.out.println("Vous attendez le combat...");

            // Ne pas afficher les résultats du jeu et redemander s'il veut mieux s'armer
            System.out.print("Voulez-vous mieux vous armer? (" + OUI + "/" + NON + "): ");
            String choixMieuxArmer = scanner.nextLine().toLowerCase();

            if ( OUI.equals(choixMieuxArmer) ) {
                choisirArme(scanner);
            } else if ( NON.equals(choixMieuxArmer) ) {
                System.out.println("Vous continuez d'attendre le combat...");
                // Logique pour attendre le combat
            } else {
                System.out.println("Réponse invalide. Le jeu se termine. Merci d'avoir joué! À bientôt...✋");
                quitterJeu();
            }
        }

        // Exemple de repos
        System.out.println("------------------------Repos--------------------------");
        System.out.println("Les héros prennent du repos !");
        herosChoisi.seReposer();

        // Exemple de fin de jeu
        System.out.println("------------------------fin de jeu--------------------------");
        System.out.println("Bravo, vous êtes encore en vie...\uD83D\uDE00\uD83D\uDE00\uD83D\uDE00 courage et prudence!");
        System.out.println("Nombre de loups tués : " + nombreLoupsTues);  // Afficher le nombre de loups tués

        // Vérifier s'il reste au moins 6 loups dans la forêt
        System.out.println("Attention, il reste au moins 6 loups dans la forêt!");

        // Demander si le joueur veut continuer
        demanderContinuerJeu(scanner);
    }

    private InterfaceJeu.Heros choisirHeros(String choixHeros) {
        InterfaceJeu.Heros herosChoisi;

        if ( "Alice".equalsIgnoreCase(choixHeros) ) {
            herosChoisi = new InterfaceJeu.Heros("Alice", "humain");
        } else if ( "Bob".equalsIgnoreCase(choixHeros) ) {
            herosChoisi = new InterfaceJeu.Heros("Bob", "humain");
        } else if ( "Mon héro".equalsIgnoreCase(choixHeros) ) {
            herosChoisi = new InterfaceJeu.Heros("Mon héro", "humain");
        } else {
            System.out.println("Choix invalide. Vous jouerez avec Alice par défaut.");
            herosChoisi = new InterfaceJeu.Heros("Alice", "humain");
        }

        return herosChoisi;
    }

    private void choisirArme(Scanner scanner) {
        System.out.println("Choisissez votre arme: ");
        System.out.println("1. ⚔\uFE0F");
        System.out.println("2. ⛏\uFE0F ");
        System.out.println("3. \uD83C\uDFF9");

        int choixArme = scanner.nextInt();
        scanner.nextLine(); // Pour consommer le retour à la ligne

        switch (choixArme) {
            case 1:
                System.out.println("Vous avez choisi l'Arc.");
                break;
            case 2:
                System.out.println("Vous avez choisi le Lance-pierre.");
                break;
            case 3:
                System.out.println("Vous avez choisi l'Arbalète.");
                break;
            default:
                System.out.println("Choix d'arme invalide. Le jeu se termine. Merci d'avoir joué! À bientôt...✋");
                quitterJeu();
        }

        // Continuez ici avec le reste du jeu...
    }

    private void demanderContinuerJeu(Scanner scanner) {
        System.out.print("Voulez-vous continuer à jouer? (" + OUI + "/" + NON + "): ");
        String choixContinuer = scanner.nextLine().toLowerCase();

        if ( OUI.equals(choixContinuer) ) {
            commenceGame(scanner);
        } else if ( NON.equals(choixContinuer) ) {
            quitterJeu();
        } else {
            System.out.println("Réponse invalide. Le jeu se termine. Merci d'avoir joué! À bientôt...✋");
            quitterJeu();
        }
    }

    private static void quitterJeu() {
        System.out.println("Merci d'avoir joué! À bientôt...✋");
        System.exit(0);  // Terminer le programme
    }

    private void afficherResultatCombat(String col1, String col2, String col3, String col4) {
        System.out.printf("| %-10s | %-15s | %-10s | %-12s |\n", col1, col2, col3, col4);
        // Mettre à jour le nombre de loups tués
        if ( "Loup affamé".equals(col2) ) ;
    }

    private void afficherTeteLoup() {
        System.out.println("                 / \\           / \\");
        System.out.println("                /   `.       .'   \\");
        System.out.println("               /      `-----'      \\");
        System.out.println("              /  \\               /  \\");
        System.out.println("             /.  |               |   \\");
        System.out.println("            /  ` |               |'   \\");
        System.out.println("           |     |               |     |");
        System.out.println("           |  O  |               |  O  |");
        System.out.println("           \\      \\     ^     /      /");
        System.out.println("            `.      \\   ---   /    .'    /");
        System.out.println("              `-.     \\___/   .-`   .-`");
        System.out.println("                 `-._       _.-'   .-`");
        System.out.println("                     `-----'   .-`");
        System.out.println("                              -`");
        System.out.println("                                  ");
        System.out.println("                                  ");
    }

    public void afficherCarte() {
        for (int i = 0; i < cases.length; i++) {
            for (int j = 0; j < cases[i].length; j++) {
                for (int k = 0; k < cases[i][j]; k++) {
                    System.out.print(getSymboleCase(cases[i][j]) + " ");
                }
            }
            System.out.println();
        }
    }

    private int getSymboleCase(double v) {
        int symbole;

        if ( v > 0 ) {
            symbole = 1;
        } else if ( v < 0 ) {
            symbole = -1;
        } else {
            symbole = 0;
        }

        return symbole;
    }

    private static void afficherForetAvecEspacesEtLoups() {
        int tailleForet = 15; // Ajuster la taille de la forêt selon les besoins
        int densiteLoups = 3; // Ajuster la densité de loups selon les besoins
        int densiteSapins = 2; // Ajuster la densité de sapins selon les besoins

        // Ensemble d'émoticônes de loup
        String[] emoticonesLoups = {"\uD83C\uDF32", "\uD83D\uDC3A", "\uD83D\uDC3B", "\uD83D\uDC3C"};

        // Émoticône de sapin
        String emoticoneSapin = "\uD83C\uDF32"; // Remplacer par l'émoticône de sapin de votre choix

        for (int i = 0; i < tailleForet; i++) {
            for (int j = 0; j < tailleForet; j++) {

                // Imprimer un loup avec une certaine probabilité (densité)
                if ( Math.random() < (double) densiteLoups / tailleForet ) {
                    int indexLoup = (int) ( Math.random() * emoticonesLoups.length );
                    System.out.print(emoticonesLoups[indexLoup]);
                }
                // Imprimer un sapin avec une certaine probabilité (densité)
                else if ( Math.random() < (double) densiteSapins / tailleForet ) {
                    System.out.print(emoticoneSapin);
                } else {
                    System.out.print(" "); // Espace
                }

                // Ajouter un espace après chaque symbole, sauf pour le dernier
                if ( j < tailleForet - 1 ) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}


































