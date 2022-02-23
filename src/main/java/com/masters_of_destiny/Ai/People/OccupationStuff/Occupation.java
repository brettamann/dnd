package com.masters_of_destiny.Ai.People.OccupationStuff;

import com.masters_of_destiny.Ai.People.PersonAiTest;

import java.util.List;

/**
 * An occupation satisfied several needs, and also defines how a person working at the
 * job behaves. For instance a guard on shift behaves differently than a guard off shift
 */
public class Occupation {
    public String name;
    public JobRequirements jobRequirements;
    public String description;
    public List<Shift> shifts;
    public int dailyWage; // amount payed per day
    public PersonAiTest manager;
    public String companyName;
    public String startDate; // defines how long a person has worked at the job or when the job can start
    public boolean isTemporary;
    public String endDate; // defines when the job ends. Only checked if isTemporary=True
}
