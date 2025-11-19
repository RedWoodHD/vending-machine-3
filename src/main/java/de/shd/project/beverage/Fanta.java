package de.shd.project.beverage;

public class Fanta extends Beverage
{
    public Fanta(String name, double pricePerLiter, double amount)
   {
      super(name, pricePerLiter, amount);
   }

   protected Fanta(Beverage base, double amount)
   {
      super(base, amount);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   protected Beverage createPortion(Beverage beverage, double amount)
   {
      return new Fanta(beverage, amount);
   }
}
