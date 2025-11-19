package de.shd.project.supplier;

import de.shd.project.automat.VendingMachine;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RealVendingMachineSupplier implements VendingMachineSupplier
{

    /**
     * @return
     */
    @Override
    public List<VendingMachine> supplyVendingMachines()
    {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setBeverageSupplier(new RealBeverageSupplier());
        VendingMachine vendingMachine2 = new VendingMachine();
        vendingMachine2.setBeverageSupplier(new RealBeverageSupplier2());
        vendingMachine.restock();
        vendingMachine2.restock();
        return List.of(vendingMachine,vendingMachine2);
    }
}
