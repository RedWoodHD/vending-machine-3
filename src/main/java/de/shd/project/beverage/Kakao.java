package de.shd.project.beverage;

public class Kakao extends Beverage
{
    public Kakao(String name, double pricePerLiter, double amount)
    {
        super(name, pricePerLiter, amount);
    }

    protected Kakao(Beverage base, double amount)
    {
        super(base, amount);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Beverage createPortion(Beverage beverage, double amount)
    {
        return new Kakao(beverage, amount);
    }
}
