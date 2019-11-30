import java.util.Arrays;

class Battle {
	final static int MAX_ATTACKER_ARMY = 8;
	final static int MAX_DEFENDER_ARMY = 8 * 4;
	
	double[] attStats = new double[17];
	double[] defStats = new double[65];
	int[] attArmy = new int[MAX_ATTACKER_ARMY];
	int[] defArmy = new int[MAX_DEFENDER_ARMY];
	int attState;
	int defState;
	int level = 0;
	int count = 0;
	int maxLevel = 0;
	
	String attacker;
	String defender;
	
	Battle(String defender, String attacker) {
		System.out.printf("Defender: %s%nAttacker: %s%n", defender, attacker);
		this.defender = defender;
		this.attacker = attacker;
		attState = attacker.length() * 2;
		defState = defender.length() * 2;
		
		stringToArray(defender, defArmy);
		stringToArray(attacker, attArmy);
		
		calculateStatistics(1, defState, attState);
		
	}
	
	void stringToArray(String str, int[] arr) {
		for (int i = str.length(); i-->0; ) arr[i] = str.charAt(i) - '0';
	}
	
	void calculateStatistics(double probability, int defState, int attState) {
		if (++level > maxLevel) maxLevel = level;
		++count;
		// System.out.printf("%4d%6d%8.2f%% (%d, %d)%n", level, count, probability, defState, attState);
		
		if (defState == 0 || attState == 0) {
		    defStats[defState] += probability;
		    attStats[attState] += probability;
		} else {
		    final double pA = attackerWinProbability(defState, attState);
		    final double pD = 1 - pA;
		    calculateStatistics(probability * pA, defState - 1, attState);
		    calculateStatistics(probability * pD, defState, attState - 1);
		}
		--level;
		return;
	}
	
	double attackerWinProbability(int defState, int attState) {
		final double defenseStrength = defArmy[(defState-1)/ 2];
		final double attackStrength = attArmy[(attState-1) / 2];
		final double Pa = attackStrength * (10 - defenseStrength) / 100;
    	final double Pd = defenseStrength * (10 - attackStrength) / 100;
    	return Pa/(Pa+Pd);
	}
	
	void printStatistics() {
		// System.out.printf("Defender: %s%nAttacker: %s%n", Arrays.toString(defArmy),Arrays.toString(attArmy));
		// System.out.printf("defStats: %s%n", Arrays.toString(defStats));
		// System.out.printf("attStats: %s%n", Arrays.toString(attStats));
		
		System.out.printf("%nMaximum level: %d%nCalculation count: %,d%n%n", maxLevel, count);
		System.out.printf("Attacker win: %6.2f%%%nDefender win: %6.2f%%%n", (1-attStats[0])*100, 100*(1-defStats[0]));
	}
}

public class Calculation
{
	public static void main(String[] args) {
    
		Battle testBattle = new Battle("98776666", "99988887");
		testBattle.printStatistics();
	}
}