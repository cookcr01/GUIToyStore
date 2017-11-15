package guitoystorecameroncook;
/**
 * is the lineitem class
 *
 * @author camer_000
 */
public class LineItem {

    private Product p1;
    private int quantity;

    /**
     * constructor for lineitem
     *
     * @param p1 is the product
     * @param quantity is the quantity of the product
     */
    public LineItem(Product p1, int quantity) {
        this.p1 = p1;
        this.quantity = quantity;
    }

    /**
     * is the to string method
     *
     * @return the product to string plus the quantity
     */
    public String toString() {
        return p1.toString() + "   quantity:   " + quantity;
    }

    /**
     * is the product id
     *
     * @return the product id
     */
    public double getId() {
        return p1.getId();
    }

    /**
     * gets rid of the quantity
     *
     * @param i is the quantity removed
     */
    public void deleteQuantity(int i) {
        quantity = quantity - i;
    }

    /**
     * changes the quantity
     *
     * @param newQuantity is the new quantity you want the item to be
     */
    public void changeQuanity(int newQuantity) {
        this.quantity = newQuantity;
    }

    /**
     * returns the quantity
     *
     * @return the quantity
     */
    public int getQuanity() {
        return quantity;
    }

    /**
     * gets the price
     *
     * @return returns the price
     */
    public double getPrice() {
        return p1.getPrice();
    }

    /**
     * checks if to products are equal
     *
     * @param p2 is the product we are checking
     * @return true or false
     */
    public boolean equals(Product p2) {
        return p1.equals(p2);
    }

    /**
     * adds quantity
     *
     * @param i is the quantity needed to be added
     */
    public void addQuantity(int i) {
        quantity = quantity + i;
    }

    /**
     * gets the product
     *
     * @return the product
     */
    public Product getProduct() {
        return p1;
    }

}
