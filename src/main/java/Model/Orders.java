package Model;

/**
 * @author Gligor Mihai
 */

public class Orders {

    private String idO;
    private String nameClient;
    private String nameProduct;
    private int quantity;

    /**
     *
     * @param nameClient
     * @param nameProduct
     * @param quantity
     */
    public Orders( String nameClient, String nameProduct, int quantity) {
       // this.idO = idO;
        this.nameClient = nameClient;
        this.nameProduct = nameProduct;
        this.quantity = quantity;
    }

    /**
     *
     * @param idO
     * @param nameClient
     * @param nameProduct
     * @param quantity
     */
    public Orders(String idO, String nameClient, String nameProduct, int quantity) {
        this.idO = idO;
        this.nameClient = nameClient;
        this.nameProduct = nameProduct;
        this.quantity = quantity;
    }

    public Orders() {

    }

    public String getIdO() {
        return idO;
    }

    public void setIdO(String idO) {
        this.idO = idO;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "idO='" + idO + '\'' +
                ", nameClient='" + nameClient + '\'' +
                ", nameProduct='" + nameProduct + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
