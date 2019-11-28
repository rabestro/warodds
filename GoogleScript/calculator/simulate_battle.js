function simulateBattle(attacker, defender) {
  const attackerArmy = attacker.slice();
  const defenderArmy = defender.slice();
  var hasAttackerHealth = true;
  var hasDefenderHealth = true;
  
  while (isNoWinnerYet()) fight();

  return {
    isAttackerWin: attackerArmy.length > 0,
    attackersLeft: attackerArmy.length,
    defendersLeft: defenderArmy.length
  };

  function isNoWinnerYet() { 
    return defenderArmy.length > 0 && attackerArmy.length > 0 
  };
  
  function fight() {
    const isAttackerWin = simulateRound(attackerArmy[0], defenderArmy[0]);
    if (isAttackerWin) hitDefender(); else hitAttacker();
  }
  
  function hitAttacker() {
    if (!hasAttackerHealth) attackerArmy.shift();
    hasAttackerHealth = !hasAttackerHealth;
  }
  
  function hitDefender() {
    if (!hasDefenderHealth) defenderArmy.shift();
    hasDefenderHealth = !hasDefenderHealth;
  }
  
  function simulateRound(attackStrength, defenseStrength) {
    const Pa = attackStrength * (10 - defenseStrength) / 100;
    const Pd = defenseStrength * (10 - attackStrength) / 100;
    return Math.random() < Pa/(Pa+Pd);
  }
}