package com.masters_of_destiny.Ai.People;

import com.masters_of_destiny.Ai.People.BodyParts.Body;
import com.masters_of_destiny.Ai.People.BodyParts.BodyPart;
import com.masters_of_destiny.Ai.People.OccupationStuff.Occupation;
import com.masters_of_destiny.Ai.People.Statistics.Stats;
import com.masters_of_destiny.DataObjects.Races.Race;

import java.util.List;

public class PersonAiTest {
    public String name;
    public String age;
    public Genders gender;
    public Race race; // this defines the "norms" for a race.
    public AgeAppearances ageAppearance;
    public Body body; //inherits uuid of person
    public Stats stats; // inherits uuid of person
    public Occupation occupation; // in db, a reference to the job
    public String uuid;



    public List<Need> needList;

    public double agreeableness;


    public PersonAiTest(String name, String age, String gender, String race, double height, double weight, double bloodLevel, double approxVolume, List<BodyPart> bodyPartList) {
        this.name = name;
    }
}
