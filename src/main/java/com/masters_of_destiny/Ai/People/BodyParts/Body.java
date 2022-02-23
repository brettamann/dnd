package com.masters_of_destiny.Ai.People.BodyParts;

import com.masters_of_destiny.Ai.Actions.TargetTags;

import java.util.ArrayList;
import java.util.List;

public class Body {
    public double height;
    public double weight;
    public double bloodLevel; //to track bleeding
    public double approxVolume; //Other parts will take measurements based on this
    public String race;
    public String age;
    public String gender;
    public List<BodyPartAbilities> bodyAbilities; // abilities that require multiple parts to work, like echolacation requires a proper sound emitter and sensitive hearing
    public List<BodyPart> bodyPartList; // in the DB, all connected by a uuid
    //Average adult is ~3782 cubic inches
    public List<TargetTags> tagList;

    public void GenerateHumanBody() {
        bodyPartList.add(new BodyPart("torso", "Chest area", new ArrayList<BodyPartStatuses>(), new ArrayList<BodyPartAbilities>(), new ArrayList<BodyPartTraits>(), 41.4, BodyPartTypes.TORSO, BodyPartTypes.BODY));
        bodyPartList.add(new BodyPart("pelvis", "Hips area", new ArrayList<BodyPartStatuses>(), new ArrayList<BodyPartAbilities>(), new ArrayList<BodyPartTraits>(), 13.7, BodyPartTypes.PELVIS, BodyPartTypes.TORSO));
        bodyPartList.add(new BodyPart("thigh", "Upper leg", new ArrayList<BodyPartStatuses>(), new ArrayList<BodyPartAbilities>(), new ArrayList<BodyPartTraits>(), 10.5, BodyPartTypes.LEFTTHIGH, BodyPartTypes.PELVIS));
        bodyPartList.add(new BodyPart("knee", "", new ArrayList<BodyPartStatuses>(), new ArrayList<BodyPartAbilities>(), new ArrayList<BodyPartTraits>(), 1, BodyPartTypes.LEFTKNEE, BodyPartTypes.LEFTTHIGH));
        bodyPartList.add(new BodyPart("calf", "Lower leg", new ArrayList<BodyPartStatuses>(), new ArrayList<BodyPartAbilities>(), new ArrayList<BodyPartTraits>(), 3.75, BodyPartTypes.LEFTCALF, BodyPartTypes.LEFTKNEE));
        bodyPartList.add(new BodyPart("foot", "", new ArrayList<BodyPartStatuses>(), new ArrayList<BodyPartAbilities>(), new ArrayList<BodyPartTraits>(), 1.0725, BodyPartTypes.LEFTFOOT, BodyPartTypes.LEFTCALF));
        bodyPartList.add(new BodyPart("pinkie toe", "Smallest outermost toe", new ArrayList<BodyPartStatuses>(), new ArrayList<BodyPartAbilities>(), new ArrayList<BodyPartTraits>(), .0715, BodyPartTypes.LEFTPINKIETOE, BodyPartTypes.LEFTFOOT));
        bodyPartList.add(new BodyPart("ring toe", "Second from outermost toe", new ArrayList<BodyPartStatuses>(), new ArrayList<BodyPartAbilities>(), new ArrayList<BodyPartTraits>(), .0715, BodyPartTypes.LEFTRINGTOE, BodyPartTypes.LEFTFOOT));
        bodyPartList.add(new BodyPart("middle toe", "", new ArrayList<BodyPartStatuses>(), new ArrayList<BodyPartAbilities>(), new ArrayList<BodyPartTraits>(), .0715, BodyPartTypes.LEFTMIDDLETOE, BodyPartTypes.LEFTFOOT));
        bodyPartList.add(new BodyPart("pointer toe", "Second from innermost toe", new ArrayList<BodyPartStatuses>(), new ArrayList<BodyPartAbilities>(), new ArrayList<BodyPartTraits>(), .0715, BodyPartTypes.LEFTMIDDLETOE, BodyPartTypes.LEFTFOOT));
        bodyPartList.add(new BodyPart("big toe", "Widest innermost toe", new ArrayList<BodyPartStatuses>(), new ArrayList<BodyPartAbilities>(), new ArrayList<BodyPartTraits>(), .0715, BodyPartTypes.LEFTBIGTOE, BodyPartTypes.LEFTFOOT));
        bodyPartList.add(new BodyPart("thigh", "Upper leg", new ArrayList<BodyPartStatuses>(), new ArrayList<BodyPartAbilities>(), new ArrayList<BodyPartTraits>(), 10.5, BodyPartTypes.RIGHTTHIGH, BodyPartTypes.PELVIS));
        bodyPartList.add(new BodyPart("knee", "", new ArrayList<BodyPartStatuses>(), new ArrayList<BodyPartAbilities>(), new ArrayList<BodyPartTraits>(), 1, BodyPartTypes.RIGHTKNEE, BodyPartTypes.RIGHTTHIGH));
        bodyPartList.add(new BodyPart("calf", "Lower leg", new ArrayList<BodyPartStatuses>(), new ArrayList<BodyPartAbilities>(), new ArrayList<BodyPartTraits>(), 3.75, BodyPartTypes.RIGHTCALF, BodyPartTypes.RIGHTKNEE));
        bodyPartList.add(new BodyPart("foot", "", new ArrayList<BodyPartStatuses>(), new ArrayList<BodyPartAbilities>(), new ArrayList<BodyPartTraits>(), 1.0725, BodyPartTypes.RIGHTFOOT, BodyPartTypes.RIGHTCALF));
        bodyPartList.add(new BodyPart("pinkie toe", "Smallest outermost toe", new ArrayList<BodyPartStatuses>(), new ArrayList<BodyPartAbilities>(), new ArrayList<BodyPartTraits>(), .0715, BodyPartTypes.RIGHTPINKIETOE, BodyPartTypes.RIGHTFOOT));
        bodyPartList.add(new BodyPart("ring toe", "Second from outermost toe", new ArrayList<BodyPartStatuses>(), new ArrayList<BodyPartAbilities>(), new ArrayList<BodyPartTraits>(), .0715, BodyPartTypes.RIGHTRINGTOE, BodyPartTypes.RIGHTFOOT));
        bodyPartList.add(new BodyPart("middle toe", "", new ArrayList<BodyPartStatuses>(), new ArrayList<BodyPartAbilities>(), new ArrayList<BodyPartTraits>(), .0715, BodyPartTypes.RIGHTMIDDLETOE, BodyPartTypes.RIGHTFOOT));
        bodyPartList.add(new BodyPart("pointer toe", "Second from innermost toe", new ArrayList<BodyPartStatuses>(), new ArrayList<BodyPartAbilities>(), new ArrayList<BodyPartTraits>(), .0715, BodyPartTypes.RIGHTMIDDLETOE, BodyPartTypes.RIGHTFOOT));
        bodyPartList.add(new BodyPart("big toe", "Widest innermost toe", new ArrayList<BodyPartStatuses>(), new ArrayList<BodyPartAbilities>(), new ArrayList<BodyPartTraits>(), .0715, BodyPartTypes.RIGHTBIGTOE, BodyPartTypes.RIGHTFOOT));
        bodyPartList.add(new BodyPart("neck", "", new ArrayList<BodyPartStatuses>(), new ArrayList<BodyPartAbilities>(), new ArrayList<BodyPartTraits>(), 1.26, BodyPartTypes.NECK, BodyPartTypes.TORSO));
        bodyPartList.add(new BodyPart("head", "", new ArrayList<BodyPartStatuses>(), new ArrayList<BodyPartAbilities>(), new ArrayList<BodyPartTraits>(), 7, BodyPartTypes.HEAD, BodyPartTypes.TORSO));

    }
    /*
        What I could do is create a different class for each race
        then I could compare a person with the expectation to point out interesting traits
        then the AI could look at someone, see they have 1 arm, see that they should have 2
        and report that back to the player in narration
     */

