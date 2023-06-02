# Project
#### TL;DR version - 2D top-down walking sim in terminal

Simple top-down game where you walk around.

## Planning
skapa en 18x5 karaktärs karta i 'map.txt'. | check

Lägg till en readFile, readMap, readMovementMap, placePlayer, drawRoom, update och swapCharachterBetweenStrings metoder och funktioner. | check

Lägg till grid-baserat movement på x- och y axeln. | check

## Log
#### 2023-05-09
Added a charachter swap function for swaping two charachters between both seperate strings, aswell as within the same string.

#### 2023-05-30
Added a readMovementMap for checking which positions the player can walk to, this is accomplished by creating a copy of our currentRoom Arraylist but swapping out all the characters within the Strings to either a 1 or 0, 1's for walkable spaces and 0's for unwalkabple spaces.

#### 2023-05-31
Added functionality where we check our movementMap if we can walk to a specific 

# Post Mortem
Linus Lundqvist - 02-06-2023 

## Inledning
### Syfte
Syftet med projektet var att plannera in en tidsmal för projektet, bestämma vad projektet skall faktiskt vara och sedan arbeta och färdigställa projektet.

### Arbetssätt
Det arbetssätt som jag följt utöver projektetsgång har varit enligt det följande:

- Först bestämma vad projektet skall faktiskt vara, utöver detta bestämma de grundläggande funktioner och metoder som lär behövas för att skapa de mer formgivande funktionerna och metoderna.
- Arbeta med dessa funktioner och metoder och färdigställa dom.
- profit$$$

### Genomförande
Se Genomförande under Bakgrunden.

## Bakgrund
### Plannering
Först och främst gav jag migsjälv en tidsmal på två lektioner på att bestämma mig på vad mitt projekt skulle vara för någonting, var det jag eventuellt landande på var någonting spel-liknande.

Utöver detta så påbörjade jag en punktlista på de grundläggande funktioner och metoder som projektet lär behöva.

### Idé
Den idé som jag landade på var att göra någonting spel-liknande i terminalen, där man kan styra en spelar karaktär i form av en karaktär i en sträng genom att skriva in kommandon i termianlen som sedan läses av av programmet.

Inom spel-termer så skulle detta kallas för ett 2D top-down walking sim.

### Genomförande
Projektet började med att jag började arbeta på de grundläggande funktioner och metoder som projektet lär behöva, dessa inkluderar: 

- readFile, läser in våran 'map.txt' fil i en Arraylist.
- readMap, läser in det nuvarande rummet i Arraylist'en 'currentRoom'.
- readMovementMap, läser av vårat nuvarande rum och bestämmer om vi kan befinna oss på olika positioner eller inte.
- placePlayer, placerar våran 'Player' i vårat nuvarande rum.
- drawRoom, skriver ur vårat nuvarande rum i terminalen.
- swapCharachterBetweenStrings, byet plats på två karaktärer inom antingen två olika eller en och den samme sträng.

Med dessa grundläggande funktioner klara, så övergår vi till det som kräver dessa grundläggande funktioner för att fungera. t.ex:
- update, utförs om och om igen där den begär ett kommando som input, sedan utför det kommandot och skriver ut förändringen i rumet.

Med allt detta klart så har vi nu ett fungerande program där vi kan röra oss inom ett 2D plan.

## Erfarenheter
### Positiva
- Projektet var både roligt och givande när det kom till problemlösning, att förstå sig på vad man ska göra och hur man sedan kommer fram till lösningar på problem.

### Negativa 
- Har inget negativt och säga om projektet.
- Rooten ur 34 är ej 69.

## Sammanfattning
I överlag så gick projektet relativt smort, inga större problem utanför problemlösningen inom programmering generellt, med detta så har vi ju då också erfarenheterna med problemlösning.

Utöver själva slutprodukten så finns det saker som skulle kunna förbättras och utvecklas, inom förbättring så kan koden i överlag förbättras och förmodligen simplifieras något extremt. Inom utveckling så finns det gott med rum för att iterera och expandera på projektet.
