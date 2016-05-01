package Aula10.model;

import java.util.Locale;
import java.util.Scanner;

/**
 * Created by gabriel on 30/04/16.
 */
public class Item {
    private ItemType type;
    private String name;
    private double price;
    private String buy_date;
    private String cons_state;

    private Item() {

    }

    private Item(ItemType type, String name, double price, String buy_date, String cons_state) {
        this.setName(name);
        this.setType(type);
        this.setBuy_date(buy_date);
        this.setCons_state(cons_state);
        this.setPrice(price);
    }

    public static Item readNewItem () {
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);

        System.out.println("Escolha o tipo do item: ");
        for (ItemType it:ItemType.values()) {
            System.out.print(it.name() +" ("+ it.getValor() +")" + " - ");
        }
        int opt = in.nextInt();
        ItemType type = null;
        for (ItemType it: ItemType.values()) {
            if (it.getValor() == opt) {
                type = it;
            }
        }
        in.nextLine();

        System.out.println("Nome: ");
        String name = in.nextLine();

        System.out.println("Preço pago: ");
        double price = in.nextDouble();

        System.out.println("Estado de conservação: ");
        String cons_state = in.next();

        in.nextLine();
        System.out.println("Data da compra: ");
        String buy_date = in.nextLine();

        return new Item(type, name, price, cons_state, buy_date);
    }

    public ItemType getType() {
        return type;
    }
    public void setType(ItemType type) {
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getBuy_date() {
        return buy_date;
    }
    public void setBuy_date(String buy_date) {
        this.buy_date = buy_date;
    }
    public String getCons_state() {
        return cons_state;
    }
    public void setCons_state(String cons_state) {
        this.cons_state = cons_state;
    }
}
