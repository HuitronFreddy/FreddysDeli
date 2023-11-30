package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    SandwichBuilder sandwichBuilder = new SandwichBuilder();
    DrinkBuilder drinkBuilder = new DrinkBuilder();
    Chip chip= new Chip();
    List<Sandwich> sandwiches = new ArrayList<>();
    List<Drink> drinks = new ArrayList<>();
    List<Chip> chips = new ArrayList<>();
    List<Meat> extraMeats = new ArrayList<>();
    List<Cheese> extraCheese = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    public void homeScreen(){
        while (true) {
            try {
                System.out.println("Chose the following options");
                System.out.println("1) New Order");
                System.out.println("0) Exit");
                int userInput = scanner.nextInt();
                switch (userInput) {
                    case 1:
                        orderScreen();
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("Enter the correct input");
                        break;
                }
            } catch (InputMismatchException exception) {
                System.out.println("Enter the correct input format");
                scanner.nextLine();
            }
        }

    }
    private void printOrderScreen(){
        System.out.println("Chose the following options");
        System.out.println("1) Add Sandwich");
        System.out.println("2) Add Signature Sandwich");
        System.out.println("3) Add Drink");
        System.out.println("4) Add Chips");
        System.out.println("5) Checkout");
        System.out.println("6) Go back to home screen");
        System.out.println("0) Cancel Order");
    }
    private void orderScreen(){
        while(true) {
            try {
                printOrderScreen();
                int userInput = scanner.nextInt();
                switch (userInput) {
                    case 1:
                        addSandwich();
                        break;
                    case 2:
                        selectSignatureSandwich();
                        break;
                    case 3:
                        addDrink();
                        break;
                    case 4:
                        addChip();
                        break;
                    case 5:
                        checkOut();
                        break;
                    case 6:
                        System.out.println("You are going back to the home screen");
                        homeScreen();
                        break;
                    case 0:
                        cancelOrder();
                        break;
                    default:
                        System.out.println("Enter the correct input");
                        break;
                }
            } catch (InputMismatchException exception) {
                System.out.println("Enter the correct input format");
                scanner.nextLine();
            }
        }
    }
    private void addSandwich(){
        sandwichBuilder.setBreadType(selectBread());
        sandwichBuilder.setBreadSize(selectSize());
        sandwichBuilder.setMeatType(selectMeat());
        sandwichBuilder.extraMeat(hasExtraMeat(),sandwichBuilder.buildSandwich().getBreadSize(),extraMeatSelectionSize());
        sandwichBuilder.setCheeseType(selectCheese());
        sandwichBuilder.extraCheese(hasExtraCheese(),sandwichBuilder.buildSandwich().getBreadSize(),extraCheeseSize());
        sandwichBuilder.setRegularTopping(selectRegularToppings());
        sandwichBuilder.setSaucesType(selectSauce());
        sandwichBuilder.isToasted(isToasted());
        sandwichBuilder.setSideType(selectSides());
        sandwiches.add(sandwichBuilder.buildSandwich());
        System.out.println("Added");
        sandwiches.forEach(System.out::println);
        extraMeats.clear();
        extraCheese.clear();


    }
    private void addDrink() {
        drinkBuilder.setDrink(selectDrinkSize());
        drinks.add(drinkBuilder.buildDrink());
        System.out.println("Added");
        drinks.forEach(System.out::println);
    }

    private void addChip(){
        chip.setChipPrice(1.50);
        chips.add(chip);
        System.out.println("Added");
        chips.forEach(System.out::println);
    }
    private void checkOutFormula(){
        System.out.println("Your order List");
        sandwiches.forEach(System.out::println);
        drinks.forEach(System.out::println);
        chips.forEach(System.out::println);
        double total = sandwiches.stream().mapToDouble(Sandwich::getBasePrice).sum()+drinks.stream().mapToDouble(Drink::getPrice).sum()+chips.stream().mapToDouble(Chip::getChipPrice).sum();
        System.out.println("Total Sandwich price: "+sandwiches.stream().mapToDouble(Sandwich::getBasePrice).sum());
        System.out.println("Total Drink price: "+drinks.stream().mapToDouble(Drink::getPrice).sum());
        System.out.println("Total Chips Price: "+chips.stream().mapToDouble(Chip::getChipPrice).sum());
        System.out.println("Checkout total: "+ total);
    }
    private void checkOut(){
        if(sandwiches.stream().mapToDouble(Sandwich::getBasePrice).sum()==0&&drinks.stream().mapToDouble(Drink::getPrice).sum()==0&&chips.stream().mapToDouble(Chip::getChipPrice).sum()==0){
            System.out.println("No order placed to checkout");
            return;
        }
        else{
            checkOutFormula();

        }
        while(true) {
            try {
                System.out.println("1) Confirm\n2) Cancel");
                int userInput = scanner.nextInt();
                switch (userInput) {
                    case 1:
                        System.out.println("Thank you for shopping with us");
                        System.out.println("Amount Due: " + 0.00);
                        DeliManager.saveReceipt(sandwiches,drinks,chips);
                        sandwiches.clear();
                        drinks.clear();
                        chips.clear();
                        homeScreen();
                        break;
                    case 2:
                        return;
                    default:
                        System.out.println("Enter the correct input");
                }
            }
            catch (InputMismatchException exception){
                System.out.println("Invalid input format");
                scanner.nextLine();
            }
        }
    }
    private void cancelOrder(){
        if(sandwiches.stream().mapToDouble(Sandwich::getBasePrice).sum()==0&&drinks.stream().mapToDouble(Drink::getPrice).sum()==0&&chips.stream().mapToDouble(Chip::getChipPrice).sum()==0){
            System.out.println("No order placed to cancel");
        }
        else {
            while(true) {
                try {
                    System.out.println("You sure you want to cancel the order");
                    System.out.println("1) Confirm\n2) Cancel");
                    int userInput = scanner.nextInt();
                    switch (userInput) {
                        case 1:
                            sandwiches.clear();
                            drinks.clear();
                            chips.clear();
                            System.out.println("Cancelling order you are going back to home Screen");
                            homeScreen();
                            break;
                        case 2:
                            return;
                        default:
                            System.out.println("Enter the correct input");
                    }
                }
                catch (InputMismatchException exception){
                    System.out.println("Invalid input format");
                    scanner.nextLine();
                }
            }
        }

    }
    private void printBreadMenu(){
        System.out.println("Select your bread");
        System.out.println("1) white\n2) wheat\n3) rye\n4) wrap\n0) Go back to order screen");
    }
    private Bread selectBread(){
        while(true) {
            try {
                printBreadMenu();
                int userInputBread = scanner.nextInt();
                switch (userInputBread) {
                    case 1:
                        System.out.println("Selected Bread: "+Bread.WHITE);
                        return Bread.WHITE;
                    case 2:
                        System.out.println("Selected Bread: "+Bread.WHEAT);
                        return Bread.WHEAT;
                    case 3:
                        System.out.println("Selected Bread: "+Bread.RYE);
                        return Bread.RYE;
                    case 4:
                        System.out.println("Selected Bread: "+Bread.WRAP);
                        return Bread.WRAP;
                    case 0:
                        System.out.println("you are going back");
                        orderScreen();
                        break;
                    default:
                        System.out.println("Enter the correct input");
                        break;

                }
            } catch (InputMismatchException exception) {
                System.out.println("Enter correct input format");
                scanner.nextLine();
            }

        }
    }
    private void printSizeMenu(){
        System.out.println("Select size");
        System.out.println(("1) 4 inch\n2) 8 inch\n3) 12 inch\n0) Go back to the order screen"));
    }
    private Bread_Size selectSize(){
        while(true) {
            try {
                printSizeMenu();
                int userInput = scanner.nextInt();
                switch (userInput) {
                    case 1:
                        System.out.println("Selected Size: "+Bread_Size.FOUR_INCH);
                        return Bread_Size.FOUR_INCH;
                    case 2:
                        System.out.println("Selected Size: "+Bread_Size.EIGHT_INCH);
                        return Bread_Size.EIGHT_INCH;
                    case 3:
                        System.out.println("Selected Size: "+Bread_Size.TWELVE_INCH);
                        return Bread_Size.TWELVE_INCH;
                    case 0:
                        System.out.println("You are going back");
                        orderScreen();
                        break;
                    default:
                        System.out.println("Enter the correct input");
                }
            } catch (InputMismatchException exception) {
                System.out.println("Enter correct Input Format");
                scanner.nextLine();
            }
        }
    }
    private void printMeatOption(){
        System.out.println("Select Meat");
        System.out.println("1) steak\n2) ham\n3) salami\n4) roast_beef\n5) chicken\n6) bacon\n0) Go Back to order screen");

    }

    private Meat selectMeat(){

        while(true) {
            try {
                printMeatOption();
                int userInput = scanner.nextInt();
                switch (userInput) {
                    case 1:
                        System.out.println("Meat added: "+Meat.STEAK);
                        return Meat.STEAK;
                    case 2:
                        System.out.println("Meat added: "+Meat.HAM);
                        return Meat.HAM;
                    case 3:
                        System.out.println("Meat added: "+Meat.SALAMI);
                        return Meat.SALAMI;
                    case 4:
                        System.out.println("Meat added: "+Meat.ROAST_BEEF);
                        return Meat.ROAST_BEEF;
                    case 5:
                        System.out.println("Meat added: "+Meat.CHICKEN);
                        return Meat.CHICKEN;
                    case 6:
                        System.out.println("Meat added: "+Meat.BACON);
                        return Meat.BACON;
                    case 0:
                        orderScreen();
                        break;
                    default:
                        System.out.println("Enter the correct input");

                }
            } catch (InputMismatchException exception) {
                System.out.println("Input the correct format");
                scanner.nextLine();
            }
        }
    }
    private List<Meat> extraMeatSelection(){
        while(true) {
            System.out.println("Select your extra Meat");
            System.out.println("1) steak\n2) ham\n3) salami\n4) roast_beef\n5) chicken\n6) bacon\n0) If you are done adding meat");
            try {
                int userInput = scanner.nextInt();
                switch (userInput) {
                    case 1:
                        extraMeats.add(Meat.STEAK);
                        System.out.println("Extra meat added: "+Meat.STEAK);
                        break;
                    case 2:
                        extraMeats.add(Meat.HAM);
                        System.out.println("Extra meat added: "+Meat.HAM);
                        break;
                    case 3:
                        extraMeats.add(Meat.SALAMI);
                        System.out.println("Extra meat added: "+Meat.SALAMI);
                        break;
                    case 4:
                        extraMeats.add(Meat.ROAST_BEEF);
                        System.out.println("Extra meat added: "+Meat.ROAST_BEEF);
                        break;
                    case 5:
                        extraMeats.add(Meat.CHICKEN);
                        System.out.println("Extra meat added: "+Meat.CHICKEN);
                        break;
                    case 6:
                        extraMeats.add(Meat.BACON);
                        System.out.println("Extra meat added: "+Meat.BACON);
                        break;
                    case 0:
                        System.out.println("Additional meats: ");
                        extraMeats.forEach(System.out::println);
                        return extraMeats;
                    default:
                        System.out.println("Enter the correct input");

                }
            } catch (InputMismatchException exception) {
                System.out.println("Input the correct format");
                scanner.nextLine();
            }
        }
    }
    private int extraMeatSelectionSize() {
        return extraMeats.size();
    }
    private boolean hasExtraMeat(){
        while(true) {
            try {
                System.out.println("Do you want extra meat");
                System.out.println("1) Yes\n2) No");
                int userInput = scanner.nextInt();
                switch (userInput) {
                    case 1:
                        extraMeatSelection();
                        return true;
                    case 2:
                        return false;
                    default:
                        System.out.println("Enter the correct input");

                }
            } catch (InputMismatchException exception) {
                System.out.println("Enter the correct input format");
                scanner.nextLine();

            }
        }
    }
    private void printCheeseOption(){
        System.out.println("Select Cheese");
        System.out.println("1) american\n2) provolone\n3) cheddar\n4) swiss\n0) Go Back to Order Screen");

    }
    private Cheese selectCheese(){
        while(true) {
            try {
                printCheeseOption();
                int userInput = scanner.nextInt();
                switch (userInput) {
                    case 1:
                        System.out.println("Selected Cheese: "+Cheese.AMERICAN);
                        return Cheese.AMERICAN;
                    case 2:
                        System.out.println("Selected Cheese: "+Cheese.PROVOLONE);
                        return Cheese.PROVOLONE;
                    case 3:
                        System.out.println("Selected Cheese: "+Cheese.CHEDDAR);
                        return Cheese.CHEDDAR;
                    case 4:
                        System.out.println("Selected Cheese: "+Cheese.SWISS);
                        return Cheese.SWISS;
                    case 0:
                        System.out.println("You are going back to the order screen");
                        orderScreen();
                        break;
                    default:
                        System.out.println("Enter the correct input");
                }
            } catch (InputMismatchException exception) {
                System.out.println("Invalid input format");
                scanner.nextLine();
            }
        }
    }
    private List<Cheese> extraCheeseSelection(){
        while(true) {
            System.out.println("Select Extra Cheese");
            System.out.println("1) american\n2) provolone\n3) cheddar\n4) swiss\n0) If you are done adding cheese");

            try {

                int userInput = scanner.nextInt();
                switch (userInput) {
                    case 1:
                        extraCheese.add(Cheese.AMERICAN);
                        System.out.println("Extra Cheese added: "+Cheese.AMERICAN);
                        break;
                    case 2:
                        extraCheese.add(Cheese.PROVOLONE);
                        System.out.println("Extra Cheese added: "+Cheese.PROVOLONE);
                        break;
                    case 3:
                        extraCheese.add(Cheese.CHEDDAR);
                        System.out.println("Extra Cheese added: "+Cheese.CHEDDAR);
                        break;
                    case 4:
                        extraCheese.add(Cheese.SWISS);
                        System.out.println("Extra Cheese added: "+Cheese.SWISS);
                        break;
                    case 0:
                        System.out.println("Selected Extra cheese: ");
                        extraCheese.forEach(System.out::println);
                        return extraCheese;
                    default:
                        System.out.println("Enter the correct input");
                }
            } catch (InputMismatchException exception) {
                System.out.println("Invalid input format");
                scanner.nextLine();
            }
        }
    }
    private int extraCheeseSize(){
        return extraCheese.size();
    }
    private boolean hasExtraCheese(){
        while(true) {
            try {
                System.out.println("Do you want extra Cheese");
                System.out.println("1) Yes\n2) No");
                int userInput = scanner.nextInt();
                switch (userInput) {
                    case 1:
                        extraCheeseSelection();
                        return true;
                    case 2:
                        return false;
                    default:
                        System.out.println("Enter the correct input");
                }
            } catch (Exception exception) {
                System.out.println("invalid input format");
                scanner.nextLine();
            }
        }

    }
    private void printRegularTopping(){
        System.out.println("Select Regular Toppings");
        System.out.println("1) lettuce\n2) peppers\n3) onions\n4) tomatoes\n5) jalapenos\n6) cucumbers\n7) pickles\n8) guacamole\n9) mushrooms\n0) if you are done selecting");

    }
    private List<Regular_Topping> selectRegularToppings() {
        List<Regular_Topping> selectedToppings = new ArrayList<>();

        while(true) {
            printRegularTopping();
            try {

                int userInput = scanner.nextInt();

                switch (userInput) {
                    case 1:
                        selectedToppings.add(Regular_Topping.LETTUCE);
                        System.out.println("Added "+Regular_Topping.LETTUCE);
                        break;
                    case 2:
                        selectedToppings.add(Regular_Topping.PEPPERS);
                        System.out.println("Added "+Regular_Topping.PEPPERS);
                        break;
                    case 3:
                        selectedToppings.add(Regular_Topping.ONIONS);
                        System.out.println("Added "+Regular_Topping.ONIONS);
                        break;
                    case 4:
                        selectedToppings.add(Regular_Topping.TOMATOES);
                        System.out.println("Added "+Regular_Topping.TOMATOES);
                        break;
                    case 5:
                        selectedToppings.add(Regular_Topping.JALAPENOS);
                        System.out.println("Added "+Regular_Topping.JALAPENOS);
                        break;
                    case 6:
                        selectedToppings.add(Regular_Topping.CUCUMBERS);
                        System.out.println("Added "+Regular_Topping.CUCUMBERS);
                        break;
                    case 7:
                        selectedToppings.add(Regular_Topping.PICKLES);
                        System.out.println("Added "+Regular_Topping.PICKLES);
                        break;
                    case 8:
                        selectedToppings.add(Regular_Topping.GUACAMOLE);
                        System.out.println("Added "+Regular_Topping.GUACAMOLE);
                        break;
                    case 9:
                        selectedToppings.add(Regular_Topping.MUSHROOMS);
                        System.out.println("Added "+Regular_Topping.MUSHROOMS);
                        break;
                    case 0:
                        System.out.println("Selected Toppings: " );
                        selectedToppings.forEach(System.out::println);
                        return selectedToppings;
                    default:
                        System.out.println("Enter the correct input");
                }
            } catch (InputMismatchException exception) {
                System.out.println("Invalid input format");
                scanner.nextLine();
            }
        }
    }
    private void printSauce(){
        System.out.println("Select Sauce");
        System.out.println("1) mayo\n2) mustard\n3) ketchup\n4) ranch\n5) thousand_island\n6) vinaigrette\n0) If you are done selecting");

    }
    private List<Sauce> selectSauce(){
        List<Sauce> selectedSauce = new ArrayList<>();
        while(true) {
            try {
                printSauce();
                int userInput = scanner.nextInt();
                switch (userInput) {
                    case 1:
                        selectedSauce.add(Sauce.MAYO);
                        System.out.println("Added: "+Sauce.MAYO);
                        break;
                    case 2:
                        selectedSauce.add(Sauce.MUSTARD);
                        System.out.println("Added: "+Sauce.MUSTARD);
                        break;
                    case 3:
                        selectedSauce.add(Sauce.KETCHUP);
                        System.out.println("Added: "+Sauce.KETCHUP);
                        break;
                    case 4:
                        selectedSauce.add(Sauce.RANCH);
                        System.out.println("Added: "+Sauce.RANCH);
                        break;
                    case 5:
                        selectedSauce.add(Sauce.THOUSAND_ISLANDS);
                        System.out.println("Added: "+Sauce.THOUSAND_ISLANDS);
                        break;
                    case 6:
                        selectedSauce.add(Sauce.VINAIGRETTE);
                        System.out.println("Added: "+Sauce.VINAIGRETTE);
                        break;
                    case 0:
                        System.out.println("Selected Sauce: ");
                        selectedSauce.forEach(System.out::println);
                        return selectedSauce;
                    default:
                        System.out.println("Enter the correct input");


                }
            }
            catch (InputMismatchException exception){
                System.out.println("invalid input format");
                scanner.nextLine();
            }
        }
    }
    private Side selectSides(){
        while(true) {
            try {
                System.out.println("Select Sides");
                System.out.println("1) au_jus\n2) sauce\n0) No sides");
                int userInput = scanner.nextInt();
                switch (userInput) {
                    case 1:
                        System.out.println("Side Added: "+Side.AU_JUS);
                        return Side.AU_JUS;
                    case 2:
                        System.out.println("Side Added: "+Side.SAUCE);
                        return Side.SAUCE;
                    case 0:
                        System.out.println("No sides were included");
                        return null;
                    default:
                        System.out.println("Enter the correct input");

                }
            }
            catch(InputMismatchException exception){
                System.out.println("invalid input format");
                scanner.nextLine();
            }
        }
    }
    private boolean isToasted(){
        while(true) {
            try {
                System.out.println("Do you want it toasted");
                System.out.println("1) Yes\n2) No");
                int userInput = scanner.nextInt();
                switch (userInput) {
                    case 1:
                        System.out.println("Toasted");
                        return true;
                    case 2:
                        System.out.println("Not Toasted");
                        return false;
                    default:
                        System.out.println("Enter the correct input");
                }
            }
            catch (InputMismatchException exception){
                System.out.println("invalid input format");
                scanner.nextLine();
            }
        }

    }
    private DrinkSize selectDrinkSize() {
        while (true) {
            try {
                System.out.println("Select Drink size");
                System.out.println("1) Small\n2) Medium\n3) Large\n0) Go Back to the order screen");
                int userInput = scanner.nextInt();
                switch (userInput) {
                    case 1:
                        return DrinkSize.SMALL;
                    case 2:
                        return DrinkSize.MEDIUM;
                    case 3:
                        return DrinkSize.LARGE;
                    case 0:
                        System.out.println("you are going back to the order screen");
                        orderScreen();
                        break;
                    default:
                        System.out.println("Enter the correct input");
                }
            }
            catch(InputMismatchException exception){
                System.out.println("invalid input format");
                scanner.nextLine();
            }
        }

    }
    public void selectSignatureSandwich(){
        while (true) {
            try {
                System.out.println("Select your signature sandwich");
                System.out.println("1) BLT\n2) PhillyCheeseSteak\n0) Go Back");
                int userInput = scanner.nextInt();

                switch (userInput) {
                    case 1:
                        System.out.println("BlT added");
                        Signature.buildBLT(sandwichBuilder);
                        extraMeats.clear();
                        extraCheese.clear();
                        sandwichBuilder.extraMeat(false,Bread_Size.EIGHT_INCH,extraMeatSelectionSize());
                        sandwichBuilder.extraCheese(false,Bread_Size.EIGHT_INCH,extraCheeseSize());
                        changeToppingInSignatureSandwich();
                        sandwiches.add(sandwichBuilder.buildSandwich());
                        System.out.println("Signature Sandwich Blt added");
                        sandwiches.forEach(System.out::println);
                        orderScreen();

                        break;
                    case 2:
                        System.out.println("Philly cheese steak added");
                        Signature.buildPhillyCheeseSteak(sandwichBuilder);
                        extraMeats.clear();
                        extraCheese.clear();
                        sandwichBuilder.extraMeat(false,Bread_Size.EIGHT_INCH,extraMeatSelectionSize());
                        sandwichBuilder.extraCheese(false,Bread_Size.EIGHT_INCH,extraCheeseSize());
                        changeToppingInSignatureSandwich();
                        sandwiches.add(sandwichBuilder.buildSandwich());
                        System.out.println("Signature Sandwich Philly cheese steak added");
                        sandwiches.forEach(System.out::println);
                        orderScreen();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Enter the correct input");
                        break;
                }
            }
            catch (InputMismatchException exception){
                System.out.println("invalid input format");
                scanner.nextLine();
            }
        }
    }
    public void changeToppingInSignatureSandwich(){
        boolean continueToppingChange = true;
        while(continueToppingChange) {
            try {
                System.out.println("Do you want to change the topping\n1) Yes\n2) No");
                int userInput = scanner.nextInt();
                switch (userInput) {
                    case 1:
                        newToppingOptions();
                        break;
                    case 2:
                        continueToppingChange = false;
                        break;
                    default:
                        System.out.println("Enter the correct input");
                        break;
                }
            }
            catch (InputMismatchException exception){
                System.out.println("Invalid input format");
                scanner.nextLine();
            }
        }
    }
    public void newToppingOptions(){
        boolean continueToppingChange = true;
        while(continueToppingChange) {
            try {
                System.out.println("Chose from the following options");
                System.out.println("1) Change Meat\n2) Change Cheese\n3) Change Regular Toppings\n4) Change sauces\n5) Add extra meat\n6) Add extra cheese\n7) No Meat\n8) No cheese\n0) If you are done adding toppings");
                int userInput = scanner.nextInt();
                switch (userInput) {
                    case 1:
                        sandwichBuilder.setMeatType(selectMeat());
                        break;
                    case 2:
                        sandwichBuilder.setCheeseType(selectCheese());
                        break;
                    case 3:
                        sandwichBuilder.setRegularTopping(selectRegularToppings());
                        break;
                    case 4:
                        sandwichBuilder.setSaucesType(selectSauce());
                        break;
                    case 5:
                        sandwichBuilder.extraMeat(hasExtraMeat(), Bread_Size.EIGHT_INCH, extraMeatSelectionSize());
                        break;
                    case 6:
                        sandwichBuilder.extraCheese(hasExtraCheese(), Bread_Size.EIGHT_INCH, extraCheeseSize());
                        break;
                    case 7:
                        sandwichBuilder.setMeatType(null);
                        System.out.println("No meat has been added");
                        break;
                    case 8:
                        sandwichBuilder.setCheeseType(null);
                        System.out.println("No cheese has been added");
                    case 0:
                        continueToppingChange = false;
                        break;
                    default:
                        System.out.println("Enter the correct input");
                        break;
                }
            }
            catch (InputMismatchException exception){
                System.out.println("Invalid input format");
                scanner.nextLine();
            }
        }
    }
}
