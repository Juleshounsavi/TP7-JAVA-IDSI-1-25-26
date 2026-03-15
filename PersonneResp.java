

public class PersonneResp extends Personne{

    private double primeresp;

    public PersonneResp(String nom, String prenom, String tel, int age, double primeresp){
        super(nom,prenom,tel, age);
        this.primeresp = primeresp;
    }

    public double getPrimeresp(){return primeresp;}
    public void setPrimeresp(double primeresp){this.primeresp = primeresp;}

    @Override
    public void setSalaire(double prime, double salaire) {
        super.setSalaire(prime + this.primeresp, salaire);
    }


    @Override
    public String toString(){
        return super.toString() + "\nPrime Responsable: " + primeresp;
    }


}
