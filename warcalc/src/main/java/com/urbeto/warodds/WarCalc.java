package com.urbeto.warodds;

import static java.util.stream.IntStream.range;

public class WarCalc {
    private final static int MAX_ATTACKER_ARMY = 8;
    private final static int MAX_DEFENDER_ARMY = MAX_ATTACKER_ARMY * 4;
    private final static int HITS = 2;
    private final static int ATTACKER_STATS = MAX_ATTACKER_ARMY * HITS + 1;
    private final static int DEFENDER_STATS = MAX_DEFENDER_ARMY * HITS + 1;
    private final static int STATS = ATTACKER_STATS + DEFENDER_STATS;
    private final double [][] cache = new double [ATTACKER_STATS * DEFENDER_STATS][];

    private final double [] statistics;
    private final int[] attArmy;
    private final int[] defArmy;

    WarCalc(String defender, String attacker) {
        if (defender.length() > MAX_DEFENDER_ARMY ) throw new IllegalArgumentException("Defender army is too big!");
        if (attacker.length() > MAX_ATTACKER_ARMY ) throw new IllegalArgumentException("Attacker army is too big!");

        defArmy = stringToArray(defender);
        attArmy = stringToArray(attacker);
        statistics = calculateStatistics(1, defender.length() * 2, attacker.length() * 2);
    }

    private int [] stringToArray(String str) {
        return str.chars().map(i -> i - '0').toArray();
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

            cache[key] = range(0, STATS).mapToDouble(i -> attStats[i] + defStats[i]).toArray();
        }
        return range(0, STATS).mapToDouble(i -> cache[key][i] * probability).toArray();
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

    public static void main(String[] args) {
        if (args.length == 2) {
            WarCalc testBattle = new WarCalc(args[0], args[1]);
            testBattle.printStatistics();
        } else {
            System.out.println("Usage: WarCalc <Defender Army> <Attacker Army>");
            System.out.println("   Example: WarCalc 9888 9976");
        }
    }

    void printDefenderStatistics() {
        System.out.printf("%n Defender win: %7.2f%%%n", defenderWinPercent());
        StringBuilder header = new StringBuilder(" [ lose ] ");
        StringBuilder data = new StringBuilder(String.format("%7.2f%%", statistics[0] * 100));
        for (int i = 0; i < defArmy.length; ++i) {
            if (i > 0 && i % 8 == 0 ) {
                System.out.println(header);
                System.out.println(data);
                header = new StringBuilder("\n          ");
                data =   new StringBuilder("        ");
            }
            header.append(String.format(" [%02d:%2d] ", i + 1, defArmy[i]));
            final double probability = statistics[i * 2 + 1] + statistics[i * 2 + 2];
            data.append(String.format("%8.2f%%", probability * 100));
        }
        System.out.println(header);
        System.out.println(data);
    }

    void printAttackerStatistics() {
        System.out.printf("%n Attacker win: %7.2f%%%n", attackerWinPercent());
        StringBuilder header = new StringBuilder(" [ lose ] ");
        StringBuilder data = new StringBuilder(String.format("%7.2f%%", statistics[DEFENDER_STATS] * 100));
        for (int i = 0; i < attArmy.length; ++i) {
            header.append(String.format(" [%02d:%2d] ", i + 1, attArmy[i]));
            double probability
                    = statistics[DEFENDER_STATS + i * 2 + 1]
                    + statistics[DEFENDER_STATS + i * 2 + 2];
            data.append(String.format("%8.2f%%", probability * 100));
        }
        System.out.println(header);
        System.out.println(data);
    }

    void printStatistics() {
        printDefenderStatistics();
        printAttackerStatistics();
    }
}