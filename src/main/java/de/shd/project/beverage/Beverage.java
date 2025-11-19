package de.shd.project.beverage;

import java.util.Objects;

/**
 * Basis-Klasse für alle Getränke, die über {@link de.shd.project.automat.VendingMachine} vertrieben werden können.
 *
 * @author Christoph Gragert (cgr@shd.de)
 */
public abstract class Beverage
{
   /**
    * Name des Getränks
    */
   private final String name;

   /**
    * Preis pro Liter
    */
   private final double pricePerLiter;

   /**
    * Menge in Litern
    */
   private double amount;

   /**
    * Serviertemperatur des Getränks
    */
   private int temperature;

   public Beverage(String name, double pricePerLiter, double amount)
   {
      this.name = name;
      this.pricePerLiter = pricePerLiter;
      this.amount = amount;
      this.temperature = 7;
   }

   protected Beverage(Beverage base, double amount)
   {
      this.name = base.getName();
      this.temperature = base.getTemperature();
      this.pricePerLiter = base.getPricePerLiter();
      this.amount = calculateAmount(base, amount);
      base.setAmount(base.getAmount() - this.amount);
   }

   @Override
   public boolean equals(Object o)
   {
      if( this == o )
      {
         return true;
      }
      if( o == null || getClass() != o.getClass() )
      {
         return false;
      }
      Beverage beverage = (Beverage) o;
      return Objects.equals(name, beverage.name);
   }

   @Override
   public int hashCode()
   {
      return Objects.hash(name);
   }

   public Beverage portion(double amount)
   {
      return createPortion(this, amount);
   }

   /**
    * Liefert ein neues Getränk zurück, das von dem übergebenen Getränk für die übergebene Menge abgefüllt wurde. D.h. das neue Getränk enthält die
    * Menge {@code amount}, wobei das vorherige Getränk die Menge {@code vorherige Menge - amount} hat. Diese Methode MUSS von den Unterklassen
    * implementiert werden. Ein Beispiel ist in {@link Cola} zu sehen.
    *
    * @param beverage Getränk aus dem Automaten, dass für eine bestimmte Menge in einen Behälter abgefüllt wird.
    * @param amount   die Menge, die abgefüllt werden soll
    * @return Das neue Getränk mit der definierten Menge.
    */
   protected abstract Beverage createPortion(Beverage beverage, double amount);

   private double calculateAmount(Beverage base, double amount)
   {
      final double baseAmount = base.getAmount();
      if( baseAmount < 0.01 )
      {
         throw new InsufficientBeverageException();
      }
      return Math.min(baseAmount, amount);
   }

   public String getName()
   {
      return name;
   }

   public double getPricePerLiter()
   {
      return pricePerLiter;
   }

   public double getAmount()
   {
      return amount;
   }

   public void setAmount(double amount)
   {
      this.amount = amount;
   }

   public void setTemperature(int temp){
      this.temperature = temp;
   }

   public int getTemperature()
   {
      return temperature;
   }
   @Override
   public String toString(){
      return getName();
   }

}
