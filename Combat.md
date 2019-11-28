# Combat
To attack an enemy stack, a city or a tower, tap on your stack and then tap on the stack or structure you want to attack. Instead of the feet symbol you normally see for movement, you will see a "crossed swords" symbol instead. Hit the Move button and your stack will move next to the defending stack (assuming you have enough movement, of course) and then stop, giving you a last chance to change your mind about the attack. If you are still sure about attacking, tap the Move button again (or tap the swords symbol) and the attack will be begin. NOTE: it takes 2 movement points to attack into any square, regardless of normal terrain movement cost. Example - a light infantry can attack into forest for a movement cost of 2, even though the normal movement cost is 4. TIP: You don't have to attack with all of the units in a stack. Go to the Stack Panel and unselect any units you do not wish to be part of the attack.

The Combat screen will appear with 2 rows of units, the defending units in the top row and the attacking units in the bottom row. Combat begins with the leftmost unit in each row and goes in rounds. The defeated unit "pops" and disappears, ending that round. The winning unit battles the next unit in the enemy's row. This continues automatically until all units of the attacking or defending army have been eliminated. If the winning army is the attacker, then the army moves into the late defender's square and can continue moving if the stack has movement points left. NOTE: Units can attack more than once per turn if they have enough movement points left to do so.

## Combat Mechanics
An Attacking Force Combat Modifier (AFCM) is calculated. Five factors are evaluated when calculating the AFCM:

- Hero Present. If the hero's strength is 1 to 6, the modifier is 1. If the hero's strength is 7 or 8, the modifier is 2. If the hero's strength is 9, the modifier is 3. NOTE: If multiple heroes present, the one with the largest battle + command bonus is used to calculate AFCM.
- Flying Army Present. If a Pegasus, Griffin or Dragon is present, the modifier is 1.
- Special Army Present. If a Wizard, Undead, Demon, Devil or Dragon is present, the modifier is 1.
- Command Item (Artifact) Present. If a hero (or heroes) with command item(s) are present, the value of the command item(s) is added. For example, the Crimson Banner has a command value of 2.
- Terrain Modifier. Troops from the different Empires have their likes and dislikes in regard to where they prefer to fight. For example, the Elvallie like forests but don't much care for hills or marsh. The Selelntines are the masters of naval combats.

These modifiers, if any, are added together. Once calculated, the AFCM is set aside for use later in the combat routine.

A Defending Force Combat Modifier (DFCM) is calculated. Eight factors are evaluated when calculating the DFCM.

Same five factors as AFCM plus…
- Tower Present. If a tower is present, the modifier is 2. If tower is razed, the modifier is 1.
- Special Terrain Present. If the battle occurs in a temple, tomb, dungeon or ruin, the modifier is 1.
- City Present. If the battle occurs in a city, the city defense modifiers added. The modifier is 1 if the defense value is 1 - 6. The modifier is 2 if the defense value is 7 or 8. The modifier is 3 if the defense value is 9.

These modifiers, if any, are added together. Once calculated, the DFCM is set aside for use later in the combat routine.

The Attack Strength (AS) of each attacking army is calculated. This is found by adding together the combat value of the army, the AFCM, and a further modifier for how wwll that army type likes to fight in that terrain. Finally, heroes add the value of any Battle Item(s) carried. However, note that the maximum AS can never exceed 9 no matter how large the modifier. NOTE: the maximum AS is 10 if game Intense Combat option is ON.
The Defense Strength (DS) of each defending army is calculated. This is determined in the same way as the AS.  Again, note that the maximum DS can never exceed 9 (10 for Intense Combat option) no matter how large the modifier.
Combat is resolved. Attacking and Defending armies are sorted on the display with the most valuable armies on the right hand side. Combat is a series of one-on-one engagements between the left-most army of each side. Each combat is fought to the death with the survivor going on to fight his opponent's next army. The battle ends when one side is eliminated.
The battle mechanics work like this:

