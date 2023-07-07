public class Person {
    private  int id;
    private String prenume;
    private int varsta;
    private String adresa;
    private double salariu;


    public Person(int id, String prenume, int varsta, String adresa, double salariu) {
        this.id = id;
        this.prenume = prenume;
        this.varsta = varsta;
        this.adresa = adresa;
        this.salariu = salariu;
    }

    public Person(String prenume, int varsta, String adresa, double salariu) {
        this.prenume = prenume;
        this.varsta = varsta;
        this.adresa = adresa;
        this.salariu = salariu;
    }

    public int getId() {
        return id;
    }

    public String getPrenume() {
        return prenume;
    }

    public int getVarsta() {
        return varsta;
    }

    public String getAdresa() {
        return adresa;
    }

    public double getSalariu() {
        return salariu;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", prenume='" + prenume + '\'' +
                ", varsta=" + varsta +
                ", adresa='" + adresa + '\'' +
                ", salariu=" + salariu +
                '}';
    }
}
