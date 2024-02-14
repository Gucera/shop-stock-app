import java.util.Scanner;

//Yavuz Selim Sever
//2607584
//Group 11

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Add color
        String RESET = "\u001B[0m";
        String RED = "\u001B[31m";
        String YELLOW = "\u001B[33m";
        String GREEN = "\u001B[32m";
        String GREEN_TEXT = "\u001B[32m";
        // (colors definition skipped for brevity)

        // Loop to continue the program
        while (true) {
            // Create a products object
            products myProducts = new products();

            // Print the name of the software
            System.out.println(RED + "***SHOP APP***" + RESET);

            // Print the Item Names
            System.out.println("COKE -> 0 \nCoke Diet -> 1 \nCoke Zero -> 2 \nPepsi -> 3 \nPepsi Diet -> 4");

            // Ask the user to choose a product
            System.out.println("Choose a product by entering its index (0 to 4)");
            int chosenProductIndex = scanner.nextInt();

            // Display the details of the chosen product
            System.out.println(GREEN + "\nDetails of the Selected Product:" + RESET);
            displayProductDetails(myProducts, chosenProductIndex);

            // Ask the user if they want to buy stocks
            System.out.println("\nDo you want to buy stocks? (Enter 'yes' or 'no'): ");
            String buyDecision = scanner.next().toLowerCase();

            if (buyDecision.equals("yes")) {
                // Ask the user for the quantity to buy
                System.out.println("Enter the quantity to buy: ");
                int quantityToBuy = scanner.nextInt();

                // Buy stocks for the chosen product
                myProducts.buyStock(chosenProductIndex, quantityToBuy);

                // Display the updated stock after the purchase
                System.out.println(GREEN_TEXT + "Updated Information:" + RESET);
                displayProductDetails(myProducts, chosenProductIndex);
            } else {
                System.out.println("No stocks were bought.");
            }

            // Ask the user if they want to sell stocks
            System.out.println("\nDo you want to sell stocks? (Enter 'yes' or 'no'): ");
            String sellDecision = scanner.next().toLowerCase();

            if (sellDecision.equals("yes")) {
                // Ask the user for the quantity to sell
                System.out.println("Enter the quantity to sell: ");
                int quantityToSell = scanner.nextInt();

                // Sell stocks for the chosen product
                boolean soldSuccessfully = myProducts.sellStock(chosenProductIndex, quantityToSell);

                // Display the result of the sale and the total price
                if (soldSuccessfully) {
                    System.out.println(YELLOW + "\nStock Sale Result: Sold successfully" + RESET);
                    double totalPrice = quantityToSell * myProducts.price[chosenProductIndex];
                    System.out.println("Total Price: $" + totalPrice);
                } else {
                    System.out.println("\nStock Sale Result: Sale failed");
                }

                // Display the updated stock after the sale
                System.out.println(GREEN_TEXT + "Updated Information:" + RESET);
                displayProductDetails(myProducts, chosenProductIndex);
            } else {
                System.out.println("No stocks were sold.");
            }

            // Ask the user if they want to continue
            System.out.println("\nDo you want to continue? (Enter 'yes' to continue, any other input to exit): ");
            String continueDecision = scanner.next().toLowerCase();

            if (!continueDecision.equals("yes")) {
                // Exit the loop if the user does not want to continue
                break;
            }
        }

        // Close the scanner to avoid resource leaks
        scanner.close();
    }

    // Helper method to display details of a specific product
    private static void displayProductDetails(products myProducts, int productIndex) {
        System.out.println("Name: " + myProducts.name[productIndex]);
        System.out.println("Stock Number: " + myProducts.stockNumber[productIndex]);
        System.out.println("Price per Item: $" + myProducts.price[productIndex]);
    }
}
