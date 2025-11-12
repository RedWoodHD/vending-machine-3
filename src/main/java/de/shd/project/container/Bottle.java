package de.shd.project.container;


import de.shd.project.beverage.Beverage;

/**
 * Repräsentation eine Flasche, in die 0,5 Liter passen.
 *
 * @param <BEVERAGE_TYPE> Klasse des Getränks
 * @author Christoph Gragert (cgr@shd.de)
 */
@SuppressWarnings("java:S119")
public class Bottle<BEVERAGE_TYPE extends Beverage> extends Container<BEVERAGE_TYPE>
{
   public static final double MAX_AMOUNT_IN_LITER = 0.5;
   public static final double PRICE_FOR_BOTTLE = 0.25;

   public Bottle(BEVERAGE_TYPE beverage)
   {
      super(beverage);
   }

   @Override
   protected double getMaxAmount()
   {
      return MAX_AMOUNT_IN_LITER;
   }

   @Override
   protected double getBasePrice()
   {
      return PRICE_FOR_BOTTLE;
   }
}
