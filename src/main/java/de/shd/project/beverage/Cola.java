package de.shd.project.beverage;

/**
 * <h2>Beispiel Getränk</h2>
 * Repräsentiert das Getränk Coca-Cola. Diese Variante von Coca-Cola enthält kein Koffein. Die Klasse dient als Beispiel, wie die Methode
 * {@link #createPortion(Beverage, double)} überschrieben werden muss, wenn man seine eigenen Getränke anlegen möchte.
 *
 * @author Christoph Gragert (cgr@shd.de)
 */
public class Cola extends Beverage
{
   public Cola(String name, double pricePerLiter, double amount)
   {
      super(name, pricePerLiter, amount);
   }

   protected Cola(Beverage base, double amount)
   {
      super(base, amount);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   protected Beverage createPortion(Beverage beverage, double amount)
   {
      return new Cola(beverage, amount);
   }
}
