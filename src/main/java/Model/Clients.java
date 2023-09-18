package Model;

/**
 * @author Gligor Mihai
 */

public class Clients {


    private String idC;
    private String name;
    private String adress;

    public Clients( String name, String adress) {

        this.name = name;
        this.adress = adress;
    }


    public Clients( String name) {
        this.name = name;
    }

    /**
     *
     * @param idC
     * @param name
     * @param adress
     */
    public Clients( String idC,String name, String adress) {
        this.idC=idC;
        this.name = name;
        this.adress=adress;
    }

    public Clients() {

    }


    public String getIdC() {
        return idC;
    }


    public void setIdC(String idC) {
        this.idC = idC;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }


}
