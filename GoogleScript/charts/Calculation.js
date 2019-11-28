function attackerWinProbability(attackStrength, defenseStrength) {
  const Pa = attackStrength * (10 - defenseStrength) / 100;
  const Pd = defenseStrength * (10 - attackStrength) / 100;
  const Q = Pa + Pd;
  return (Pa/Q)*(Pa/Q) * (1 + 2*Pd/Q);
}
