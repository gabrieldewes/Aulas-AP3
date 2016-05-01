package Aula10.model;

import java.io.BufferedReader;
import java.io.Serializable;
import java.util.Scanner;

/**
 * Created by gabriel on 30/04/16.
 */
public class Friend {
    private String name;
    private String address;
    private long phone;


    private Friend(String name, String address, long phone) {
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
        return new Friend(name, address, phone);
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
