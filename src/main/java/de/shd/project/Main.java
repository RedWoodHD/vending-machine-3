package de.shd.project;

import de.shd.project.automat.VendingMachine;
import de.shd.project.automat.VendingMachinePurchase;
import de.shd.project.supplier.RealBeverageSupplier;
import de.shd.project.supplier.RealVendingMachineSupplier;
import de.shd.project.vendor.Vendor;

public class Main
{
    public static void main(String[] args)
    {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setBeverageSupplier(new RealBeverageSupplier());
        vendingMachine.restock();
        Vendor vendor = new Vendor();
        vendor.supplyVendingMachines(new RealVendingMachineSupplier());
        vendor.restock();

        // Siehe test package für testcases. :)

    }
}
