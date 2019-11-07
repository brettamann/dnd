package com.dnd.Autocombat;

import com.dnd.DataObjects.*;
import com.dnd.DataObjects.Items.StandardWeapons;
import com.dnd.Utilities.Colors;
import com.dnd.Utilities.Input;
import com.dnd.Utilities.RandomGenerator;
import com.dnd.Utilities.Screen;

import java.util.ArrayList;
import java.util.List;

public class AutocombatHandler {

    public static final int ROLL_MIN = -10;
    public static final int ROLL_MAX = 50;
    /*
    I can show the raw bash code I used for this function but I think a summary of what it was accomplishing would be
    a lot more clear, easy to read, and much quicker to get a grasp of so here's what it's trying to do:

    receive a list of players (off partyInfo or partyMember classes)
    receive a list of opponents (commoners, guards, whatever - they'll be based on the Person class)
    recieve the Location that the players are in (Location object) NOTE THAT THE HARD-DATA FOR LOCATIONS ARE FOUND IN THE HardData object as a list of locations when they get passed in
    compute a "braveryChallenge" value which is (location's reputation / 250)+(player reputation / 100) player rep should be on partyInfo

    Give the players a chance to goad the commoners into staying, scare them into running away, or attempt to run/hide/get away without combat.
        this should be inside the simulator and recieve input from the players as to what they want to do. See the Input class for helper methods with that
    if running/hiding: Make everybody do a survival roll (wisdom modifier). If the player average is higher than the opponent average, the players get away without a fight.
        award 1/4 the xp for the encounter.
    if goading: each party member makes a performance, deception, or persuasion roll (the players actually roll them and then they are received here from input)
        Average the rolls (player average roll)
        compute a "crowd bravery" modifier which is (# of opponents / 10)
        braveryChallenge = braveryChallenge - ((crowd bravery) + (player average roll from above)).
        compare the rolls to each opponent's bravery level. If the opponent has higher bravery than the challenge, they stay. otherwise they flee.
        basically the player rolls make the "challenge" easier
    if scaring: do the same as goading except receiving and averaging an intimidation roll, and instead use braveryChallenge = braveryChallenge - (crowd bravery) + (player average roll from above)
        basically the player roll make the "challenge" greater
    if players choose to do nothing to influence the crowd, run the bravery challenge check without any modifiers

    once all that is figured out, calculate a call time. a "call time" represents the time it takes for someone with a call glyph to be found, that glyph activated, the message recieved, reinforcements gathered together, and then teleported to the approximate location where they are needed. Wealthier areas tend to get priority and thus have very short call times whereas less populated or more ghetto areas tend to take longer.
        if anybody in the crowd has a call glyph, whether they flee or not, make the call time a random value in the location's range
            hasCallGlyph is a boolean element of a Person
        if nobody in the crowd has a call glyph and nobody fled the area, the call time is a random number between 50-300 rounds (5-30 minutes) + the random value in the location's range to estimate when somebody else would stumble across the scene
        if nobody in the crowd has a call glyph and at least 1 person fled the area, the call time = (random number between 4 and 12) + (random number in location's range) + (random number in location's range)
    the call time determines how many rounds of autocombat can happen before it stops. Once reinforcements show up, the players go into manual combat

    Before the combat actually starts, the players are told the results of who stayed/fled and get one more chance to run it manually or go through autocombat

    if the players choose to continue autocombat, do a combat loop until the callTime runs out, at which point reinforcements arrive and players go into manual combat.
        The reason for this is that commoners rarely have abilities that'd significantly alter autocombat but many guards, especially later, have powerful abilities that need to be dealt with
        so autocombat needs to be done once the reinforcements arrive.
    To start the combat loop:
        I had 3 conditions that ended the loop:
            the calltime timer ran out
            all opponents are dead/gone
            all players are incapacitated
        figure out initiative, there's 3 ways we could do it:
            we can group the party and opponents into separate initiative groups
            make every single person into their own initiative entity
            do it the way a manual combat would work, where each player rolls their own initiative and then enemies are grouped by type
            regardless, if you need the initiative bonus it's the dexMod element of a Person
        The way I was doing it (which might not be the best) was to group all commoners and all players into 2 groups, then either the commoners went first or the players. Mostly it was just the easiest way to write it in bash. Within those groups each round I would randomly shuffle the order of who attacked when
        either way, decide who is going first, second, etc, in the turn order.
        Get the group who goes first, get the person who attacks first, then assign them a person to attack.
        Look at how many times that person can attack per turn - Some people get more than 1 attack per turn (like if dual wielding) so after each attack check if the target is down, and if they are, pick a new target so the extra attacks aren't wasted
        Then get a random number 1-20
        If it's a 20, track that it's a critical and don't bother checking against AC. Just do a damage roll and double it
        if it's a 1, change the assigned target temporarily to a random ally and re-roll the attack against them
        otherwise add the to-hit modifier of the weapon + proficiencies (on the Weapon object it's the total combined to-hit bonus)
            compare that number to the AC of the target
            if the number is greater than or equal to the target's AC, do a damage roll and subtract that hp from the target. Make sure to account for all damage types that might be added in
                All of these will be held within the Person object
            if the attack reduces the target to 0 hp, add that person to the killed list to track, for fun. If a player dies it'd be fun to see who.what killed them
            then remove the person from combat if they're dead
        If the person has more than 1 attack, keep going until they're out of attacks
        NOTE: when the commoners are attacking the players, they can't all hit at once. Depending on how many players and their allies are around, these are the limits of how many commoners can attack the players during one round
        This accounts for the maximum amount of people that can surround the given count of players assuming the players are in an optimal position that reduces attackers but still allows each player to attack at least one opponent (so a player isn't surrounded by allies)

        just for example (x = opponent, 0 = player)

        xxx       xxx       xxxx
        x0xx      x0x       x00x
        x00x      xxx       xxxx
        xxxx

		1 player = 8 opponents
		2 players = 10 opponents
		3 players = 12 opponents
		4 players = 12 opponents
		5 players = 14 opponents
		6 players = 14 opponents
		7 players = 16 opponents
		8 players = 16 opponents
        9 players = 16 opponents
		10 players = 18 opponents

		The weakness in this system is that it doesn't account for ranged weapons. Like if you had 3 melee attackers and 10 ranged ones you could easily have all 13 attacking a single person
		But because positioning is such a agency-driven factor in a battle that is drastically affected by terrain, environment props, hp levels, etc, and this program really can't be expected to account for all of that, it seems simpler that everyone just attacks at melee range regardless of their weapon.
        so when this is going through, let's say all 3 players are alive and there's 20 opponents. During a single round of opponent attacks only opponents 1-12 get to swing at the players
    So the combat loop runs until stopped by the aforementioned conditions
    we could also have a "break point" where if a player gets knocked out the autocombat stops and the players can manually run a few rounds
        or do something where the players do a quick heal and then continue autocombat. I dunno.
    Once stopped:
        if the loop stopped because reinforcements showed up, the battle goes into manual
        if the loop stopped because all opponents are dead, the players get the choice of running, looting, hiding, or leaving calling cards each round
            if they run, just end the combat and award experience
            if they leave calling cards, read input for how long it'll take for players to leave their "cards" and then fast-forward that many rounds, checking if reinforcements show up
            if the loot, each player gets to grab the stuff off of one dead combatant per round. At the end of each round, if the call timer hasn't run out, they get to choose again if they want to keep looting or get out of there (or leave calling cards if they haven't yet)
                the "loot" gained off a Person is the wornArmor list + the wornWeapon list + platinum + gold + silver + copper + all object held in the packCarried object. You could probably add the objects worn to the packCarried and then just grab the packCarried object off of the Person but as long as all those items are grabbed that works
            if the players loot all the bodies before the timer runs out, the combat ends and they escape before reinforcements arrive.
            if the timer runs out while they're looting/leaving cards, generate the guards that show up and go into manual combat.
            alternatively the players can try to hide in the area. they make stealth rolls and then when the guards show up, if they didn't roll garbage stealth, they can decide whether to fight the reinforcements or not.
        if the loop stopped because the players are dead, well that sucks! Make sure that this program is talkative during combat so we can read back what happened. The DM will decide what happens from there.
    after the combat is over, we need rewards!
    to calculate experience:
        add up the experience from fled commoners separately (if the players fled instead, they get 1/4 xp from everyone they fled from).
        then add up the xpValue of each individual opponent killed (part of Person object)
        add up how MANY opponents were killed
        the kill experience is = Math.round((Added up xp from kills)^(1 + ((# of kills)^1.5 / 1500))))
            take the 1.5 power of the number of kills. Divide that by 1500, then add 1. Then make that number the power of the total xp earned, then round that up to the nearest 1.
            It's an exponential function so the more xp earned and the more kills made in a single combat, the more bonus xp you get. Killing 4 commoners worth 100xp each won't give you much bonus but killing 15 commoners worth 225 each (which is a pretty weak set of commoners) would be worth 3375 but with the bonus it's worth 4623, so an extra 1248 xp so nearly a 37% bonus
            Note that xp is a general representation of how powerful an opponent is, so both the number and the quality of the opponents matter in this equation.
        so add the fled commoner xp (which is 1/4 their value) to the (killed commoner xp with bonus)
        divide that number by the number of players, rounded up
        and that's the xp awarded to each player for the combat.
    Reputation earned will be DM discretion but gets a bonus for leaving calling cards.
    Depending on how looting went, that'll be part of the rewards too.

    also, I'll write a function that figures out how many and what reinforcements show up.
     */


