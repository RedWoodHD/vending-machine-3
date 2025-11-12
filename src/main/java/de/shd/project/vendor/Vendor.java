package de.shd.project.vendor;

import java.util.ArrayList;
import java.util.List;

import de.shd.project.automat.VendingMachine;
import de.shd.project.supplier.VendingMachineSupplier;


/**
 * <h3>Repräsentation für einen Verkäufer/Sammlung von Getränkeautomaten</h3>
 * <p>
 * Analog zu {@link VendingMachine#beverageSupplier} gibt für den Verkäufer auch einen {@link #vendingMachineSupplier}, der ihn mit
 * einer Auswahl an unterschiedlichen Getränkeautomaten beliefert. Die Automaten werden in {@link #vendingMachines} verwaltet. Das Sortiment an
 * Getränkeautomaten wird nur gefüllt, wenn {@link #restock()} aufgerufen wird.
 * </p>
 *
 * @author Christoph Gragert (cgr@shd.de)
 */
@SuppressWarnings("JavadocReference")
public class Vendor
{
   private List<VendingMachine> vendingMachines = new ArrayList<>();
   private VendingMachineSupplier vendingMachineSupplier;

   public void supplyVendingMachines(final VendingMachineSupplier vendingMachineSupplier)
   {
      this.vendingMachineSupplier = vendingMachineSupplier;
   }

   public void restock()
   {
      vendingMachines = vendingMachineSupplier.supplyVendingMachines();
      vendingMachines.forEach(VendingMachine::restock);
   }
}
