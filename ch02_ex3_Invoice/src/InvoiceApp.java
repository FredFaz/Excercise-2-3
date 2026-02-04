import java.util.Scanner;

public class InvoiceApp {

    public static void main(String[] args) {
        // welcome the user to the program
        System.out.println("Welcome to the Invoice Total Calculator");
        System.out.println();

        Scanner sc = new Scanner(System.in);

        String choice = "y";

        // tracking variables
        int invoiceCount = 0;
        double invoiceTotalSum = 0.0;
        double discountTotalSum = 0.0;

        // cancel if N  
        while (!choice.equalsIgnoreCase("n")) {
            
            // get the invoice subtotal from the user
            System.out.print("Enter subtotal:   ");
            double subtotal = Double.parseDouble(sc.nextLine());

            // calculate the discount percent
            double discountPercent;
            if (subtotal >= 500) {
                discountPercent = 0.25;
            } else if (subtotal >= 200) {
                discountPercent = 0.20;
            } else if (subtotal >= 100) {
                discountPercent = 0.10;
            } else {
                discountPercent = 0.0;
            }

            double discountAmount = subtotal * discountPercent;
            double total = subtotal - discountAmount;

            // accumulate totals
            invoiceCount++;
            invoiceTotalSum += total;
            discountTotalSum += discountAmount;

            // display results
            System.out.println("Discount percent: " + discountPercent);
            System.out.println("Discount amount:  " + discountAmount);
            System.out.println("Invoice total:    " + total);
            System.out.println();

            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.nextLine();
            System.out.println();
        }

        // summary output
        if (invoiceCount > 0) {
            double averageInvoice = invoiceTotalSum / invoiceCount;
            double averageDiscount = discountTotalSum / invoiceCount;

            System.out.println("Number of invoices: " + invoiceCount);
            System.out.println("Average invoice amount: " + averageInvoice);
            System.out.println("Average discount amount: " + averageDiscount);
        }

        sc.close();
    }
}