    public static EncounterObject epicCombat(PartyInfo partyInfo, List<PartyMember> originalPartyMembers, List<Person> originalOpponents, Location location){


        if(partyInfo == null || originalPartyMembers == null || originalOpponents == null || location == null){
            Screen.redText("SOMETHING WAS PASSED IN AS NULL! NOT CONTINUING!");
            return new EncounterObject();
        }

        List<PartyMember> partyMembers = new ArrayList<>();
        for(PartyMember member : originalPartyMembers){
            partyMembers.add(new PartyMember(member));
        }

        List<Person> opponents = new ArrayList<>();
        for(Person opponent : originalOpponents){
            opponents.add(new Person(opponent));
        }

        EncounterObject encounterObject = new EncounterObject();
        double braveryChallenge = (location.reputationInArea/250d) + (partyInfo.getReputation()/100d);
        boolean braveryChallengeCalculated = false;

        String challengeType = Input.promptTextInput("How would you like to approach the encounter? \n1. run (Athleticism)\n2. hide (Survival)\n3. goad (Performance, Deception, or Persuasion) \n4. scare (Deception, Intimidation) \n5. bribe (Persuasion)) \n6. Do Nothing and just Fight!\nEnter Selection: ", List.of("run", "hide", "goad", "scare", "bribe", "nothing", "1", "2", "3", "4", "5", "6"));

        if(challengeType.toLowerCase().equals("run") || challengeType.equals("1")){
            boolean success = runSimulationToSeeIfSuccessful("Athleticism", "strength", partyMembers, opponents);

            if(success){
                int experience = 0;
                for (Person opponent : opponents){
                    experience += opponent.getXpValue()/4;
                }

                Screen.println("\nRan away successfully! Experience gained is: " + experience + "\nExperience per Party Member is: " + experience/partyInfo.getMemberCount());
                encounterObject.experiencePerMember = experience/partyMembers.size();

                return encounterObject;
            }
            else {
                Screen.println("\nDid not get away! Continuing with Combat!\n");
            }


        }
        else if (challengeType.toLowerCase().equals("hide") || challengeType.equals("2")){
            boolean success = runSimulationToSeeIfSuccessful("Survival", "wisdom", partyMembers, opponents);

            if(success){
                int experience = 0;
                for (Person opponent : opponents){
                    experience += opponent.getXpValue()/4;
                }

                Screen.println("\nHid successfully! Experience gained is: " + experience + "\nExperience per Party Member is: " + experience/partyInfo.getMemberCount());
                encounterObject.experiencePerMember = experience/partyMembers.size();

                return encounterObject;
            }
            else {
                Screen.println("\nDid not get away! Continuing with Combat!\n");
            }
        }
        else if(challengeType.toLowerCase().equals("goad") || challengeType.equals("3")){
            double averagePartyMemberRoll = collectAverageForRoll("Performance, Deception, or Persuasion", partyMembers);
            double crowdBraveryModifier = opponents.size()/10d;

            braveryChallenge = braveryChallenge - (crowdBraveryModifier + averagePartyMemberRoll);
            braveryChallengeCalculated = true;

        }
        else if(challengeType.toLowerCase().equals("scare") || challengeType.equals("4")){
            double averagePartyMemberRoll = collectAverageForRoll("Intimidation", partyMembers);
            double crowdBraveryModifier = opponents.size()/10d;

            braveryChallenge = braveryChallenge - crowdBraveryModifier + averagePartyMemberRoll;
            braveryChallengeCalculated = true;

        }
        else if(challengeType.toLowerCase().equals("bribe") || challengeType.equals("5")){
            // Brett does this
        }

        if(!braveryChallengeCalculated){
            braveryChallenge = braveryChallenge - opponents.size()/10d;
        }

        boolean glyphPresent = false;

        for(Person opponent : opponents){
            if(opponent.getBravery() < braveryChallenge){
                encounterObject.opponentsWhoRanAway.add(opponent);
            }
            else{
                encounterObject.opponentsWhoStayed.add(opponent);
            }
            if(opponent.getHasCallGlyph()){
                glyphPresent = true;
            }
        }

        int callTime;

        if(glyphPresent) {
            callTime = RandomGenerator.randomIntInRange(location.fastestCallTime, location.slowestCallTime);
        }
        else{
            boolean someoneCalled = false;

            for( Person opponent : encounterObject.opponentsWhoRanAway){
                if(opponent.getTolerance() < RandomGenerator.randomD20Roll()){
                    someoneCalled = true;
                    break;
                }
            }

            if(someoneCalled){
                callTime = RandomGenerator.randomIntInRange(4, 12) + RandomGenerator.randomIntInRange(location.fastestCallTime, location.slowestCallTime) + RandomGenerator.randomIntInRange(location.fastestCallTime, location.slowestCallTime);
            }
            else{
                callTime = RandomGenerator.randomIntInRange(50, 300) + RandomGenerator.randomIntInRange(location.fastestCallTime, location.slowestCallTime);
            }
        }

        // Players get to decide if they stay with Autocombat or switch to Manual (Brett, decide how to display this)

        Screen.println("How many stayed: " + encounterObject.opponentsWhoStayed.size());
        Screen.println("How many fled: " + encounterObject.opponentsWhoRanAway.size());
        String continueCombat = Input.promptTextInput("\nWould you like to continue auto-combat? (yes/no)", List.of("yes", "no", "y", "n"));

        if(continueCombat.toLowerCase().contains("n")){
            return encounterObject;
        }

        int roundCount = 0;

        int opponentAttackLimit = 0;

        switch (partyInfo.getMemberCount()){
            case 1:
                opponentAttackLimit = 8;
                break;
            case 2:
                opponentAttackLimit = 10;
                break;
            case 3:
            case 4:
                opponentAttackLimit = 12;
                break;
            case 5:
            case 6:
                opponentAttackLimit = 14;
                break;
            case 7:
            case 8:
            case 9:
                opponentAttackLimit = 16;
                break;
            default:
                opponentAttackLimit = 18;
                break;
        }

        //for simplicity for now, we are just going to go players than opponents for attack order, in the same order. Can
        // expand it later, but I don't think it would make a large difference, so we are just
        // doing this for now

        List<PartyMember> alivePartyMembers = new ArrayList<>(partyMembers);

        while (encounterObject.playersWhoDied.size() != partyInfo.getMemberCount()
        && ++roundCount <= callTime
        && encounterObject.opponentsWhoStayed.size() != 0
        && !encounterObject.encounterFinished) {

            int numberOfOpponentsWhoAttacked = 0;


            Screen.println("\n*** Round " + roundCount + "! ***");
            Screen.println("Current number of enemies: " + red(String.valueOf(encounterObject.opponentsWhoStayed.size())));
            Screen.println("Current number of party members: " + green(String.valueOf(alivePartyMembers.size())) + "\n");


            for (PartyMember member : partyMembers) {
                if (alivePartyMembers.contains(member)) {
                    for (int i = 0; i < member.getNumberOfAttacks(); i++) {
                        int roll = RandomGenerator.randomD20Roll();

                        if(encounterObject.opponentsWhoStayed.size() == 0) {
                            encounterObject.encounterFinished = true;
                            break;
                        }
                        List<Person> priorityTarget = new ArrayList<>();

                        Person target;

                        for(Person opponent : encounterObject.opponentsWhoStayed){
                            if(opponent.getHpCurrent() < opponent.getHpMax()){
                                priorityTarget.add(opponent);
                            }
                        }
                        if(priorityTarget.size() != 0){
                            target = priorityTarget.get(RandomGenerator.randomIntInRange(0, priorityTarget.size() - 1));
                        }
                        else {
                           target = encounterObject.opponentsWhoStayed.get(RandomGenerator.randomIntInRange(0, encounterObject.opponentsWhoStayed.size() - 1));
                        }


                        PartyMember friendlyTarget = null;
                        int damage = 0;
                        boolean critical = false;

                        if (roll == 20) {
                            damage = RandomGenerator.randomIntInRange(member.getDamageRangeLow(), member.getDamageRangeHigh()) + RandomGenerator.randomIntInRange(member.getDamageRangeLow(), member.getDamageRangeHigh());

                            Screen.println("CRITICAL!!!! " + green(member.getName()) + " scored a Critical against " + target.getName() + " for " + damage + " damage! (" + (target.getHpCurrent() - damage) + " hp left)");
                            critical = true;
                        } else if (roll == 1) {
                            roll = RandomGenerator.randomD20Roll();
                            friendlyTarget = partyMembers.get(RandomGenerator.randomIntInRange(0, partyMembers.size() - 1));
                            if (roll + member.getToHitBonus() >= friendlyTarget.getAc()) {
                                int friendlyDamage = RandomGenerator.randomIntInRange(member.getDamageRangeLow(), member.getDamageRangeHigh());
                                friendlyTarget.setCurrentHp(friendlyTarget.getCurrentHp() - friendlyDamage);

                                Screen.println("Whoops!!!! " + green(member.getName()) + " accidentally hit "  + green(friendlyTarget.getName()) + " for " + friendlyDamage + " damage! (" + friendlyTarget.getCurrentHp() + " hp left)");

                                if (friendlyTarget.getCurrentHp() <= 0) {
                                    encounterObject.playersWhoDied.add(friendlyTarget);
                                    alivePartyMembers.remove(friendlyTarget);
                                    Screen.println("OH NO!!! " + friendlyTarget.getName() + " Died from Friendly Fire!");

                                    if(alivePartyMembers.size() == 0) {
                                        encounterObject.encounterFinished = true;
                                        break;
                                    }
                                }

                            } else {
                                Screen.println("Whoops!!!! " + green(member.getName()) + " almost hit " + green(friendlyTarget.getName()) + "!");


                            }
                        } else {
                            if (roll + member.getToHitBonus() >= target.getAc()) {
                                damage = RandomGenerator.randomIntInRange(member.getDamageRangeLow(), member.getDamageRangeHigh());
                            } else {
                                Screen.println(green(member.getName()) + " rolled a " + (roll + member.getToHitBonus()) + " and missed " + red(target.getName()) + "! (AC is " + target.getAc() + ")");
                            }
                        }

                        if (friendlyTarget == null && damage != 0) {
                            target.setHpCurrent(target.getHpCurrent() - damage);

                            if(!critical)
                                Screen.println(green(member.getName()) + " rolled " + (roll + member.getToHitBonus()) + " and hit " + red(target.getName()) + " for " + damage + "! (" + target.getHpCurrent() + " hp left)");

                            if (target.getHpCurrent() <= 0) {
                                encounterObject.opponentsWhoDied.add(target);
                                encounterObject.opponentsWhoStayed.remove(target);
                                Screen.println(yellow(target.getName() + " Died!"));

                                if(encounterObject.opponentsWhoStayed.size() == 0){
                                    encounterObject.encounterFinished = true;
                                    break;
                                }
                            }

                        }

                    }
                }

            }

            for (Person opponent : opponents) {
                if (numberOfOpponentsWhoAttacked < opponentAttackLimit && encounterObject.opponentsWhoStayed.contains(opponent)) {
                    numberOfOpponentsWhoAttacked++;

                    boolean alreadyAttacked = false;

                    if(opponent.getMainhandWeapon() != null){
                        int toHit = 0;
                        if(alreadyAttacked)
                            toHit = opponent.getMainhandWeapon().toHitBonus;
                        else {
                            toHit = opponent.getMainhandWeapon().combinedToHitBonus;
                            alreadyAttacked = true;
                        }

                        int roll = RandomGenerator.randomD20Roll();
                        if(alivePartyMembers.size() == 0) {
                            encounterObject.encounterFinished = true;
                            break;
                        }

                        PartyMember target = alivePartyMembers.get(RandomGenerator.randomIntInRange(0, alivePartyMembers.size() - 1));
                        Person friendlyTarget = null;
                        int damage = 0;
                        boolean critical = false;

                        if (roll == 20) {
                            damage = RandomGenerator.randomIntInRange(opponent.getMainhandWeapon().getTotalUntypedDamageMin(), opponent.getMainhandWeapon().getTotalUntypedDamageMax()) + RandomGenerator.randomIntInRange(opponent.getMainhandWeapon().getTotalUntypedDamageMin(), opponent.getMainhandWeapon().getTotalUntypedDamageMax());

                            Screen.println("CRITICAL!!!! " + red(opponent.getName()) + " scored a Critical against " + green(target.getName()) + " for " + damage + " damage! (" + (target.getCurrentHp() - damage) + " hp left)");
                            critical = true;
                        } else if (roll == 1) {
                            roll = RandomGenerator.randomD20Roll();
                            friendlyTarget = encounterObject.opponentsWhoStayed.get(RandomGenerator.randomIntInRange(0, encounterObject.opponentsWhoStayed.size() - 1));


                            if (roll + toHit >= friendlyTarget.getAc()) {
                                int friendlyDamage = RandomGenerator.randomIntInRange(opponent.getMainhandWeapon().getTotalUntypedDamageMin(), opponent.getMainhandWeapon().getTotalUntypedDamageMax());
                                friendlyTarget.setHpCurrent(friendlyTarget.getHpCurrent() - friendlyDamage);

                                Screen.println("Whoops!!!! " + red(opponent.getName()) + " accidentally hit " + red(friendlyTarget.getName()) + " for " + friendlyDamage + " damage! (" + friendlyTarget.getHpCurrent() + " hp left)");

                                if (friendlyTarget.getHpCurrent() <= 0) {
                                    encounterObject.opponentsWhoDied.add(friendlyTarget);
                                    encounterObject.opponentsWhoStayed.remove(friendlyTarget);
                                    Screen.println("OH NO!!! " + friendlyTarget.getName() + " Died from Friendly Fire!");

                                    if(encounterObject.opponentsWhoStayed.size() == 0) {
                                        encounterObject.encounterFinished = true;
                                        break;
                                    }
                                }

                            } else {
                                Screen.println("Whoops!!!! " + red(opponent.getName()) + " almost hit  " + red(friendlyTarget.getName()) + "!");

                            }
                        } else {
                            if (roll + toHit >= target.getAc()) {
                                damage = RandomGenerator.randomIntInRange(opponent.getMainhandWeapon().getTotalUntypedDamageMin(), opponent.getMainhandWeapon().getTotalUntypedDamageMax());
                            } else {
                                Screen.println(red(opponent.getName()) + " rolled a " + (roll + toHit) + " and missed " + green(target.getName()) + "! (AC is " + target.getAc() + ")");
                            }
                        }

                        if (friendlyTarget == null && damage != 0) {
                            target.setCurrentHp(target.getCurrentHp() - damage);

                            if(!critical)
                                Screen.println(red(opponent.getName()) + " rolled " + (roll + toHit) + " and hit " + green(target.getName()) + " for " + damage + "!");

                            if (target.getCurrentHp() <= 0) {
                                encounterObject.playersWhoDied.add(target);
                                alivePartyMembers.remove(target);
                                Screen.println(yellow(target.getName() + " Died!"));

                                if(alivePartyMembers.size() == 0){
                                    encounterObject.encounterFinished = true;
                                    break;
                                }
                            }

                        }


                    }

                    if(opponent.getOffhandWeapon() != null && !opponent.getOffhandWeapon().name.equals(StandardWeapons.unarmed.name)) {
                        int toHit = 0;
                        if (alreadyAttacked)
                            toHit = opponent.getOffhandWeapon().toHitBonus;
                        else {
                            toHit = opponent.getOffhandWeapon().combinedToHitBonus;
                            alreadyAttacked = true;
                        }

                        int roll = RandomGenerator.randomD20Roll();
                        if (alivePartyMembers.size() == 0) {
                            encounterObject.encounterFinished = true;
                            break;
                        }

                        PartyMember target = alivePartyMembers.get(RandomGenerator.randomIntInRange(0, alivePartyMembers.size() - 1));
                        Person friendlyTarget = null;
                        int damage = 0;
                        boolean critical = false;

                        if (roll == 20) {
                            damage = RandomGenerator.randomIntInRange(opponent.getOffhandWeapon().getTotalUntypedDamageMin(), opponent.getOffhandWeapon().getTotalUntypedDamageMax()) + RandomGenerator.randomIntInRange(opponent.getOffhandWeapon().getTotalUntypedDamageMin(), opponent.getOffhandWeapon().getTotalUntypedDamageMax());

                            Screen.println("CRITICAL!!!! " + opponent.getName() + " scored a Critical against " + target.getName() + " for " + damage + " damage! ( " + target.getCurrentHp() + " hp left)");
                            critical = true;
                        } else if (roll == 1) {
                            roll = RandomGenerator.randomD20Roll();
                            friendlyTarget = encounterObject.opponentsWhoStayed.get(RandomGenerator.randomIntInRange(0, encounterObject.opponentsWhoStayed.size() - 1));


                            if (roll + toHit >= friendlyTarget.getAc()) {
                                int friendlyDamage = RandomGenerator.randomIntInRange(opponent.getOffhandWeapon().getTotalUntypedDamageMin(), opponent.getOffhandWeapon().getTotalUntypedDamageMax());
                                friendlyTarget.setHpCurrent(friendlyTarget.getHpCurrent() - friendlyDamage);

                                Screen.println("Whoops!!!! " + red(opponent.getName()) + " accidentally hit  " + red(friendlyTarget.getName()) + " for " + friendlyDamage + " damage! (" + friendlyTarget.getHpCurrent() + " hp left)");

                                if (friendlyTarget.getHpCurrent() <= 0) {
                                    encounterObject.opponentsWhoDied.add(friendlyTarget);
                                    encounterObject.opponentsWhoStayed.remove(friendlyTarget);
                                    Screen.println("OH NO!!! " + friendlyTarget.getName() + " Died from Friendly Fire!");

                                    if (encounterObject.opponentsWhoStayed.size() == 0) {
                                        encounterObject.encounterFinished = true;
                                        break;
                                    }
                                }

                            } else {
                                Screen.println("Whoops!!!! " + red(opponent.getName()) + " almost hit  " + red(friendlyTarget.getName()) + "!");

                            }
                        } else {
                            if (roll + toHit >= target.getAc()) {
                                damage = RandomGenerator.randomIntInRange(opponent.getOffhandWeapon().getTotalUntypedDamageMin(), opponent.getOffhandWeapon().getTotalUntypedDamageMax());
                            } else {
                                Screen.println(red(opponent.getName()) + " rolled a " + (roll + toHit) + " and missed " + green(target.getName()) + "! (AC is " + target.getAc() + ")");
                            }
                        }

                        if (friendlyTarget == null && damage != 0) {
                            target.setCurrentHp(target.getCurrentHp() - damage);

                            if (!critical)
                                Screen.println(red(opponent.getName()) + " rolled " + (roll + toHit) + " and hit " + green(target.getName()) + " for " + damage + "! (" + target.getCurrentHp() + " hp left)");

                            if (target.getCurrentHp() <= 0) {
                                encounterObject.playersWhoDied.add(target);
                                alivePartyMembers.remove(target);
                                Screen.println(yellow(target.getName() + " Died!"));

                                if (alivePartyMembers.size() == 0) {
                                    encounterObject.encounterFinished = true;
                                    break;
                                }
                            }
                        }
                    }

                }

            }

            if(encounterObject.opponentsWhoStayed.size() == 0 || alivePartyMembers.size() == 0){
                encounterObject.encounterFinished = true;
                break;
            }
        }

        if(roundCount > callTime && !encounterObject.encounterFinished) {
            Screen.println("\n*****REINFORCEMENTS HAVE ARRIVED! ENDING AUTO COMBAT!*****");

            Long experience = addUpExperience(encounterObject, partyMembers);
            encounterObject.experiencePerMember += experience;
            Screen.println("\nExperience gained so far (Per person): " + experience);

            return encounterObject;
        } else {
            if(alivePartyMembers.size() == 0){
                Screen.println(yellow("\nWhoa... you guys died!\n"));

                Long experience = addUpExperience(encounterObject, partyMembers);
                encounterObject.experiencePerMember += experience;
                Screen.println("Experience gained (Per person): " + experience);

                return encounterObject;
            }
            else {
                List<Person> opponentsWhoHaveLoot = new ArrayList<>(encounterObject.opponentsWhoDied);

                Long experience = addUpExperience(encounterObject, partyMembers);
                encounterObject.experiencePerMember += experience;
                Screen.println("\nExperience gained (Per person): " + experience);

                while (roundCount <= callTime) {

                    String howToProceed = Input.promptTextInput("Current Round: " + roundCount + "\nAll enemies are dead! How would you like to proceed? \n1. loot\n2. callingcard \n3. leave\n4. hide\nSelection", List.of("1", "2", "3", "4", "loot", "callingcard", "leave", "hide"));

                    int goldFound = 0;


                    if (howToProceed.equals("1") || howToProceed.toLowerCase().equals("loot")) {
                        for (int i = 0; i < partyInfo.getMemberCount(); i++) {
                            if(opponentsWhoHaveLoot.size() != 0) {
                                Person lootableOpponent = opponentsWhoHaveLoot.get(RandomGenerator.randomIntInRange(0, opponentsWhoHaveLoot.size() - 1));
                                goldFound += lootableOpponent.getGold();
                                opponentsWhoHaveLoot.remove(lootableOpponent);


                                // BRETT, NOT SURE WHERE TO SEE WHAT LOOT THEY HAVE. PUT THE CODE HERE FOR IT
                            }
                        }

                        Screen.println("\nLooted " + goldFound + " gold.");
                        encounterObject.totalGoldFound += goldFound;

                        if(opponentsWhoHaveLoot.size() == 0) {
                            Screen.println("\nYou have looted all available enemies!\n");
                        }

                    } else if (howToProceed.equals("2") || howToProceed.toLowerCase().equals("callingcard")) {
                        roundCount += Input.promptIntInputWithinRange("\nDescribe the Calling Card. How many rounds does it take to accomplish? ", 0, 100);

                    } else if (howToProceed.equals("3") || howToProceed.toLowerCase().equals("leave")) {
                        return encounterObject;
                    } else if(howToProceed.equals("4") || howToProceed.toLowerCase().equals("hide")){
                        double rollAverage = collectAverageForRoll("Stealth", partyMembers);

                        Screen.println("Stealth roll averaged: " + rollAverage);

                        // ADD REINFORCEMENTS COMING HERE
                        Screen.println("\n*****REINFORCEMENTS HAVE ARRIVED!!*****");

                        return encounterObject;
                    }
                    roundCount++;
                }

                Screen.println("\n*****REINFORCEMENTS HAVE ARRIVED!!*****");
                // call reinforcement method here

                return encounterObject;
            }
        }
    }

