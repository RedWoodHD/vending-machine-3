package de.shd.project.supplier;

import de.shd.project.beverage.*;

import java.util.HashSet;
import java.util.Set;

public class RealBeverageSupplier implements BeverageSupplier
{
    /**
     * @return
     */
    @Override
    public Set<Beverage> supplyBeverages()
    {
        Set<Beverage> allBeverages = new HashSet<>();
        Kakao kakao = new Kakao("Kakao",0.50,20);
        kakao.setTemperature(60);
        allBeverages.add(new VodkaMonster("Vodkamonster-white",0.95,25));
        allBeverages.add(new VodkaMonster("Vodkamonster-standard",0.85,40));
        allBeverages.add(new Vodka("Vodka-white",0.75,50));
        allBeverages.add(new Vodka("Vodka",0.70,35));
        allBeverages.add(new Monster("Monster-white",0.50,37));
        allBeverages.add(new Monster("Monster",0.45,65));
        allBeverages.add(new Fanta("Fanta-lemon",0.35,47));
        allBeverages.add(new Fanta("Fanta",0.30,23));
        allBeverages.add(new Sprite("Sprite-zero",0.40,11));
        allBeverages.add(new Sprite("Sprite",0.35,40));
        allBeverages.add(kakao);
        return allBeverages;
    }
}
