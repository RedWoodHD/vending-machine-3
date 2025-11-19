package de.shd.project.beverage;

public class VodkaMonster extends Beverage implements Alcoholic,Caffeinated
{

    public VodkaMonster(String name, double pricePerLiter, double amount)
    {
        super(name, pricePerLiter, amount);
    }

    protected VodkaMonster(Beverage base, double amount)
    {
        super(base, amount);
    }

    /**
     * @return
     */
    @Override
    public double getAlcoholStrength()
    {
        return 40;
    }

    /**
     * Liefert ein neues Getränk zurück, das von dem übergebenen Getränk für die übergebene Menge abgefüllt wurde. D.h. das neue Getränk enthält die
     * Menge {@code amount}, wobei das vorherige Getränk die Menge {@code vorherige Menge - amount} hat. Diese Methode MUSS von den Unterklassen
     * implementiert werden. Ein Beispiel ist in {@link Cola} zu sehen.
     *
     * @param beverage Getränk aus dem Automaten, dass für eine bestimmte Menge in einen Behälter abgefüllt wird.
     * @param amount   die Menge, die abgefüllt werden soll
     *
     * @return Das neue Getränk mit der definierten Menge.
     */
    @Override
    protected Beverage createPortion(Beverage beverage, double amount)
   {
      return new VodkaMonster(beverage, amount);
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
