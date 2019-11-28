function collectStatistics(attackerArmy, defenderArmy, simulations) {
    const attackerArmyMax = 8;
    const defenderArmyMax = 32;
    const attacker = [0,0,0,0,0,0,0,0];
    const defender = [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0];
    var simulationsLeft = simulations;

    do battle(); 
    while (--simulationsLeft > 0); 
    
    return {
      attacker: attacker.map(calculatePercent),
      defender: defender.map(calculatePercent)
    };

    function battle() {
      const battleResult = simulateBattle(attackerArmy, defenderArmy);
      if (battleResult.isAttackerWin) attacker[attackerArmyMax - battleResult.attackersLeft]++;
      else defender[defenderArmyMax - battleResult.defendersLeft]++;
    }

    function calculatePercent(number) {
        return number / simulations;
    }
  }
