# Java Chess!

**Welcome to Java Chess!**

***Setting players:***
	
		- Player one is on whites
		- Player two is on blacks

***Rules:***
	
		- Player one always has the first turn
		- Game continues until:
			- A player forfeits
			- A king is taken

***Instructions:***

		*Moving a piece:*

			1) "<playerName>, what piece would you like to move?: " -> Select what piece to move. E.g.: Pawn (case insensitive)
			2) "From?: " -> Select starting location. E.g.: A2 (case insensitive)
			3) "To?:  " -> Select next location. E.g.: A3 (case insensitive)

		*Forfeiting:*
			- Players can decide to forfeit at any point in the game. However, cannot do so until after picking a piece to move.
			- To forfeit, simply type "ff" into the console (case insensitive)

***Exceptions:***

		- **InvalidMoveException** (*Not a legal move!*) --> thrown when an invalid move is keyed in
		- **PieceLoaderException** (*Cannot find piece!*) -->  thrown when the wrong piece name is typed or a piece is not found at certain location.

***Notes:***

		- If an exception is thrown but cannot be seen on screen, scroll up
		
***Further work/functionality:***

		- *Castling*
		- *Pawn promotion*
