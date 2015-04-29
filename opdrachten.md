Opdrachten bij Java text adventure
==================================

Deel 1
======

Opdracht 0
----------
Teken een kaart van de kamers. Kijk alleen naar de code!
Doe dit dus voordat je gaat spelen.

Opdracht 1
----------
Implementeer het command 'look'. Deze geeft opnieuw een beschrijving van de kamer (voor het geval de speler dat vergeten is).

Opdracht 2
----------
Implementeer een "Player". Een Player heeft een "currentRoom". "Game" mag alleen een "parser" en een "player" bevatten. Geen "currentRoom".

Oude situatie:

![zonder player](img/ZuulClassDiagram.png)

Nieuwe situatie:

![met player](img/ZuulClassDiagramPlayer.png)

Opdracht 3
----------
Implementeer de property 'health' in Player (denk goed na over de variabele typen!):

Implementeer de volgende methods in Player:
    damage(amount)
    heal(amount)
    isAlive()

Van welk type variabele zijn de argumenten, en van welk type zijn de returnwaarden?

Opdracht 4
----------
Elke keer als de player naar een andere kamer gaat, verliest hij/zij wat health (de speler is gewond, en verliest bloed bij het verplaatsen). Implementeer dit.

Uiteraard zorg je er voor, dat het spel is afgelopen als de speler dood is (In opdracht 8 implementeer je dat de gezonde speler daadwerkelijk gewond raakt).

Opdracht 5
----------
Implementeer "up" en "down" als uitgangen voor Rooms (als 'verdiepingen').

Deel 2
======
Als je eerder dan in de les wordt behandeld aan het volgende deel begint, implementeer dan slechts enkele items.

Opdracht 6
----------
In een Room liggen Items, die een speler (in opdracht 7) op kan pakken of interactie mee kan hebben. 
Hoe zorg je ervoor dat de speler van het spel kan zien welke Items er in de kamer liggen?

Opdracht 7
----------
Implementeer een "Inventory" voor de player. Implementeer de methods:
    take(Item someItem); 
    drop(Item someItem);
    
In een inventory kunnen "items" worden gestopt. Een Item heeft een naam, omschrijving en een gewicht. De speler kan maximaal xx kilo bij zich dragen. Zorg ervoor dat hier controle op is.

Opdracht 8
----------
Dit zou een geschikt moment zijn om de speler zich te laten bezeren aan een 'bad Item'.

Opdracht 9
----------
Inheritance/overriding: Items zijn van een bepaald type. Bijvoorbeeld: wapens, sleutels of medicijnen. Implementeer de method 'use' voor Items.

Opdracht 10
-----------
Sommige "Rooms" zijn niet toegankelijk. Wellicht heeft de speler hier een sleutel voor nodig, of wordt de Room bewaakt door een guard, die de speler moet bevechten. Implementeer dit.

Opdracht 11
-----------
Wat kan er allemaal nog meer in jouw versie van de textadventure?

