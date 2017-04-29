/*
 * Remember that this is just an exercise. 
 * Typically, when considering good design, you rarely have "void" methods.
 */
 
// You are free to use any kind of data structure to represent the state of the board
interface Conway {
	/**
	 * Move to the next state of the board
	 * Eg:
	 * If the current state is:
	 * 00000
	 * 00000
	 * 01110
	 * 00000
	 * 00000
	 *
	 * then the next state should be:
	 * 00000
	 * 00100
	 * 00100
	 * 00100
	 * 00000
	 * 
	 * This is the blinker oscillator from the Wiki page.
	 */
	void nextState();
	
	/**
	  Prints out the current state of the board to the console
	 */
	void printState();
}