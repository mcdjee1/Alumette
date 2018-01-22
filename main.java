import java.util.Scanner;

/**
 * Created by DouJe1335787 on 2018-01-15.
 */
public class main {
    public static void main(String[] args) {
        //initialisation des variables
        int choixJoueur = 0;
        String nomJ1;
        String nomJ2;
        int nbAluDebut = 0;
        int nbAluRestant = 0;
        int[] tabJ1 = new int[50];
        int[] tabJ2 = new int[50];
        int i = 0;
        int tour = 0;
        boolean rejouer = true;
        boolean iA = false;
        int n = 0;
        int j = 0;
        int k = 0;

        //initialisation scanner
        Scanner sc = new Scanner(System.in);

        while (rejouer == true)
        {
            //remise a zero tableaux
            k = 0;
            while (k < tabJ1.length)
            {
                tabJ1[k] = 0;
                k++;
            }
            k = 0;
            while (k < tabJ2.length)
            {
                tabJ2[k] = 0;
                k++;
            }

            //choix inteligeance artificielle
            System.out.print("Voulez vous jouer contre une inteligeance artificielle? (true/false)");
            iA = sc.nextBoolean();

            //entree noms
            System.out.print("Entrez nom J1 : ");
            nomJ1 = sc.next();
            if (iA == false)
            {
                System.out.println("Entrer nom J2 : ");
                nomJ2 = sc.next();
            }
            else nomJ2 = "IA";

            //generation nombre allumettes
            nbAluDebut = (int)(Math.random()*80 + 20);
            System.out.print("Nombre alumettes : " + nbAluDebut);
            nbAluRestant = nbAluDebut;
            i = 0;
            //debut du jeu
            do
            {
                tour = 1;
                System.out.print("\n" + "Il reste " + nbAluRestant + " alumettes." + "\n" + "C'est le tour de " + nomJ1 + ". Combien d'alumettes allez vous piger? 1, 2 ou 3");
                choixJoueur = sc.nextInt();
                if (choixJoueur > 3) choixJoueur = 3;
                if (choixJoueur < 1) choixJoueur = 1;
                nbAluRestant = nbAluRestant - choixJoueur;
                tabJ1[i] = choixJoueur;
                if (nbAluRestant > 0)
                {
                    tour = 2;
                    if (iA == false)
                    {
                        System.out.print("\n" + "Il reste " + nbAluRestant + " alumettes." + "\n" + "C'est le tour de " + nomJ2 + ". Combien d'alumettes allez vous piger? 1, 2 ou 3");
                        choixJoueur = sc.nextInt();
                        if (choixJoueur > 3) choixJoueur = 3;
                        if (choixJoueur < 1) choixJoueur = 1;
                        nbAluRestant = nbAluRestant - choixJoueur;
                        tabJ2[i] = choixJoueur;
                    }
                    else
                    {   //nbs critiques de la mort     5,9,13,17,21,25,29,33,37,41,45,49,53,57,61,65,69,73,77,81,85,89,93,97
                        n = 0;
                        while (n <= 100)
                        {
                            if (n == nbAluRestant) choixJoueur = 3;
                            n = n + 4;
                        }
                        n = 1;
                        while (n <= 100)
                        {
                            if (n == nbAluRestant) choixJoueur = 2;
                            n = n + 4;
                        }
                        n = 2;
                        while (n <= 100)
                        {
                            if (n == nbAluRestant) choixJoueur = 1;
                            n = n + 4;
                        }
                        n = 3;
                        while (n <= 100)
                        {
                            if (n == nbAluRestant) choixJoueur = 2;
                            n = n + 4;
                        }
                        nbAluRestant = nbAluRestant - choixJoueur;
                        tabJ2[i] = choixJoueur;
                        System.out.print("IA a pris " + choixJoueur + " Alumettes ");
                    }
                }
                i++;
            }while (nbAluRestant > 0);
            if (tour == 1) System.out.print(nomJ2 + " à gagné");
            if (tour == 2) System.out.print(nomJ1 + " à gagné");
            System.out.print("\n" + "Décisions " + nomJ1 + " : ");
            k = 0;
            while (k < tabJ1.length)
            {
                if (tabJ1[k] != 0)
                {
                    System.out.print(tabJ1[k]);
                }
                if (tabJ1[k] != 0 && tabJ1[k + 1] != 0) System.out.print(",");
                k++;
            }
            System.out.print("\n" + "Décisions " + nomJ2 + " : ");
            k = 0;
            while (k < tabJ2.length)
            {
                if (tabJ2[k] != 0)
                {
                    System.out.print(tabJ2[k]);
                }
                if (tabJ2[k] != 0 && tabJ2[k + 1] != 0) System.out.print(",");
                k++;
            }
            System.out.print("\n" + "voulez-vous rejouer? (true/false)");
            rejouer = sc.nextBoolean();
        }
        System.out.print("\n" + "Passez une bonne journée!");

        //fermeture scanner
        sc.close();
    }
}