


import java.util.*;
public class LesPersonnes{
    private ArrayList<Personne> personnes;

    public LesPersonnes(){
        this.personnes = new ArrayList<>();
    }

    public void addPersonne(Personne p){
        personnes.add(p);
        System.out.println("Personne ajoutée avec succès.");
    }

    public void printLesPersonnes(){
        if(personnes.isEmpty()){
            System.out.println("Aucune personne dans la liste.");
        } else {
            System.out.println("\n=== LISTE DES PERSONNES ===");
            for(Personne p: personnes){
                System.out.println(p);
            }
        }
    }

    public Personne SearchForPersonne(int matricule){
        for(Personne pers: personnes){
            if(pers.getMatricule()==matricule){
                return pers;
            }
        }
        return null;
    }

    public void Remove(int matricule){
        Personne p = SearchForPersonne(matricule);
        if(p != null){
            personnes.remove(p);
            System.out.println("Suppression réussie.");
        } else {
            System.out.println("Aucune personne trouvée avec le matricule " + matricule);
        }
    }

    public void modifierSalaire(int matricule, double prime, double salaire){
        Personne p = SearchForPersonne(matricule);
        if (p != null) {
            p.setSalaire(salaire, prime);
            System.out.println("Salaire modifié pour la personne matricule " + matricule);
        } else {
            System.out.println("Personne non trouvée.");
        }
    }


}