Each army rolls a ten-sided die (1-10) (1-12 for Intense Combat option).
The result is low if the die roll is less than or equal to his opponent's AS (or DS as the case may be).
The result is high if the die roll is greater than his opponent's AS (or DS).
If both rolls are high or both rolls are low, then the step is repeated.
If one rolls low and the other rolls high, then the low roller takes 1 hit.
As soon as an army receives 2 hits, it is destroyed.
NOTE: In Intense Combat mode hit also decreases the current unit effective strength; this makes it easier to kill stronger units.
NOTE: Special unit type Catapults affect defender building bonus calculation.

## Battle Example
Consider a battle fought between the Grey Dwarves and the Orcs of Kor. The Orcs of Kor are defending a city of defense value 5 with 1 Heavy Infantry (strength 4), 1 Wolf Rider (strength 5) and a hero Roger Orcfinger (strength 6+1), who carries the Speak of Ank - thus becomes of strength 7+2. The Grey Dwarves are attacking with 2 Dwarven Legions (each strength 4), a Griffin (strength 6+1) and a Dragon (strength 8+2).

The AFCM is calculated first. The Dwarves get 1 for a flying army (the Griffin or Dragon) and 1 for a special army (the Dragon). Their AFCM is 2.

Next comes the DFCM. The Orcs get 2 for Roger Orcfinger's strength (7+2) and 1 for the city's defense value of 5. Their DFCM is 3.

We work out the AS or DS of each army:

For the Dwarves - The Dwarven Legions are 6, the Griffin is 8 and the Dragon is 9 (remember that 9 is the maximum value).
For the Orcs - The Heavy Infantry is 7, the Wolf Rider is 8 and Roger Orcfinger is 9.
The armies square up as follows:

From left to right, the Dwarves have two 6's, one 8 and one 9.
The Orcs have one 7, one 8 and one 9.
The battle begins with one Dwarven Legion taking on the Heavy Infantry. The Orcs roll high, the Dwarves low; 1 hit on the Dwarven Legion. Second round. Both roll low; no effect. Third round. Again the Orcs roll high and the Dwarves low; a second hit on the Dwarven Legion which destroys it.

The next Dwarven Legion steps up to bat. It has more luck, inflicting 2 hits on the Heavy Infantry but taking 1 on itself (i.e. 4th round - both high; no effect, 5th round - Orcs high, Dwarves low; 1 hit on the Dwarven Legion, 6th round - Orcs low, Dwarves high; 1 hit on Heavy Infantry, 7th round - Orcs low, Dwarves high; second hit on light infantry destroying it).

The Wolf Rider replaces the valiant but dead Heavy Infantry. It destroys the Dwarven Legion but takes 1 hit itself (i.e. 8th round - both high; no effect, 9th round - Orcs low, Dwarves high; 1 hit on wolf-rider, 10th round - Orcs high, Dwarves low; second hit on Dwarven Legion destroying it).

The Dwarves' magical Griffin quickly dispatches the Wolf Rider (i.e. 11th round - Orcs low, Dwarves high; second hit on Wolf Rider destroying it).

Roger Orcfinger steps into the breach, the last hope. He slaughters the Griffin with relish (i.e. 12th round - Orcs high, Dwarves low; 1 hit on Griffin, 13th round - Orcs high, Dwarves low; second hit on Griffin destroying it).

Now for the final show-down. Roger Orcfinger must take on the fearsome Dwarven Dragon. The battle goes right down to the wire. Roger, desperately wounded, smites the Dragon (i.e. 14th-18th rounds - both low; no effect, 19th round - Orcs low, Dwarves high; 1 hit on Roger, 20th-23rd rounds - both low; no effect, 24th round - Orcs high, Dwarves low; 1 hit on the Dragon, 25th-26th rounds:  both low; no effect, 27th round - Orcs high, Dwarves low; second hit on the Dragon, destroying it).

Let's hear it for Roger Orcfinger! The battle is over. Roger has saved his city. The hit he received during the battle will be healed automatically before the next battle.

May your battle always be victorious, o mighty Warlord!