package Model;

/**
 * @author Gligor Mihai
 */
public class Products {

    private String idP;
    private String name;
    private int quantity;
    private int price;

    /**
     *
     * @param name
     * @param quantity
     * @param price
     */
    public Products(String name, int quantity, int price) {
       // this.idP = idP;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    public Products(String idP) {
         this.idP = idP;
        }

    /**
     *
     * @param idP
     * @param name
     * @param quantity
     * @param price
     */
    public Products(String idP,String name, int quantity, int price) {
        this.idP = idP;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public Products() {

    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getIdP() {
        return idP;
    }

    public void setIdP(String idP) {
        this.idP = idP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
