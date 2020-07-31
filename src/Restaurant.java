import java.util.Scanner;

public class Restaurant {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int people=0;
        int feeds=0;
        double price = 0;
        int trays;
        double subtotal;
        double taxrate = 7.0;
        double tipRate = 15.0;
        double tax;
        double tip;
        double grandTotal;
//Get the number of people within bounds (10 to 100)
        boolean flag = true;
        while (flag) {
            flag = false;
            System.out.println("How many people are ordering?");
            people = scanner.nextInt();
            scanner.nextLine();
            if (people > 100 || people < 10) {
                System.out.println("Out of Bounds. Needs at least 10 people and there are only 100 people.");
                flag = true;
            }
        }
//Select from Main Menu, then select from respective Menus. Make sure valid entry is made.
        boolean flag2 = true;
        while (flag2) {
            flag2 = false;
            System.out.println("CHOOSE TYPE OF MEAL");
            displayMainMenu();
            int mainMenuChoice = scanner.nextInt();
            scanner.nextLine();

            switch (mainMenuChoice) {

                case 1:
                    boolean flag3 = true;
                    while (flag3) {
                        flag3 = false;
                        displayItalianFoodMenu();
                        System.out.println("Enter Choice: ");
                        int choice1 = scanner.nextInt();
                        switch (choice1) {
                            case 1:
                                feeds = 5;
                                price = 17.99;
                                break;
                            case 2:
                                feeds = 7;
                                price = 15.99;
                                break;
                            case 3:
                                feeds = 4;
                                price = 12.99;
                                break;
                            default:
                                System.out.println("Enter a proper menu option!");
                                flag3 = true;
                                break;


                        }

                    }

                    break;
                case 2:
                    boolean flag4 = true;
                    while (flag4) {
                        flag4 = false;
                        displayChineseFoodMenu();
                        System.out.println("Enter Choice: ");
                        int choice1 = scanner.nextInt();
                        switch (choice1) {
                            case 1:
                                feeds = 7;
                                price = 18.99;

                                break;
                            case 2:
                                feeds = 7;
                                price = 18.99;
                                break;
                            case 3:
                                feeds = 5;
                                price = 10.99;
                                break;
                            default:
                                System.out.println("Enter a proper menu option!");
                                flag4 = true;
                                break;


                        }


                    }
                    break;
                case 3:
                    boolean flag5 = true;
                    while (flag5) {
                        flag5 = false;
                        displayAmericanFoodMenu();
                        System.out.println("Enter Choice: ");
                        int choice1 = scanner.nextInt();
                        switch (choice1) {
                            case 1:
                                feeds = 8;
                                price = 21.99;
                                break;
                            case 2:
                                feeds = 5;
                                price = 22.99;
                                break;
                            case 3:
                                feeds = 10;
                                price = 26.99;
                                break;
                            default:
                                System.out.println("Enter a proper menu option!");
                                flag5 = true;
                                break;


                        }
                    }
                    break;
                default:
                    System.out.println("Invalid Entry. Enter 1,2, or 3!");
                    displayMainMenu();
                    flag2 = true;
                    break;
            }
        }

        trays = determineTrays(people, feeds);
        System.out.println("You need " + trays + " trays.");
        subtotal = getSubtotal(price, trays);
        System.out.println(String.format("Price for " + people + " people (" + trays + " trays): $" + "%.2f", subtotal));
        tax = getTax(subtotal, taxrate);
        System.out.println(String.format("Tax: $" + "%.2f", tax));
        tip = getTip(subtotal, tipRate);
        System.out.println(String.format("Tip: $" + "%.2f", tip));
        grandTotal = getGrandTotal(subtotal, tax, tip);
        System.out.println(String.format("Total (food,tax,tip): $" + "%.2f", grandTotal));
        System.out.println(String.format("Price per person: $%.2f", pricePerPerson(grandTotal, people)));
        System.out.println("Leftover servings for the delivery person: " + determineLeftOvers(feeds, trays, people));


        scanner.close();


    }


    public static void displayMainMenu() {

        System.out.println("1. Italian\n2. Chinese\n3. American");
    }

    public static void displayItalianFoodMenu() {
        System.out.println("Italian Food Menu: \n CHOOSE ONE");
        System.out.println("1. Lasagna Tray - Feeds 5 - 17.99 \n2. Pizza Pack - Feeds 7 - 15.99 \n3. Gazpacho Soup, salad and bread sticks pack - Feeds 4 - 12.99");
    }

    public static void displayChineseFoodMenu() {
        System.out.println("Chinese Food Menu: \nCHOOSE ONE");
        System.out.println("1. Chicken and Broccoli Tray (includes 7 wonton soups, 7 egg rolls) - feeds 7 - 18.99\n" +
                "2. Sweet and Sour Pork Tray (includes 7 hot and sour soups, 7 egg rolls) - feeds 7 - 18.99\n" +
                "3. Shrimp Fried Rice Tray (includes 10 egg rolls) - Feeds 5 - 10.99");

    }

    public static void displayAmericanFoodMenu() {
        System.out.println("American Food Menu: ");
        System.out.println("1. Hamburger and Hot Dog Tray - includes buns and condiments - feeds 8 - 21.99\n" +
                "2. Grilled Chicken Sandwich and Mozzarella Sticks Tray - includes dipping sauces -Feeds 5 - 22.99\n" +
                "3. Barbeque Tray - includes buns and peach cobbler - Feeds 10 - 26.99");

    }

    public static int determineTrays(int people, int feeds) {
        if (people % feeds == 0) {
            return people / feeds;
        } else return people / feeds + 1;
    }

    public static double getSubtotal(double price, int trays) {
        return trays * price;
    }

    public static double getTax(double subtotal, double taxrate) {
        return subtotal * taxrate / 100;
    }

    public static double getTip(double subtotal, double tipRate) {
        return subtotal * tipRate / 100;
    }

    public static double getGrandTotal(double subtotal, double tax, double tip) {
        return subtotal + tax + tip;
    }

    public static double pricePerPerson(double grandTotal, int people) {
        return grandTotal / people;
    }

    public static int determineLeftOvers(int feeds, int trays, int people) {
        return trays * feeds - people;
    }
}
