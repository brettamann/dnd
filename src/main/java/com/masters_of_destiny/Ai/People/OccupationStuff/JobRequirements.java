package com.masters_of_destiny.Ai.People.OccupationStuff;

import com.masters_of_destiny.Ai.Actions.Action;
import com.masters_of_destiny.Ai.People.BodyParts.BodyPartStatus;
import com.masters_of_destiny.Ai.People.Genders;
import com.masters_of_destiny.Ai.People.Races.Race;
import com.masters_of_destiny.Ai.People.Statistics.Stats;

import java.util.List;

/**
 * a person with a job they don't match should be rare but possible
 * (as you could tell stories about someone terrible at what they do)
 * and also if a player wants to get a job they would have to meet the requirements
 */
public class JobRequirements {
    public Stats statRequirements; // character must match or exceed ALL stats to be qualified.
    public List<Race> raceRequirements; // must match one of the races
    public List<Genders> genderRequirements;
    public List<Action> actionRequirements; // That is to say, "must be able to do "x"
    public List<BodyPartStatus> disqualifyingStatuses; // statuses that disqualify a person (eg drunk, bleeding, paralyzed)

}






