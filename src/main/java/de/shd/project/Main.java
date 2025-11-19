package de.shd.project;

import de.shd.project.automat.VendingMachine;
import de.shd.project.automat.VendingMachinePurchase;
import de.shd.project.supplier.RealBeverageSupplier;

import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setBeverageSupplier(new RealBeverageSupplier());
        vendingMachine.restock();

        System.out.println(vendingMachine.displayNamesOfAllBeverages());
        System.out.println(vendingMachine.displayNamesOfAllAlcoholicBeverages());
        System.out.println(vendingMachine.displayNamesOfAllNonAlcoholicBeverages());
        System.out.println(vendingMachine.displayAllBeverageNamesSeparatedByComma());

        System.out.println("Finde 'Fan'");
        System.out.println(vendingMachine.findBeverage("Fan"));
        System.out.println("");
        System.out.println("Ist 'Cola' im Automaten Existent");
        System.out.println(vendingMachine.isBeverageListed("Cola"));
        System.out.println("");
        System.out.println("Zeige mir alle Alcoholischen Getränke:");
        System.out.println(vendingMachine.getAllAlcoholicBeverages());
        System.out.println("");
        System.out.println("Zeige mir alle Koffeinhaltigen Getränke:");
        System.out.println(vendingMachine.getAllCaffeinatedBeverages());
        System.out.println("Preis für 2 Flaschen Monster-white");
        System.out.println(vendingMachine.calculatePriceForBottlesOf("Monster-white", 2) + "€");

    }
}
