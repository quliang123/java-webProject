package controllerautomatic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 123 on 2017/08/17.
 */

public class UserInfo {
    private String name;

    private Address address;

    private List<Book> list = new ArrayList<Book>();

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
