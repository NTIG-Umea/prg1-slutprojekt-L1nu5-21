# Project
#### TL;DR version - 2D top-down walking sim in terminal

Simple top-down game where you walk around.

## Planning
Fix a simple 20x5-character map for testing in "map.txt". | fixed

Add currentRoomReader and drawRoom methods. | 

Add grid-based movement along the x- and y-axis. |

## Log

#### 2023-05-09
Added a charachter swap function for swaping two charachters within a string.

#### 2023-05-30
Added a readMovementMap for checking which positions the player can walk to, this is accomplished by creating a copy of our currentRoom Arraylist but swapping out all the characters within the Strings to either a 1 or 0, 1's for walkable spaces and 0's for unwalkabple spaces.

#### 2023-05-31
Added functionality where we check our movementMap if we can walk to a specific location or not.

## Post Mortem
Hallo, and gaboo.