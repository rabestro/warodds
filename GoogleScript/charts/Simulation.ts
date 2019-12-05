function getRandomTen() {
  return 1 + Math.floor(Math.random() * 10);
}

function isAttackerWin(attackStrength, defenseStrength) {
  var attackerHits = 2, defenseHits = 2;
  var attackerResult, defenderResult;
  
  do {
    attackerResult = getRandomTen() > defenseStrength;
    defenderResult = getRandomTen() > attackStrength;
    if (attackerResult === defenderResult) continue;
    if (attackerResult) --defenseHits; else --attackerHits;
  } while (attackerHits && defenseHits);
  
  return attackerHits > 0;
}

function percenAttackerWin(attackStrength, defenseStrength) {
  const simulations = 10000;
  var wins = 0;
  
  for (var i = simulations; i-->0;) 
    if (isAttackerWin(attackStrength, defenseStrength)) ++wins;
  
  return wins / simulations;
}