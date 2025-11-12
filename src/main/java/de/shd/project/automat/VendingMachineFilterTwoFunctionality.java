package de.shd.project.automat;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import de.shd.project.beverage.Beverage;

/**
 * Definiert die Funktionalität, die der Getränkeautomat besitzen soll, um das Angebot zu filtern. (Teil 2/2)
 *
 * @author Christoph Gragert (cgr@shd.de)
 */
@SuppressWarnings("unused")
public interface VendingMachineFilterTwoFunctionality
{

   /**
    * <h2>Aufgabe 14</h2>
    * Liefert eine Map zurück, die alle Getränke nach ihrer Klasse gruppiert.
    * <h3>Tipp</h3>
    * Recherchiert, welche Methode aus {@link java.util.stream.Collectors} euch Datensätz gruppieren lässt.
    */
   Map<Class<? extends Beverage>, List<Beverage>> getBeveragesGroupedByClass();

   /**
    * <h2>Aufgabe 15</h2>
    * Liefert eine Liste aller Getränke, deren Inhalt im Getränkeautomat unter der übergebenen
    * Grenze liegt.<br>
    * Beispiel:
    * <pre>
    *       Getränk1: Restmenge 1 Liter
    *       Getränk2: Restmenge 3 Liter
    *       Grenze: 3 Liter
    *       Return: List.of(Getränk1)
    * </pre>
    *
    * @param threshold Grenze unter, der der Inhalt der Getränke liegen soll
    */
   List<Beverage> getAllBeveragesWithAmountBelowThreshold(int threshold);

   /**
    * <h2>Aufgabe 16</h2>
    * Liefert eine Map zurück, die dem Namen eines Getränks immer das Getränk selbst zuordnet. D.h. der Key der Map ist der Name des Getränks. Der
    * Value der Map ist das Getränk selbst.
    */
   Map<String, Beverage> getAllBeveragesMappedByName();

   /**
    * <h2>Aufgabe 17</h2>
    * Liefert eine Liste von Getränken für den übergebenen Filter zurück.
    *
    * @param filter Filter
    */
   List<Beverage> getListByFilter(final Predicate<Beverage> filter);

   /**
    * <h2>Aufgabe 18</h2>
    * Liefert eine Liste mit allen Füllständen zurück. Die Füllstände soll eindeutig sein, d.h. es dürfen keine doppelten Einträge in der Liste
    * vorkommen.
    * <h3>Tipp</h3>
    * Recherchiert, welche Methode aus {@link java.util.stream.Stream} euch dabei hilft, die doppelten Einträge zu entfernen.
    */
   List<Double> getListOfCurrentAmountsOfBeverages();

   /**
    * <h2>Aufgabe 19</h2>
    * Liefert eine Liste aller Getränke zurück, die sich eine Person für das übergebene Budget leisten kann. Die Liste von Getränken soll vom
    * günstigsten zum teuersten sortiert sein. Eine Person kann sich ein Getränk leisten, wenn sie am Automat eine Flasche des entsprechenden
    * Getränks kaufen kann. Hier spielt es keine Rolle, welche Menge des entsprechenden Getränks im Automat vorhanden ist.
    *
    * @param budget Budget des Käufers
    */
   List<Beverage> findAllAffordableBeverages(final double budget);

   /**
    * <h2>Aufgabe 20</h2>
    * Liefert die 5 Getränke mit dem geringsten Inhalt sortiert nach dem Inhalt absteigend zurück.<br>
    * Beispiel:
    * <pre>
    *    Getränk1: Menge 1 Liter
    *    Getränk2: Menge 5 Liter
    *    Getränk3: Menge 25 Liter
    *    Getränk4: Menge 17 Liter
    *    Getränk5: Menge 2 Liter
    *    Getränk6: Menge 9 Liter
    *    Getränk7: Menge 18 Liter
    *
    *    Ausgabe: [Getränk4, Getränk6, Getränk2, Getränk5, Getränk1]
    * </pre>
    */
   List<Beverage> getTopFiveBeveragesWithTheLeastAmountOrderedByAmountDescending();
}
