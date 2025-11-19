package de.shd.project.supplier;

import de.shd.project.beverage.*;

import java.util.HashSet;
import java.util.Set;

public class RealBeverageSupplier2 implements BeverageSupplier
{
    @Override
    public Set<Beverage> supplyBeverages()
    {
        Set<Beverage> allBeverages = new HashSet<>();
        allBeverages.add(new VodkaMonster("Vodkamonster-white",0.95,0.5));
        allBeverages.add(new VodkaMonster("Vodkamonster-standard",0.85,0.5));
        allBeverages.add(new Vodka("Vodka-white",0.75,0.5));
        allBeverages.add(new Vodka("Vodka",0.70,0.5));
        allBeverages.add(new Monster("Monster-white",0.50,0.5));
        allBeverages.add(new Monster("Monster",0.45,0.5));
        allBeverages.add(new Fanta("Fanta-lemon",0.35,0.5));
        allBeverages.add(new Fanta("Fanta",0.30,0.5));
        allBeverages.add(new Sprite("Sprite-zero",0.40,0.5));
        allBeverages.add(new Sprite("Sprite",0.35,0.5));
        allBeverages.add(new Cola("Coca-cola",0.30,0.5));
        allBeverages.add(new Cola("Coca-cola-cherry",0.45,0.5));
        return allBeverages;
    }
}
