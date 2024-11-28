import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class ConcertTicketSystem {
    public static final Scanner scanner = new Scanner(System.in);
    public static final Map<Integer, Integer> cart = new HashMap<>();
    public static final Map<Integer, String> tickets = new HashMap<>();
    public static final Map<Integer, Double> ticketPrices = new HashMap<>();
    private static double grandTotal = 0;

    static { // stacking the data
        tickets.put(1, "Regular");
        tickets.put(2, "VIP");
        tickets.put(3, "VVIP");
        ticketPrices.put(1, 500000.0);
        ticketPrices.put(2, 1000000.0);
        ticketPrices.put(3, 2000000.0);
    }

    public static void main(String[] args) {
        System.out.println("Welcome");
        while (true) {
            System.out.println("1. Buy");
            System.out.println("2. View");
            System.out.println("3. Edit");
            System.out.println("4. Checkout");
            System.out.println("Choose :");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    buyTickets();
                    break;
                case 2:
                    viewCart();
                    break;
                case 3:
                    editCart();
                    break;
                case 4:
                    checkout();
                    return;
                default:
                    System.out.println("Invalid Option. Please Choose Again");
            }
        }

    }

    public static void buyTickets() {
        while (true) {
            System.out.println("Availiable Tickets: ");
            for (Map.Entry<Integer, String> entry : tickets.entrySet()) {
                System.out
                        .println(entry.getKey() + ". " + entry.getValue() + " Rp " + ticketPrices.get(entry.getKey()));
            }
            System.out.println("Enter Ticket : ");
            int ticketId = scanner.nextInt();
            if (!tickets.containsKey(ticketId)) {
                System.out.println("Invalid item");
                continue;
            }
            System.out.println("Enter Quantity :");
            int quantity = scanner.nextInt();
            if (quantity < 1 || quantity > 4) {
                System.out.println("Quantity must be 4");
                continue;
            }

            cart.put(ticketId, cart.getOrDefault(ticketId, 0) + quantity);
            System.out.println("You have added " + quantity + " " + tickets.get(ticketId) + "(s) to your cart.");

            System.out.print("Do you want more ticket ?(y/n)");
            char more = scanner.next().charAt(0);
            if (more != 'y') {
                break;
            }
        }

    }

    public static void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty");
        }
        System.out.println("Your Cart: ");

        for (Map.Entry<Integer, Integer> entry : cart.entrySet()) {
            int ticketId = entry.getKey();
            int quantity = entry.getValue();
            System.out
                    .println(tickets.get(ticketId) + ": " + quantity + " Rp " + quantity * ticketPrices.get(ticketId));

        }

    }

    public static void editCart() {

    }

    private static void checkout() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty. Checkout cancelled.");
            return;
        }
    
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("receipt.txt"))) {
            writer.write("Receipt for Concert Ticket Purchase\n");
            writer.write("===================================\n");
            grandTotal = 0;
    
            for (Map.Entry<Integer, Integer> entry : cart.entrySet()) {
                int ticketId = entry.getKey();
                int quantity = entry.getValue();
                double price = ticketPrices.get(ticketId);
                double subtotal = price * quantity;
                grandTotal += subtotal;
    
                writer.write(tickets.get(ticketId) + ": " + quantity + " x Rp" + price + " = Rp" + subtotal + "\n");
            }
    
            writer.write("-----------------------------------\n");
            writer.write("Grand Total: Rp" + grandTotal + "\n");
            System.out.println("Checkout successful! Receipt saved to 'receipt.txt'.");
        } catch (IOException e) {
            System.out.println("Error while saving receipt: " + e.getMessage());
        }
    }
}