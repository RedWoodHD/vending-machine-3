package de.shd.project.beverage;

public class Vodka extends Beverage implements Alcoholic
{
    public Vodka(String name, double pricePerLiter, double amount)
   {
      super(name, pricePerLiter, amount);
   }

   protected Vodka(Beverage base, double amount)
   {
      super(base, amount);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   protected Beverage createPortion(Beverage beverage, double amount)
   {
      return new Vodka(beverage, amount);
   }

    /**
     * @return
     */
    @Override
    public double getAlcoholStrength()
    {
        return 40;
    }
}