    private static long addUpExperience(EncounterObject encounterObject, List<PartyMember> members){
        double killedExperience = 0;
        for(Person person : encounterObject.opponentsWhoDied){
            killedExperience += person.getXpValue();
        }

        long experience = Math.round(Math.pow(killedExperience, (1 + Math.pow( encounterObject.opponentsWhoDied.size(),1.5) / 1500)));

        double fledExperience = 0;
        for(Person person : encounterObject.opponentsWhoRanAway){
            fledExperience += person.getXpValue();
        }

        experience += fledExperience/4d;

        return experience/members.size();
    }


    private static boolean runSimulationToSeeIfSuccessful(String typeOfRoll, String attribute, List<PartyMember> players, List<Person> opponents) {
        double averagePartyRoll = collectAverageForRoll(typeOfRoll, players);
        double averageOpponentRoll = 0;



        for (Person opponent : opponents) {
            if(attribute.toLowerCase().equals("strength"))
                averageOpponentRoll += RandomGenerator.randomD20Roll() + opponent.getStrMod();
            if(attribute.toLowerCase().equals("intelligence"))
                averageOpponentRoll += RandomGenerator.randomD20Roll() + opponent.getIntMod();
            if(attribute.toLowerCase().equals("wisdom"))
                averageOpponentRoll += RandomGenerator.randomD20Roll() + opponent.getWisMod();
            if(attribute.toLowerCase().equals("dexterity"))
                averageOpponentRoll += RandomGenerator.randomD20Roll() + opponent.getDexMod();
            if(attribute.toLowerCase().equals("charisma"))
                averageOpponentRoll += RandomGenerator.randomD20Roll() + opponent.getChrMod();
            if(attribute.toLowerCase().equals("constitution"))
                averageOpponentRoll += RandomGenerator.randomD20Roll() + opponent.getConMod();
        }

        averageOpponentRoll = averageOpponentRoll / opponents.size();

        Screen.println("\nPlayers Average Roll: " + averagePartyRoll);
        Screen.println("\nOpponents Average Roll: " + averageOpponentRoll);

        if(averagePartyRoll >= averageOpponentRoll )
        {
            Screen.println("\nSuccess!\n");
            return true;
        }
        else {
            Screen.println("\nFailure!\n");

            return false;
        }
    }

    private static double collectAverageForRoll(String typeOfRoll, List<PartyMember> players){
        double averagePartyRoll = 0;

        for(int i = 0; i < players.size(); i++){
            averagePartyRoll += Input.promptIntInputWithinRange("Please enter " + typeOfRoll + " roll for Party Member " + (i + 1) + "", ROLL_MIN, ROLL_MAX);
        }

        Screen.println("Average Roll: " + averagePartyRoll/players.size());

         return averagePartyRoll/players.size();
    }

    private static String green(String textThatIsGreen){
        return Colors.ANSI_GREEN + textThatIsGreen + Colors.ANSI_RESET;
    }

    private static String red(String textThatIsRed){
        return Colors.ANSI_RED + textThatIsRed + Colors.ANSI_RESET;
    }

    private static String yellow(String textThatIsYellow){
        return Colors.ANSI_YELLOW + textThatIsYellow + Colors.ANSI_RESET;
    }

}
