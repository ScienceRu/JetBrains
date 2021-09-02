package machine;

class Resources {
    private static int waterWeHave = 400; //amount of water, that the coffee machine has for making coffee at the start
    private static int milkWeHave = 540; //amount of milk, that the coffee machine has for making coffee at the start
    private static int beansWeHave = 120; //amount of beans, that the coffee machine has for making coffee at the start
    private static int cupsWeHave = 9; //amount of disposable cups, that the coffee machine has at the start
    private static int moneyWeHave = 550; //amount of money, that the coffee machine has at the start

    public static int getWaterWeHave() {
        return waterWeHave;
    }

    public static int getBeansWeHave() {
        return beansWeHave;
    }

    public static int getCupsWeHave() {
        return cupsWeHave;
    }

    public static int getMoneyWeHave() {
        return moneyWeHave;
    }

    public static int getMilkWeHave() {
        return milkWeHave;
    }

    public static void setWaterWeHave(int change) {
        int result = getWaterWeHave() + change;
        if (result >= 0) {
            Resources.waterWeHave = result;

        }
    }

    public static void setBeansWeHave(int change) {
        int result = getBeansWeHave() + change;
        if (result >= 0) {
            Resources.beansWeHave = result;

        }
    }

    public static void setCupsWeHave(int change) {
        int result = getCupsWeHave() + change;
        if (result >= 0) {
            Resources.cupsWeHave = result;

        }
    }

    public static void setMilkWeHave(int change) {
        int result = getMilkWeHave() + change;
        if (result >= 0) {
            Resources.milkWeHave = result;
        }

    }

    public static void setMoneyWeHave(int change) {

        int result = Resources.getMoneyWeHave() + change;
        if (result >= 0) {
            Resources.moneyWeHave = result;
        }
    }


    //method displayOfTheCoffeeMachine shows the actual status of ingredients and money that coffee machine has
    public static void displayOfTheCoffeeMachine() {
        System.out.println("The coffee machine has:");
        System.out.println(getWaterWeHave() + " ml of water");
        System.out.println(getMilkWeHave() + " ml of milk");
        System.out.println(getBeansWeHave() + " g of coffee beans");
        System.out.println(getCupsWeHave() + " disposable cups");
        System.out.println("$" + getMoneyWeHave() + " of money");
        System.out.println();
    }
}


