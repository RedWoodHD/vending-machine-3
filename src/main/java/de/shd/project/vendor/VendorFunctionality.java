package de.shd.project.vendor;

import java.util.Set;

import de.shd.project.automat.VendingMachine;
import de.shd.project.beverage.Beverage;


/**
 * Definiert die Funktionalität, die ein Verkäufer/Shop haben soll.
 *
 * @author Christoph Gragert (cgr@shd.de)
 */
@SuppressWarnings("unused")
public interface VendorFunctionality
{
   /**
    * Liefert alle Beverages zurück, die der Verkäufer/Shop anbietet.
    */
   Set<Beverage> getBeveragesOfAllVendingMachines();

   /**
    * Zählt die Anzahl aller Beverages die angeboten werden. Sollten mehrere
    * Automaten das gleiche Getränk anbieten, so wird jedes gezählt.<br>
    * Beispiel:
    * <pre>
    *    Automat1: "Coca Cola", "Limo", "Königsbacher"
    *    Automat2: "Lift", "Orangina", "Lipton Eis-Tee", "Coca-Cola"
    *    Anzahl Getränke: 7
    * </pre>
    */
   long countNumberOfBeveragesOfAllVendingMachines();

   /**
    * Zählt die Anzahl aller Beverages die angeboten werden. Sollten mehrere
    * Automaten das gleiche Getränk anbieten, so wird nur eins gezählt.
    * Beispiel:
    * <pre>
    *    Automat1: "Coca Cola", "Limo", "Königsbacher"
    *    Automat2: "Lift", "Orangina", "Lipton Eis-Tee", "Coca-Cola"
    *    Anzahl Getränke: 6
    * </pre>
    */
   long countNumberOfBeveragesDistinctOfAllVendingMachines();

   /**
    * Liefert den Getränkeautomaten zurück, der die meisten Getränke hat.
    * Beispiel:
    * <pre>
    *    Automat1: "Coca Cola", "Limo", "Königsbacher"
    *    Automat2: "Lift", "Orangina", "Lipton Eis-Tee", "Coca-Cola"
    *    Return: Automat2
    * </pre>
    */
   VendingMachine getVendingMachineWithTheMostBeverages();

   /**
    * Liefert für alle Getränkeautomaten, das erste Getränk zurück, dass nicht alkoholisch ist und den günstigsten Preis hat.<br>
    * Beispiel:
    * <pre>
    *    Automat1: "Coca Cola, 1.5€", "Limo, 1.25€", "Königsbacher (alkoholisch), 0.99€"
    *    Automat2: "Lipton Eis-Tee, 1.35€", "Coca Cola, 1,65€"
    *    Return: "Limo, 1.25€"
    * </pre>
    *
    * @return günstigstes nicht alkoholisches Getränk
    * @throws java.util.NoSuchElementException wird geworfen, falls kein entsprechendes Getränk gefunden werden konnte.
    */
   Beverage findTheCheapestNonAlcoholicBeverage();
}
