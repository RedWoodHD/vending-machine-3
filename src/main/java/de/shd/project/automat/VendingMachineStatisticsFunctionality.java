package de.shd.project.automat;

import java.util.function.BinaryOperator;


/**
 * Definiert die Funktionalität, die der Getränkeautomat besitzen soll, um Statistiken anzuzeigen.
 *
 * @author Christoph Gragert (cgr@shd.de)
 */
@SuppressWarnings("unused")
public interface VendingMachineStatisticsFunctionality
{

   /**
    * <h2>Aufgabe 21</h2>
    * Berechnet den Gesamtwert von Getränken, die sich aktuell im Getränkeautomat befinden.
    * Es wird nur der Werte der Getränke betrachtet.<br>
    * Beispiel:
    * <pre>
    *       Getränk1: Preis pro Liter: 2.50
    *                Menge im Automaten: 10 Liter
    *       Getränk2: Preis pro Liter: 1.50
    *                Menge im Automaten: 20 Liter
    *       Rechnung: 2.5 * 10 + 1.5 * 20 = 55
    * </pre>
    */
   double calculateTotalValueOfAllBeverages();

   /**
    * <h2>Aufgabe 22</h2>
    * Berechnet analog zu {@link #calculateTotalValueOfAllBeverages()} den Wert für alle alkoholischen Getränke
    */
   double calculateTotalValueOfAllAlcoholicBeverages();

   /**
    * <h2>Aufgabe 23</h2>
    * Berechnet die Durchschnittstemperatur aller Getränke. Eine Mengenverteilung spielt hier keine Rolle.<br>
    * Beispiel:
    * <pre>
    *       Getränk1: 10°C
    *       Getränk2: 20°C
    *       Rechnung: 10 + 20 / 2 = 15
    * </pre>
    */
   double calculateAverageTemperatureOfAllBeverages();

   /**
    * <h2>Aufgabe 24</h2>
    * Berechnet den durchschnittlichen Alkoholgehalt aller alkoholischen Getränke.
    * Rechnung analog zu {@link #calculateAverageTemperatureOfAllBeverages()}.
    */
   double calculateAverageAlcoholicStrengthOfAllAlcoholicBeverages();

   /**
    * <h2>Aufgabe 25</h2>
    * Liefert das Produkt über die Menge aller Getränke.<br>
    * Beispiel:
    * <pre>
    *    Getränk1: Menge 10 Liter
    *    Getränk2: Menge 20 Liter
    *    Rechnung: 10 * 20 = 200
    * </pre>
    * (<b>Hinweis</b>: Hier soll die Methode {@link java.util.stream.Stream#reduce(Object, BinaryOperator)} verwendet werden.)
    */
   double getMultipliedAmountsOfBeverages();

}
