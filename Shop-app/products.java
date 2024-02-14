public class products {
    public String[] name;
    public int[] stockNumber;
    public Double[] price;


    public products() {
        String[][] productData = {
                {"Coke", "45", "0.70"},
                {"Coke Diet", "47", "0.85"},
                {"Coke Zero", "63", "0.85"},
                {"Pepsi", "187", "0.80"},
                {"Pepsi Diet", "102", "0.90"}
        };

        int rows = productData.length;
        int columns = productData[0].length;

        name = new String[rows];
        stockNumber = new int[rows];
        price = new Double[rows];

        for (int i = 0; i < rows; i++) {
            name[i] = productData[i][0];

            // Check if the stock number is a valid integer
            try {
                stockNumber[i] = Integer.parseInt(productData[i][1]);
            } catch (NumberFormatException e) {
                // Handle the exception (print an error message, set a default value, etc.)
                System.err.println("Invalid stock number for product " + name[i] + ". Setting to 0.");
                stockNumber[i] = 0;
            }

            // Parse the price as Double
            price[i] = Double.parseDouble(productData[i][2]);
        }
    }




    public double buyStock(int productIndex, int quantity) {
        if (productIndex >= 0 && productIndex < name.length && quantity > 0) {
            stockNumber[productIndex] += quantity;
            double value = quantity * price[productIndex];
            System.out.println(quantity + " stocks of " + name[productIndex] + " bought successfully.");
            System.out.println("Updated stock of " + name[productIndex] + ": " + stockNumber[productIndex]);
            return value;
        } else {
            System.out.println("Invalid product index or quantity. Please enter a valid quantity.");
            return 0;
        }
    }



    public boolean sellStock(int productIndex, int quantity) {
        if (productIndex >= 0 && productIndex < name.length && quantity > 0 && quantity <= stockNumber[productIndex]) {
            stockNumber[productIndex] -= quantity;
            double value = quantity * price[productIndex];
            System.out.println(quantity + " stocks of " + name[productIndex] + " sold successfully.");
            return true;
        } else {
            System.out.println("Invalid product index, quantity, or insufficient stock available.");
            return false;
        }
    }

}

