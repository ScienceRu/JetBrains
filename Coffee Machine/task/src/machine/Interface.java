package machine;

import java.util.Scanner;

class Interface {
    Scanner sc = new Scanner(System.in);
    //amount of water, milk and beans that the coffee needs by receipt to be prepared (by tipes of coffee: espresso,
    //latte & cappuccino
    public final int ESPRESSO_WATER_RECIPE = 250;
    public final int ESPRESSO_MILK_RECIPE = 0;
    public final int ESPRESSO_BEANS_RECIPE = 16;
    public final int CUPS_RECIPE = 1;
    public final int ESPRESSO_PRICE = 4;

    public final int LATTE_WATER_RECIPE = 350;
    public final int LATTE_MILK_RECIPE = 75;
    public final int LATTE_BEANS_RECIPE = 20;
    public final int LATTE_PRICE = 7;

    public final int CAPPUCCINO_WATER_RECIPE = 200;
    public final int CAPPUCCINO_MILK_RECIPE = 100;
    public final int CAPPUCCINO_BEANS_RECIPE = 12;
    public final int CAPPUCCINO_PRICE = 6;

    private boolean compareResourcesThatWeHaveWithRecipe() {
        boolean result = false;
        if (Resources.getWaterWeHave() >= ESPRESSO_WATER_RECIPE && Resources.getMilkWeHave()
                >= ESPRESSO_MILK_RECIPE && Resources.getBeansWeHave() >= ESPRESSO_BEANS_RECIPE && Resources.getCupsWeHave() > 0) {
            result = true;
            System.out.println("I have enough resources, making you a coffee!");
        } else if (Resources.getWaterWeHave() < ESPRESSO_WATER_RECIPE) {
            System.out.println("Sorry, not enough water!");
        } else if (Resources.getMilkWeHave() < ESPRESSO_MILK_RECIPE) {
            System.out.println("Sorry, not enough milk!");
        } else if (Resources.getBeansWeHave() < ESPRESSO_BEANS_RECIPE) {
            System.out.println("Sorry, not enough beans!");
        } else if (Resources.getCupsWeHave() <= 0) {
            System.out.println("Sorry, not enough disposable cups!");
        }
        return result;
    }


    public void chooseAction() {
        //method is interface to choose actions with coffee machine: buy, fill, take money
        String action;//input of user, that defines the action of coffee machine: buy, fill, take
        do {
            System.out.print("Write action (buy, fill, take, remaining, exit): ");

            action = sc.next();
            switch (action) {
                case "buy":
                    System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
                    if (sc.hasNextInt()) {
                        int action2;
                        action2 = sc.nextInt();
                        switch (action2) {
                            case 1://Espresso
                                if (Resources.getWaterWeHave() >= ESPRESSO_WATER_RECIPE && Resources.getMilkWeHave()
                                        >= ESPRESSO_MILK_RECIPE && Resources.getBeansWeHave() >= ESPRESSO_BEANS_RECIPE
                                        && Resources.getCupsWeHave() > 0) {
                                    Resources.setWaterWeHave(-ESPRESSO_WATER_RECIPE);
                                    Resources.setBeansWeHave(-ESPRESSO_BEANS_RECIPE);
                                    Resources.setCupsWeHave(-CUPS_RECIPE);
                                    Resources.setMoneyWeHave(ESPRESSO_PRICE);
                                } else if (Resources.getWaterWeHave() < ESPRESSO_WATER_RECIPE) {
                                    System.out.println("Sorry, not enough water!");
                                } else if (Resources.getMilkWeHave() < ESPRESSO_MILK_RECIPE) {
                                    System.out.println("Sorry, not enough milk!");
                                } else if (Resources.getBeansWeHave() < ESPRESSO_BEANS_RECIPE) {
                                    System.out.println("Sorry, not enough beans!");
                                } else if (Resources.getCupsWeHave() <= 0) {
                                    System.out.println("Sorry, not enough disposable cups!");
                                }

                                break;
                            case 2://Latte
                                if (Resources.getWaterWeHave() >= LATTE_WATER_RECIPE && Resources.getMilkWeHave()
                                        >= LATTE_MILK_RECIPE
                                        && Resources.getBeansWeHave() >= LATTE_BEANS_RECIPE && Resources.getCupsWeHave() > 0) {
                                    System.out.println("I have enough resources, making you a coffee!");
                                    Resources.setWaterWeHave(-LATTE_WATER_RECIPE);
                                    Resources.setMilkWeHave(-LATTE_MILK_RECIPE);
                                    Resources.setBeansWeHave(-LATTE_BEANS_RECIPE);
                                    Resources.setCupsWeHave(-CUPS_RECIPE);
                                    Resources.setMoneyWeHave(LATTE_PRICE);
                                } else if (Resources.getWaterWeHave() < LATTE_WATER_RECIPE) {
                                    System.out.println("Sorry, not enough water!");
                                } else if (Resources.getMilkWeHave() < LATTE_MILK_RECIPE) {
                                    System.out.println("Sorry, not enough milk!");
                                } else if (Resources.getBeansWeHave() < LATTE_BEANS_RECIPE) {
                                    System.out.println("Sorry, not enough beans!");
                                } else if (Resources.getCupsWeHave() <= 0) {
                                    System.out.println("Sorry, not enough disposable cups!");
                                }
                                break;
                            case 3://Cappuccino
                                if (Resources.getWaterWeHave() >= CAPPUCCINO_WATER_RECIPE && Resources.getMilkWeHave()
                                        >= CAPPUCCINO_MILK_RECIPE && Resources.getBeansWeHave()
                                        >= CAPPUCCINO_BEANS_RECIPE && Resources.getCupsWeHave() > 0) {
                                    System.out.println("I have enough resources, making you a coffee!");
                                    Resources.setWaterWeHave(-CAPPUCCINO_WATER_RECIPE);
                                    Resources.setMilkWeHave(-CAPPUCCINO_MILK_RECIPE);
                                    Resources.setBeansWeHave(-CAPPUCCINO_BEANS_RECIPE);
                                    Resources.setCupsWeHave(-CUPS_RECIPE);
                                    Resources.setMoneyWeHave(CAPPUCCINO_PRICE);
                                } else if (Resources.getWaterWeHave() < CAPPUCCINO_WATER_RECIPE) {
                                    System.out.println("Sorry, not enough water!");
                                } else if (Resources.getMilkWeHave() < CAPPUCCINO_MILK_RECIPE) {
                                    System.out.println("Sorry, not enough milk!");
                                } else if (Resources.getBeansWeHave() < CAPPUCCINO_BEANS_RECIPE) {
                                    System.out.println("Sorry, not enough beans!");
                                } else if (Resources.getCupsWeHave() <= 0) {
                                    System.out.println("Sorry, not enough disposable cups!");
                                }
                                break;
                        }
                    } else {
                        String action3 = sc.next();
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
        } while (!action.equals("exit"));
    }
}