    //how do we define what is being worn? it could get messy putting a glove object on all the individual fingers...
    //maybe clothing defines the body parts they cover, and you put the item into a
    //hierarchy kinda like parenting in animation. So if you look for whether or not a finger
    //is protected, you could look up the heirarchy and see if there are gloves on the forearm

    /*
    torso  --shirt/chest armor here
      waist
        leftThigh (^waist)
          Knee
            Calf --shoes here
              Foot
                pinkieToe
                  fingerNail
                ringToe
                  fingerNail
                middleToe
                  fingerNail
                pointerToe
                  fingerNail
                bigToe
                  fingerNail
        rightThigh (^waist)
          Knee
            Calf --shoes here
              Foot
                pinkieToe
                  fingerNail
                ringToe
                  fingerNail
                middleToe
                  fingerNail
                pointerToe
                  fingerNail
                bigToe
                  fingerNail
      back (^torso)
      neck (^torso) --amulet here
        skull --helmet here
          brain
          jaw
            lips
            teeth
          leftEye
          rightEye
          leftEyebrow
          rightEyebrow
          nose
          hair
      leftShoulder (^torso)
        leftUpperarm (shoulders)
          elbow
            forearm  --gloves here
              wrist
                palm
                  pinkieFinger
                    fingerNail
                  ringFinger
                    fingerNail
                  middleFinger
                    fingerNail
                  pointerFinger
                    fingerNail
                  thumb
                    fingerNail
      rightShoulder (^torso)
         rightUpperarm
          elbow
            forearm  --gloves here
              wrist
                palm
                  pinkieFinger
                    fingerNail
                  ringFinger
                    fingerNail
                  middleFinger
                    fingerNail
                  pointerFinger
                    fingerNail
                  thumb
                    fingerNail
      heart (^torso)
      lungs
      stomach
      smallIntestine
      largeIntestine
      kidney
      liver
      bladder
     */
    //

    //define their clothes, their gear
    /*
    body parts:
    head
    neck
    shoulder
    chest
    upperarm
    elbow
    lowerarm
    wrist
    hand
    fingers
    waist
    upperleg
    knee
    lowerleg
    ankle
    foot
    toe
    ear
    eye
    nose
    tongue
    tail
    wing

     */
}
