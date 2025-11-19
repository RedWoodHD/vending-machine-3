package de.shd.project.beverage;

public class Monster extends Beverage implements Caffeinated
{
 public Monster(String name, double pricePerLiter, double amount)
   {
      super(name, pricePerLiter, amount);
   }

   protected Monster(Beverage base, double amount)
   {
      super(base, amount);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   protected Beverage createPortion(Beverage beverage, double amount)
   {
      return new Monster(beverage, amount);
   }

    /**
     * @return
     */
    @Override
    public double getCaffeineStrength()
    {
        return 150;
    }

}
