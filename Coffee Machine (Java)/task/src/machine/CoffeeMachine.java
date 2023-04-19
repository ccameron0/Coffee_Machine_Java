package machine;
import java.util.Objects;
import java.util.Scanner;

public class CoffeeMachine {

    static int waterAvailable = 400;
    static int milkAvailable = 540;
    static int beansAvailable = 120;
    static int cupsAvailable = 9;
    static int moneyAvailable = 550;

    static void displayContent(){
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(waterAvailable + " ml of water");
        System.out.println(milkAvailable + " ml of milk");
        System.out.println(beansAvailable + " g of coffee beans");
        System.out.println(cupsAvailable + " disposable cups");
        System.out.println("$" + moneyAvailable + " of money");
    }

    static void buyEspresso() {
        if (waterAvailable-250 < 0) {
            System.out.println("Sorry, not enough water!");
        }
        else if (beansAvailable-16 < 0) {
            System.out.println("Sorry, not enough water!");
        }
        else if (cupsAvailable-1 < 0) {
            System.out.println("Sorry, not enough water!");
        }
        else {
            System.out.println("I have enough resources, making you a coffee!");
            waterAvailable -= 250;
            beansAvailable -= 16;
            moneyAvailable += 4;
            cupsAvailable --;
        }
    }

    static void buyLatte() {
        if (waterAvailable-350 < 0) {
            System.out.println("Sorry, not enough water!");
        }
        else if (milkAvailable-75 < 0) {
            System.out.println("Sorry, not enough water!");
        }
        else if (beansAvailable-20 < 0) {
            System.out.println("Sorry, not enough water!");
        }
        else if (cupsAvailable-1 < 0) {
            System.out.println("Sorry, not enough water!");
        }
        else {
            System.out.println("I have enough resources, making you a coffee!");
            waterAvailable -= 350;
            milkAvailable -= 75;
            beansAvailable -= 20;
            moneyAvailable += 7;
            cupsAvailable --;
        }
    }

    static void buyCappuccino() {
        if (waterAvailable-200 < 0) {
            System.out.println("Sorry, not enough water!");
        }
        else if (milkAvailable-100 < 0) {
            System.out.println("Sorry, not enough water!");
        }
        else if (beansAvailable-12 < 0) {
            System.out.println("Sorry, not enough water!");
        }
        else if (cupsAvailable-1 < 0) {
            System.out.println("Sorry, not enough water!");
        }
        else {
            System.out.println("I have enough resources, making you a coffee!");
            waterAvailable -= 200;
            milkAvailable -= 100;
            beansAvailable -= 12;
            moneyAvailable += 6;
            cupsAvailable --;
        }
    }

    static void fillMachine() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        waterAvailable += scan.nextInt();

        System.out.println("Write how many ml of milk you want to add:");
        milkAvailable += scan.nextInt();

        System.out.println("Write how many grams of coffee you want to add:");
        beansAvailable += scan.nextInt();

        System.out.println("Write how many disposable cups you want to add:");
        cupsAvailable += scan.nextInt();
    }

    static void takeMoney() {
        System.out.println("I gave you $" + moneyAvailable);
        moneyAvailable = 0;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner (System.in);

        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String action = scan.next();
        label:
        while(true){

            switch (action) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino +" +
                            "back - to main menu:");
                    String choice = scan.next();
                    if (Objects.equals(choice, "1")) {
                        buyEspresso();
                        break;
                    } else if (Objects.equals(choice, "2")) {
                        buyLatte();
                        break;
                    } else if (Objects.equals(choice, "3")) {
                        buyCappuccino();
                        break;
                    } else  {
                        break;
                    }
                case "fill":
                    fillMachine();
                    break;
                case "take":
                    takeMoney();
                    break;
                case "remaining":
                    displayContent();
                    break;
                default:
                    break label;
            }
            System.out.println();
            action = scan.next();
        }

    }
}
