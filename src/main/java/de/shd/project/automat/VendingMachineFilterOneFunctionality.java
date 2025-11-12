package de.shd.project.automat;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import de.shd.project.beverage.Alcoholic;
import de.shd.project.beverage.Beverage;
import de.shd.project.beverage.Caffeinated;

/**
 * Definiert die Funktionalität, die der Getränkeautomat besitzen soll, um das Angebot zu filtern. (Teil 1/2)
 *
 * @author Christoph Gragert (cgr@shd.de)
 */
@SuppressWarnings("unused")
public interface VendingMachineFilterOneFunctionality
{
   /**
    * <h2>Aufgabe 5</h2>
    * Prüft, ob für den angegebenen Namen ein Getränk im Automaten existiert.
    *
    * @param name Name des Getränks (Namen müssen vollständig übereinstimmen, Case-Sensitiv)
    * @return true, falls es das Getränk im Automat gibt, ansonsten false.
    */
   boolean isBeverageListed(final String name);

   /**
    * <h2>Aufgabe 6</h2>
    * Für den übergebenen Namen wird das erst beste Getränk zurückgegeben.
    * Ein Getränk kann bereits gefunden werden, wenn
    * nur der Anfang des Namens angegeben wird. (Case-Sensitiv)
    *
    * @param name Anfang oder vollständiger Name eines Getränks
    */
   Optional<Beverage> findBeverage(final String name);

   /**
    * <h2>Aufgabe 7</h2>
    * Liefert alle alkoholischen Getränke zurück. Ein Getränk zählt als alkoholisch, wenn es {@link Alcoholic} implementiert.
    * Es ist hier unerheblich, ob {@link Alcoholic#getAlcoholStrength()} einen Wert > 0 zurückliefert.
    */
   Set<Beverage> getAllAlcoholicBeverages();

   /**
    * <h2>Aufgabe 8</h2>
    * Liefert alle koffeinhaltigen Getränke zurück. Ein Getränk zählt als alkoholisch, wenn es {@link Caffeinated} implementiert.
    * Es ist hier unerheblich, ob {@link Caffeinated#getCaffeineStrength()} einen Wert > 0 zurückliefert.
    */
   Set<Beverage> getAllCaffeinatedBeverages();

   /**
    * <h2>Aufgabe 9</h2>
    * Liefert alle Beverages zurück die "kalt" sind.
    * (<b>Hinweis:</b> Ihr könnt frei definieren, wann ein Getränk für euch die Bedingung "kalt" erfüllt.)
    */
   List<Beverage> getOnlyColdBeverages();

   /**
    * <h2>Aufgabe 10</h2>
    * Liefert alle Beverages zurück die "heiß" sind.
    * (<b>Hinweis:</b> Ihr könnt frei definieren, wann ein Getränk für euch die Bedingung "heiß" erfüllt.)
    */
   List<Beverage> getOnlyHotBeverages();
}
