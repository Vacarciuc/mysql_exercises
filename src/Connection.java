import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Connection {
    boolean repeta=false;
    public void connection() {
        try (java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "")) {
            Statement st = connection.createStatement();
            do {
                System.out.println("va rugam sa alegeti una din optiuni:\n"+
                "1.Afisare toti angajatii \n"+
                 "2.Adaugare persoana noua \n"+
                        "3.Modificare date dupa ID angajat \n"+
                        "4.Stergere persoana dupa ID \n"+
                        "5.Gaseste persoana dupa criteriu");
                Scanner scannerGeneral = new Scanner(System.in);
                switch (scannerGeneral.nextInt()) {
                    case 1://afisarea persoane
                        List<Person> person_collection = new ArrayList();
                        st.executeQuery("select * from persons");
                        ResultSet rs = st.getResultSet();
                        while (rs.next()) {
                            Person person = new Person(rs.getInt("id"), rs.getString("prenumele"), rs.getInt("varsta"), rs.getString("adresa"), rs.getDouble("salariu"));
                            person_collection.add(person);
                        }
                        for (Person p : person_collection) {
                            System.out.println(p);
                        }
                        System.out.println("operatiune executat cu succes");
                        break;
                    case 2://insert persoana noua
                        Scanner scanner = new Scanner(System.in);
                        Scanner scanner1 = new Scanner(System.in);
                        System.out.print("Prenume: "); String prenume1=scanner.nextLine();
                        System.out.print("Varsta: "); int varsta1=scanner.nextInt();
                        System.out.print("Adresa: "); String adresa1=scanner1.nextLine();
                        System.out.print("Salariu: "); double salariu1=scanner.nextDouble();
                        Person person = new Person(prenume1, varsta1, adresa1, salariu1);
                        st.execute("insert into persons values(null, '" + person.getPrenume() + "'," + person.getVarsta() + ",'" + person.getAdresa() + "'," + person.getSalariu() + ")");
                        System.out.println("operatiune executat cu succes");
                        break;
                    case 3://modofocare date dupa ID
                        Scanner scanner2 = new Scanner(System.in);
                        Scanner scanner3 = new Scanner(System.in);
                        System.out.println("introduceti date noi despre persoana");
                        System.out.print("Prenume: ");String prenume = scanner2.nextLine();
                        System.out.print("Varsta: ");int varsta = scanner2.nextInt();
                        System.out.print("Adresa: ");String adresa = scanner3.nextLine();
                        System.out.print("Salariu: ");double salariu = scanner2.nextDouble();
                        System.out.println("introduceti ID");
                        int id = scanner3.nextInt();
                        st.execute("update persons set prenumele='" + prenume + "', varsta= '" + varsta + "', adresa='" + adresa + "', salariu='" + salariu + "' where id=" + id + "");
                        System.out.println("operatiune executat cu succes");
                        break;
                    case 4://stergere persoana dupa ID
                        Scanner scanner4 = new Scanner(System.in);
                        System.out.println("introduceti ID pentru persana care doriti sa o stergeti");
                        st.execute("delete from persons where id=" + scanner4.nextInt() + "");
                        System.out.println("operatiune executat cu succes");
                        break;
                    case 5://gaseste persoana dupa cristeriu
                        System.out.println("introduceti unul din criteriile:prenume/varsta/adresa/salariu");
                        Scanner scanner5 = new Scanner(System.in);
                        // Scanner scanner6=new Scanner(System.in);
                        List<Person> person_collection2 = new ArrayList();
                        switch (scanner5.nextLine()) {
                            case "prenume":
                                System.out.print("introduceti prenume: ");
                                st.executeQuery("select * from persons where prenumele='" + scanner5.nextLine() + "'");
                                ResultSet rs1 = st.getResultSet();
                                while (rs1.next()) {
                                    Person person1 = new Person(rs1.getInt("id"), rs1.getString("prenumele"), rs1.getInt("varsta"), rs1.getString("adresa"), rs1.getDouble("salariu"));
                                    person_collection2.add(person1);
                                }
                                for (Person p1 : person_collection2) {
                                    System.out.println(p1);
                                }
                                break;
                            case "varsta":
                                System.out.print("introduceti varsta: ");
                                st.executeQuery("select * from persons where varsta='" + scanner5.nextInt() + "'");
                                ResultSet rs2 = st.getResultSet();
                                while (rs2.next()) {
                                    Person person2 = new Person(rs2.getInt("id"), rs2.getString("prenumele"), rs2.getInt("varsta"), rs2.getString("adresa"), rs2.getDouble("salariu"));
                                    person_collection2.add(person2);
                                }
                                for (Person p2 : person_collection2) {
                                    System.out.println(p2);
                                }
                                break;
                            case "adresa":
                                System.out.print("introduceti adresa: ");
                                st.executeQuery("select * from persons where adresa='" + scanner5.nextLine() + "'");
                                ResultSet rs3 = st.getResultSet();
                                while (rs3.next()) {
                                    Person person3 = new Person(rs3.getInt("id"), rs3.getString("prenumele"), rs3.getInt("varsta"), rs3.getString("adresa"), rs3.getDouble("salariu"));
                                    person_collection2.add(person3);
                                }
                                for (Person p3 : person_collection2) {
                                    System.out.println(p3);
                                }
                                break;
                            case "salariu":
                                System.out.print("introduceti salariu: ");
                                st.executeQuery("select * from persons where salariu='" + scanner5.nextDouble() + "'");
                                ResultSet rs4 = st.getResultSet();
                                while (rs4.next()) {
                                    Person person4 = new Person(rs4.getInt("id"), rs4.getString("prenumele"), rs4.getInt("varsta"), rs4.getString("adresa"), rs4.getDouble("salariu"));
                                    person_collection2.add(person4);
                                }
                                for (Person p4 : person_collection2) {
                                    System.out.println(p4);
                                }
                                break;
                            default:
                                System.out.println("criteriu neidentificat");
                        }
                        System.out.println("operatiune executat cu succes");
                        break;
                }
                System.out.println("doresti sa executi o alta operatiune y/n");
                Scanner scanner=new Scanner(System.in);
                if (scanner.nextLine().equals("y")) {
                    repeta = true;
                }
            }while (repeta);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
