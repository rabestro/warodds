function btnCalculate() {
  const sheet = SpreadsheetApp.getActiveSpreadsheet();
  sheet.getRangeByName('AttackerResults').clearContent();
  sheet.getRangeByName('DefenderResults').clearContent();
  
  const attacker = sheet.getRangeByName('AttackerArmy').getValues();
  const defender = sheet.getRangeByName('DefenderArmy').getValues();
  const simulations = sheet.getRangeByName('Simulations').getValues()[0][0];
  
  const attackerArmy = attacker[0].filter(isCorrectStrength);
  const defenderArmy = defender[0].concat(defender[1], defender[2],defender[3]).filter(isCorrectStrength);

  const statistics = collectStatistics(attackerArmy, defenderArmy, simulations);
  
  sheet.getRangeByName('AttackerResults').setValues(
    [statistics.attacker.map(replaceZero)]);
  
  sheet.getRangeByName('DefenderResults').setValues(
    [statistics.defender.slice(0,8).map(replaceZero),
     statistics.defender.slice(8,16).map(replaceZero),
     statistics.defender.slice(16,24).map(replaceZero),
     statistics.defender.slice(24).map(replaceZero)]);
}

function btnClear() {
  const sheet = SpreadsheetApp.getActiveSpreadsheet();
  sheet.getRangeByName('AttackerArmy').clearContent();
  sheet.getRangeByName('DefenderArmy').clearContent();
  sheet.getRangeByName('AttackerResults').clearContent();
  sheet.getRangeByName('DefenderResults').clearContent();
}

function isCorrectStrength(strength) {
  return strength > 0 && strength <= 9;
}

function replaceZero(percent) {
  return percent == 0 ? '': percent;
}
