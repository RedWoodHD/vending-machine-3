# Aufgaben

## Aufgabe 1

Die Klasse VendingMachine soll verschiedene Interfaces implementieren. Verwende Streams und Optionals um die Methoden zu
implementieren. Die Funktionalität der Methoden ist im jeweiligen Javadoc definiert. Die Methoden müssen am Ende wie beschrieben funktionieren. Viele
Methoden lassen sich mithilfe eines einzigen Streams implementieren, d.h. aber nicht, dass dies für alle Methoden gilt.

### a) VendingMachineDisplayFunctionality
### b) VendingMachineFilterOneFunctionality
### c) VendingMachineSalesFunctionality

## Aufgabe 2

Erstellt 5 Arten von Getränken (bspw. Softdrink, Beer, etc.). Mindestens ein Getränk soll alkoholisch, eins nicht alkoholisch, eins soll
koffeinhaltig und eins soll sowohl alkoholisch als auch koffeinhaltig sein. Ihr müsst hierzu von Beverage ableiten und die Methode createPortion()
implementieren.

## Aufgabe 3

Implementiere einen BeverageSupplier, der, dem Automat für jede Getränkeart, jeweils 2 unterschiedliche Getränke (d.h. verschiedene Namen)
bereitstellt. Das Set an Getränken in der VendingMachine soll am Ende 10 Elemente haben.

## Aufgabe 4

Erstellt eine Main-Klasse mit einer main-Methode. In dieser soll eine VendingMachine erzeugt werden. Füge der VendingMachine deinen BeverageSupplier
hinzu. Führe die Methode aus, um den Automaten zu befüllen. Überlege dir entsprechende Testcases und teste deine Logiken aus 1 b).