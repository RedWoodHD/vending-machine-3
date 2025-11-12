package de.shd.project.container;


import de.shd.project.beverage.Beverage;

/**
 * Basis-Klasse für Container in denen Getränke aufbewahrt werden können.
 *
 * @param <BEVERAGE_TYPE> Klasse des Getränks
 * @author Christoph Gragert (cgr@shd.de)
 */
@SuppressWarnings("java:S119")
public abstract class Container<BEVERAGE_TYPE extends Beverage>
{
   protected final BEVERAGE_TYPE beverage;

   @SuppressWarnings("unchecked")
   public Container(BEVERAGE_TYPE beverage)
   {
      // Es wird basierend auf der maximalen Menge, die in die Flasche passt, das Getränk in den Container abgefüllt.
      this.beverage = (BEVERAGE_TYPE) beverage.portion(getMaxAmount());
   }

   protected abstract double getMaxAmount();

   protected abstract double getBasePrice();

   public String getName()
   {
      return beverage.getName();
   }

   public double getPrice()
   {
      return getBasePrice() + beverage.getAmount() * beverage.getPricePerLiter();
   }
}
