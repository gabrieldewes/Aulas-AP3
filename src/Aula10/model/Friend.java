package Aula10.model;

import java.util.Scanner;

/**
 * Created by gabriel on 30/04/16.
 */
public class Friend {
    private long id_friend;
    private String name;
    private String address;
    private long phone;

    public Friend(long id, String name, String address, long phone) {
        this.setId(id);
        this.setName(name);
        this.setAddress(address);
        this.setPhone(phone);
    }

    public static Friend readNewFriend() {
        Scanner in = new Scanner(System.in);
        System.out.println("Nome: ");
        String name = in.nextLine();
        System.out.println("Endereço: ");
        String address = in.nextLine();
        System.out.println("Número de telefone: ");
        long phone = in.nextLong();
        return new Friend(0, name, address, phone);
    }

    public long getId() {
        return id_friend;
    }
    public void setId(long id_friend) {
        this.id_friend = id_friend;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public long getPhone() {
        return phone;
    }
    public void setPhone(long phone) {
        this.phone = phone;
    }
}
