package com.masters_of_destiny.Ai.People.Races;

import com.masters_of_destiny.Ai.People.BodyParts.Body;
import com.masters_of_destiny.Ai.People.Distribution;

/**
 * A "race" object defines norms for each race.
 * This allows expectations to be checked.
 */
public class Race {

    public RaceTypes name;
    public Body baseBody; //  this is the "expected" body features, the template they are made from.
    public Distribution height;
    public Distribution volumePerHeightFt; // how "fat" they are
    //average human: 5'9", 200 lbs, making them have weightPerHeightFt=(200/5.75)~=34.78

}
