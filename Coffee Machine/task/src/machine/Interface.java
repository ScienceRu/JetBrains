package machine;

import java.util.Scanner;

enum TypeOfCoffee {

    ESPRESSO, LATTE, CAPPUCCINO;

    int WATER_RECIPE;
    int MILK_RECIPE;
    int BEANS_RECIPE;
    int CUPS_RECIPE;
    int PRICE;

    //method is comparing the amount of resources that coffee machine has with recipe has
    //and, if it has enough resources, making a coffee, reduce amount of resources and raise amount of money
    public void comparingResourcesAndMakingCoffee(String nameOfCoffee) {
        switch (nameOfCoffee) {
            case "ESPRESSO":
                WATER_RECIPE = 250;
                MILK_RECIPE = 0;
                BEANS_RECIPE = 16;
                CUPS_RECIPE = 1;
                PRICE = 4;
                break;
            case "LATTE":
                WATER_RECIPE = 350;
                MILK_RECIPE = 75;
                BEANS_RECIPE = 20;
                CUPS_RECIPE = 1;
                PRICE = 7;
                break;
            case "CAPPUCCINO":
                WATER_RECIPE = 200;
                MILK_RECIPE = 100;
                BEANS_RECIPE = 12;
                CUPS_RECIPE = 1;
                PRICE = 6;
                break;
        }

        if (Resources.getWaterWeHave() >= WATER_RECIPE && Resources.getMilkWeHave()
                >= MILK_RECIPE && Resources.getBeansWeHave() >= BEANS_RECIPE && Resources.getCupsWeHave() > 0) {
            System.out.println("I have enough resources, making you a coffee!");
            Resources.setWaterWeHave(-WATER_RECIPE);
            Resources.setMilkWeHave(-MILK_RECIPE);
            Resources.setBeansWeHave(-BEANS_RECIPE);
            Resources.setCupsWeHave(-CUPS_RECIPE);
            Resources.setMoneyWeHave(PRICE);
        } else if (Resources.getWaterWeHave() < WATER_RECIPE) {
            System.out.println("Sorry, not enough water!");
        } else if (Resources.getMilkWeHave() < MILK_RECIPE) {
            System.out.println("Sorry, not enough milk!");
        } else if (Resources.getBeansWeHave() < BEANS_RECIPE) {
            System.out.println("Sorry, not enough beans!");
        } else if (Resources.getCupsWeHave() == 0) {
            System.out.println("Sorry, not enough disposable cups!");
        }
    }
}

class Interface {
    Scanner sc = new Scanner(System.in);
    TypeOfCoffee espresso = TypeOfCoffee.ESPRESSO;
    TypeOfCoffee latte = TypeOfCoffee.LATTE;
    TypeOfCoffee cappuccino = TypeOfCoffee.CAPPUCCINO;

    //method is presenting interface to choose actions with coffee machine: buy, fill, take money
    public void chooseAction() {

        String action;//input of user, that defines the action of coffee machine: buy, fill, take
        do {
            System.out.print("Write action (buy, fill, take, remaining, exit): ");

            action = sc.next();
            switch (action) {
                case "buy":
                    System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
                    if (sc.hasNextInt()) {
                        int action2;//input of user, that defines the type of coffee: espresso, latte, cappuccino
                        action2 = sc.nextInt();
                        switch (action2) {
                            case 1://Espresso
                                String nameOfCoffee = "ESPRESSO";
                                espresso.comparingResourcesAndMakingCoffee(nameOfCoffee);
                                break;
                            case 2://Latte
                                nameOfCoffee = "LATTE";
                                latte.comparingResourcesAndMakingCoffee(nameOfCoffee);
                                break;
                            case 3://Cappuccino
                                nameOfCoffee = "CAPPUCCINO";
                                cappuccino.comparingResourcesAndMakingCoffee(nameOfCoffee);
                                break;
                        }
                    } else {
                        String action3 = sc.next();//return to main menu
                        switch (action3) {
                            case "back":
                                break;
                        }
                    }
                    break;
                case "fill":
                    System.out.println("Write how many ml of water you want to add:");
                    Resources.setWaterWeHave(sc.nextInt());
                    System.out.println("Write how many ml of milk you want to add:");
                    Resources.setMilkWeHave(sc.nextInt());
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    Resources.setBeansWeHave(sc.nextInt());
                    System.out.println("Write how many disposable cups of coffee you want to add:");
                    Resources.setCupsWeHave(sc.nextInt());
                    break;
                case "take":
                    System.out.println("I gave you $" + Resources.getMoneyWeHave());
                    System.out.println();
                    Resources.setMoneyWeHave(-Resources.getMoneyWeHave());
                    break;
                case "remaining":
                    Resources.displayOfTheCoffeeMachine();
                    break;

            }
        } while (!action.equals("exit"));//the button of termination
    }
}
