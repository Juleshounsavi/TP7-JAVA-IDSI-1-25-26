

import java.util.*;

public class Personne {

    private int matricule;
    private String nom;
    private String prenom;
    private String tel;
    private int age;
    private double salaire;
    private static int np = 0;

    public int getMatricule(){return matricule;}
    public String getNom(){return nom;}
    public String getPrenom(){return prenom;}
    public String getTel(){return tel;}
    public int getAge(){return age;}
    public double getSalaire(){return salaire;}

    public void setMatricule(int matricule){this.matricule = matricule;}
    public void setNom(String nom){this.nom = nom;}
    public void setPrenom(String prenom){this.prenom = prenom;}
    public void setTel(String tel){this.tel = tel;}
    public void setAge(int age){this.age = age;}
    public void setSalaire(double prime, double salaire) {this.salaire = salaire + prime;}

    public Personne(String nom, String prenom, String tel, int age){
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.age = age;
        this.np += 1;
    }


    @Override
    public String toString(){
        return "Nom: " + nom +
                "\nPrenom: " + prenom +
                "\nTelephone: " + tel +
                "\nAge: " + age;
    }

}
