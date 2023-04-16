package starter.object;

import java.util.List;

public class CartObject {
    Integer id;
    Integer userId;
    String date;
    List<CartProductObjects> products;

    Integer __v;

    public Integer get__v() {
        return __v;
    }

    public void set__v(Integer __v) {
        this.__v = __v;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<CartProductObjects> getProducts() {
        return products;
    }

    public void setProducts(List<CartProductObjects> products) {
        this.products = products;
    }
}
