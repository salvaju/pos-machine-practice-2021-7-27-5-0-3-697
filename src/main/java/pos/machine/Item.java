package pos.machine;

public class Item {

    public String name;
    public int quantity;
    public int price;
    public int subTotal = 0;


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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(int subTotal) {
        this.subTotal = subTotal;
    }

    public void addQuantity() {
        this.quantity += 1;
    }

    public void addSubTotal() {
        this.subTotal += this.subTotal;
    }
}
