package ui;

import repository.*;
import service.*;

import java.util.Scanner;

public class POSUI {
    private ProductRepository productRepo = new ProductRepository();
    private SaleRepository saleRepo = new SaleRepository();
    private ReturnRepository returnRepo = new ReturnRepository();

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n1. Process Sale");
            System.out.println("2. Handle Return");
            System.out.println("3. Show Products");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1 -> processSale(scanner);
                    case 2 -> processReturn(scanner);
                    case 3 -> productRepo.showAllProducts();
                    case 0 -> running = false;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void processSale(Scanner scanner) {
        SaleService service = new SaleService(productRepo, saleRepo);
        while (true) {
            System.out.print("Enter Product ID (or 0 to finish): ");
            String id = scanner.next();
            if (id.equals("0")) break;

            System.out.print("Quantity: ");
            int qty = scanner.nextInt();
            service.addItem(id, qty);
        }
        double total = service.completeSale();
        System.out.println("Sale completed. Total: $" + total);
    }

    private void processReturn(Scanner scanner) {
        ReturnService service = new ReturnService(productRepo, returnRepo);
        System.out.print("Enter Product ID: ");
        String id = scanner.next();

        System.out.print("Quantity: ");
        int qty = scanner.nextInt();

        service.processReturn(id, qty);
        System.out.println("Return processed successfully.");
    }
}
