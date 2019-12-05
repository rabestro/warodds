export default function calculateBattle(defArmy, attArmy) {
  const MAX_ATTACKER_ARMY = 8;
  const MAX_DEFENDER_ARMY = MAX_ATTACKER_ARMY * 4;
  const HITS = 2;
  const ATTACKER_STATS = MAX_ATTACKER_ARMY * HITS + 1;
  const DEFENDER_STATS = MAX_DEFENDER_ARMY * HITS + 1;
  const STATS = ATTACKER_STATS + DEFENDER_STATS;
  const cache = new Array(ATTACKER_STATS * DEFENDER_STATS);

  const statistics = calculateStatistics(1, defArmy.length * 2, attArmy.length * 2);
  return statistics;

  function calculateStatistics(probability, defState, attState) {
    const key = defState + DEFENDER_STATS * attState;
    const isBattleOver = defState == 0 || attState == 0;

    if (isBattleOver) {
      if (cache[key] === undefined) {
          cache[key] = new Array(STATS).fill(0);
          cache[key][attState + DEFENDER_STATS] = cache[key][defState] = probability;
      }
      return cache[key];
    }
    if (cache[key] === undefined) {
        const pA = attackerWinProbability(defState, attState);
        const pD = 1 - pA;
        const attStats = calculateStatistics(pA, defState - 1, attState);
        const defStats = calculateStatistics(pD, defState, attState - 1);
        cache[key] = new Array(STATS);
        for (let i = STATS; i-->0;) cache[key][i] = attStats[i] + defStats[i];
    }
    const result = new Array(STATS);
    for (let i = STATS; i-->0;) result[i] = cache[key][i] * probability;

  return result;
  }

  function attackerWinProbability(defState, attState) {
    const defStrength = defArmy[Math.floor((defState - 1) / 2)];
    const attStrength = attArmy[Math.floor((attState - 1) / 2)];
    const Pa = attStrength * (10 - defStrength) / 100;
    const Pd = defStrength * (10 - attStrength) / 100;
    return Pa / (Pa + Pd);
  }
}
