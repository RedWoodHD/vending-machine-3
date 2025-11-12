package de.shd.project.automat;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

import de.shd.project.beverage.Beverage;
import de.shd.project.container.Bottle;
import de.shd.project.supplier.BeverageSupplier;

import static de.shd.project.container.Bottle.*;


/**
 * <h3>Repräsentation eines Getränkeautomats</h3>
 * Dieser soll wie folgt funktionieren:
 * <p>
 * Über den {@link BeverageSupplier} (Getränkezulieferer) kann der Automat mit ein Sortiment von Getränken bestückt werden. Hierbei wird eine
 * Menge des Getränks {@link Beverage#getAmount()} in den Automaten abgefüllt. Dieser lagert das Getränk in einem Behälter analog zu:<br>
 * <br><img src="vendingmachine.png" width="242" height="271"></img>
 * </p>
 * <p>
 * Die Getränke werden über {@link #beverages} verwaltet. Die "Behälter" des Getränkeautomats werden nur befüllt, wenn die {@link #restock()}
 * Methode aufgerufen wird.
 * </p>
 *
 * @author Christoph Gragert (cgr@shd.de)
 */
public class VendingMachine
{
   /**
    * Getränke, mit denen der Automat befüllt wurde.
    */
   private Set<Beverage> beverages = new HashSet<>();
   /**
    * Getränkezulieferer
    */
   private BeverageSupplier beverageSupplier;

   public void setBeverageSupplier(BeverageSupplier beverageSupplier)
   {
      this.beverageSupplier = beverageSupplier;
   }

   public void restock()
   {
      beverages = beverageSupplier.supplyBeverages();
   }

   public Set<Beverage> getBeverages()
   {
      return beverages;
   }

}
