package de.shd.project.automat;

import java.util.List;
import java.util.Set;

import de.shd.project.beverage.Alcoholic;

/**
 * Definiert die Funktionalität, die der Getränkeautomat besitzen soll, um Informationen über seinen Inhalt anzeigen zu können.
 *
 * @author Christoph Gragert (cgr@shd.de)
 */
@SuppressWarnings("unused")
public interface VendingMachineDisplayFunctionality
{
   /**
    * <h2>Aufgabe 1</h2>
    * Liefert eine Liste der Namen aller Getränke als Liste zurück, die im Getränkeautomat vorhanden sind. Es spielt hier keine Rolle, welche Menge
    * von dem Getränk im Automat vorhanden ist.
    */
   List<String> displayNamesOfAllBeverages();

   /**
    * <h2>Aufgabe 2</h2>
    * Liefert ein Set von Namen aller alkoholischen Getränke zurück. Es spielt keine Rolle welche Menge oder welchen Alkoholgehalt das Getränk hat.
    * Ein Getränk, welches das Interface {@link Alcoholic} implementiert, aber einen Alkoholgehalt von {@code <=0} hat, ist als alkoholisch zu betrachten.
    * <h3>Tipp</h3>
    * Um festzustellen, ob ein Objekt von einem bestimmten Typ ist, kann das Keyword "instanceof" verwendet werden.
    */
   Set<String> displayNamesOfAllAlcoholicBeverages();

   /**
    * <h2>Aufgabe 3</h2>
    * Liefert eine Liste von Namen aller nicht-alkoholischen Getränke zurück. Hier gilt: Ein Getränk ist nicht-alkoholisch, wenn es
    * {@link Alcoholic} nicht implementiert. Der Rückgabewert von {@link Alcoholic#getAlcoholStrength()} spielt hier keine Rolle.
    * <h3>Tipp</h3>
    * Um festzustellen, ob ein Objekt von einem bestimmten Typ ist, kann das Keyword "instanceof" verwendet werden.
    */
   List<String> displayNamesOfAllNonAlcoholicBeverages();

   /**
    * <h2>Aufgabe 4</h2>
    * Liefert einen String zurück der alle Namen von Getränken kommasepariert ausgibt.
    * Ist das Getränk alkoholisch, so soll zusätzlich zum Namen noch "alkoholisch" in
    * Klammen ausgegeben werden. Vor dem ersten und nach dem letzten Element der Auflistung steht KEIN Komma! Nach jedem Komma soll zur besseren
    * Lesbarkeit ein Leerzeichen sein.
    * <pre>
    *    Beispiel: Coca Cola, Königsbacher (alkoholisch), Espresso (koffeinhaltig), ...
    * </pre>
    * <h3>Tipp</h3>
    * Um festzustellen, ob ein Objekt von einem bestimmten Typ ist, kann das Keyword "instanceof" verwendet werden.
    */
   String displayAllBeverageNamesSeparatedByComma();
}
