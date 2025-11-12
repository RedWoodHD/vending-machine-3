package de.shd.project.automat;

import de.shd.project.beverage.InsufficientBeverageException;

/**
 * Definiert die Funktionalität, die der Getränkeautomat besitzen soll, um Getränke verkaufen zu können.
 *
 * @author Christoph Gragert (cgr@shd.de)
 */
@SuppressWarnings("unused")
public interface VendingMachineSalesFunctionality
{
   /**
    * <h2>Aufgabe 11</h2>
    * Es wird für den übergebenen Getränkenamen der Preis berechnet.
    * Der Inhalt des Getränks im Getränkeautomat darf sich dabei NICHT ändern.
    * <p>
    * Der Preis für eine Flasche berechnet sich auf dem Basispreis der Flasche und dem Preis für die Menge des Getränks, welches sich
    * in der Flasche befindet.<br>
    * Beispiel:
    * <pre>
    *       Flasche: Basispreis: 0.25
    *                Menge in der Flasche: 0.5 Liter
    *       Getränk: Preis pro Liter: 2.50
    *       Rechnung: 0.25 + 0.5 * 2.5 = 1.5
    *    </pre>
    * </p>
    *
    * @param name Name
    * @return Preis für eine Flasche des Getränks
    */
   double calculatePriceForOneBottleOf(final String name);

   /**
    * <h2>Aufgabe 12</h2>
    * Für den übergebenen Namen und das Geld soll ein Getränk gekauft werden.
    * Der Vorrat im Getränkeautomat verringert sich um den Inhalt der Flasche.
    *
    * @param name  Name des Getränks (Muss analog zu {@link VendingMachineFilterOneFunctionality#findBeverage(String)} nicht
    *              vollständig sein)
    * @param money Betrag der für das Getränk bezahlt wird.
    * @return ein {@link VendingMachinePurchase} in dem die gekaufte Flasche und das Restgeld
    * enthalten ist.
    * @throws InsufficientBeverageException Wird geworfen, falls nicht mehr genug vom
    *                                       Getränk vorhanden ist.
    * @throws VendingMachineException       Wird geworfen, falls für den Namen kein
    *                                       Getränk gefunden werden konnte
    *                                       oder das Geld nicht ausreichend ist.
    *                                       Der Inhalt des Getränkeautomats darf sich
    *                                       in den Fällen nicht ändern.
    */
   VendingMachinePurchase buyBeverage(final String name, final double money);

   /**
    * <h2>Aufgabe 13</h2>
    * Berechnet den Preis für eine beliebige Anzahl von Flaschen eines Getränks
    *
    * @param name            Name des Getränks (siehe {@link VendingMachineFilterOneFunctionality#findBeverage(String)})
    * @param numberOfBottles Anzahl der Flaschen
    * @return Preis eines Getränks für die angegebene Anzahl von Flaschen
    */
   double calculatePriceForBottlesOf(final String name, final int numberOfBottles);

}
