package com.urbeto.warodds;
import java.util.Arrays;

class WarCalc {
    private final static int MAX_ATTACKER_ARMY = 8;
    private final static int MAX_DEFENDER_ARMY = MAX_ATTACKER_ARMY * 4;
    private final static int HITS = 2;
    private final static int ATTACKER_STATS = MAX_ATTACKER_ARMY * HITS + 1;
    private final static int DEFENDER_STATS = MAX_DEFENDER_ARMY * HITS + 1;
    private final static int STATS = ATTACKER_STATS + DEFENDER_STATS;
    private final double [][] cache = new double [ATTACKER_STATS * DEFENDER_STATS][];

    private double [] statistics;
    private final int[] attArmy;
    private final int[] defArmy;

    private WarCalc(String defender, String attacker) {
        if (defender.length() > MAX_DEFENDER_ARMY ) throw new IllegalArgumentException("Defender army is too big!");
        if (attacker.length() > MAX_ATTACKER_ARMY ) throw new IllegalArgumentException("Attacker army is too big!");

        defArmy = stringToArray(defender);
        attArmy = stringToArray(attacker);
        statistics = calculateStatistics(1, defender.length() * 2, attacker.length() * 2);
    }

    private int [] stringToArray(String str) {
        int [] army = new int[str.length()];
        for (int i = str.length(); i-->0; ) {
            char symbol = str.charAt(i);
            if (symbol >= '0' && symbol <= '9') army[i] = symbol - '0';
            else throw new IllegalArgumentException("Only digits allowed!");
        }
        return army;
    }

    private double[] calculateStatistics(double probability, int defState, int attState) {
        final int key = defState + DEFENDER_STATS * attState;
        final boolean isBattleOver = defState == 0 || attState == 0;

        if (isBattleOver) {
            if (cache[key] == null) {
                cache[key] = new double[STATS];
                cache[key][attState + DEFENDER_STATS] = cache[key][defState] = probability;
            }
            return cache[key];
        }

        if (cache[key] == null) {
            final double pA = calculateAttackerWinProbability(defState, attState);
            final double pD = 1 - pA;
            final double[] attStats = calculateStatistics(pA, defState - 1, attState);
            final double[] defStats = calculateStatistics(pD, defState, attState - 1);
            cache[key] = new double[STATS];
            for (int i = STATS; i-->0;) cache[key][i] = attStats[i] + defStats[i];
        }

        double[] result = new double[STATS];
        for (int i = STATS; i-->0; ) result[i] = cache[key][i] * probability;

        return result;
    }

    private double calculateAttackerWinProbability(int defState, int attState) {
        final double defStrength = defArmy[(defState - 1) / 2];
        final double attStrength = attArmy[(attState - 1) / 2];
        final double Pa = attStrength * (10 - defStrength) / 100;
        final double Pd = defStrength * (10 - attStrength) / 100;
        return Pa / (Pa + Pd);
    }

    double attackerWinProbability() {
        return 1 - statistics[DEFENDER_STATS];
    }

    double attackerWinPercent() {
        return 100 * attackerWinProbability();
    }

    double defenderWinProbability() {
        return 1-statistics[0];
    }

    double defenderWinPercent() {
        return 100 * defenderWinProbability();
    }

    private void printStatistics() {
        System.out.printf("Defender Army: %s%n", Arrays.toString(defArmy));
        System.out.printf("Attacker Army: %s%n", Arrays.toString(attArmy));
        System.out.printf(
                "%nAttacker win: %6.2f%%%nDefender win: %6.2f%%%n"
                , attackerWinPercent(), defenderWinPercent());
    }
    public static void main(String[] args) {
        if (args.length == 2) {
            WarCalc testBattle = new WarCalc(args[0], args[1]);
            testBattle.printStatistics();
        } else {
            System.out.println("Usage: WarCalc <Defender Army> <Attacker Army>");
            System.out.println("   Example: WarCalc 9888 9976");
        }
    }
}
