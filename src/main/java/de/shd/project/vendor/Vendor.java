package de.shd.project.vendor;

import java.util.*;
import java.util.stream.Collectors;

import de.shd.project.automat.VendingMachine;
import de.shd.project.beverage.Alcoholic;
import de.shd.project.beverage.Beverage;
import de.shd.project.container.Bottle;
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
public class Vendor implements VendorFunctionality
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

   /**
    * Liefert alle Beverages zurück, die der Verkäufer/Shop anbietet.
    */
   @Override
   public Set<Beverage> getBeveragesOfAllVendingMachines()
   {
      return vendingMachines.stream().flatMap(b -> b.getBeverages().stream()).collect(Collectors.toSet());
   }

   /**
    * Zählt die Anzahl aller Beverages die angeboten werden. Sollten mehrere
    * Automaten das gleiche Getränk anbieten, so wird jedes gezählt.<br>
    * Beispiel:
    * <pre>
    *    Automat1: "Coca Cola", "Limo", "Königsbacher"
    *    Automat2: "Lift", "Orangina", "Lipton Eis-Tee", "Coca Cola"
    *    Anzahl Getränke: 7
    * </pre>
    */
   @Override
   public long countNumberOfBeveragesOfAllVendingMachines()
   {
      return getBeveragesOfAllVendingMachines().size();
   }

   /**
    * Zählt die Anzahl aller Beverages die angeboten werden. Sollten mehrere
    * Automaten das gleiche Getränk anbieten, so wird nur eins gezählt.
    * Beispiel:
    * <pre>
    *    Automat1: "Coca Cola", "Limo", "Königsbacher"
    *    Automat2: "Lift", "Orangina", "Lipton Eis-Tee", "Coca Cola"
    *    Anzahl Getränke: 6
    * </pre>
    */
   @Override
   public long countNumberOfBeveragesDistinctOfAllVendingMachines()
   {
       return vendingMachines.stream()
            .flatMap(vm -> vm.getBeverages().stream())
            .map(Beverage::getName)
            .distinct()
            .count();
   }

   /**
    * Liefert den Getränkeautomaten zurück, der die meisten Getränke hat.
    * Beispiel:
    * <pre>
    *    Automat1: "Coca Cola", "Limo", "Königsbacher"
    *    Automat2: "Lift", "Orangina", "Lipton Eis-Tee", "Coca Cola"
    *    Return: Automat2
    * </pre>
    */
   @Override
   public VendingMachine getVendingMachineWithTheMostBeverages()
   {
      return vendingMachines.stream().max(Comparator.comparingInt(vm -> vm.getBeverages().size()))
              .orElse(null);
   }

   /**
    * Liefert für alle Getränkeautomaten, das erste Getränk zurück, dass nicht alkoholisch ist und den günstigsten Preis hat.<br>
    * Beispiel:
    * <pre>
    *    Automat1: "Coca Cola, 1.5€", "Limo, 1.25€", "Königsbacher (alkoholisch), 0.99€"
    *    Automat2: "Lipton Eis-Tee, 1.35€", "Coca Cola, 1,65€"
    *    Return: "Limo, 1.25€"
    * </pre>
    *
    * @return günstigstes nicht alkoholisches Getränk
    *
    * @throws NoSuchElementException wird geworfen, falls kein entsprechendes Getränk gefunden werden konnte.
    */
   @Override
   public Beverage findTheCheapestNonAlcoholicBeverage()
   {
      return vendingMachines.stream()
            .flatMap(vm -> vm.getBeverages().stream()).filter(b -> !(b instanceof Alcoholic))
            .min(Comparator.comparingDouble(b -> Bottle.PRICE_FOR_BOTTLE + b.getAmount() * b.getPricePerLiter()))
            .orElseThrow(NoSuchElementException::new);
   }
}
