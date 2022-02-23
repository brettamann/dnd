package com.masters_of_destiny.Ai.Actions;

public class ActionExecutor {
    public void executeActionByTag(Action action) {
        for (ActionTags tag: action.actionTagsList) {
            switch (tag) {
            }
        }
    }
}

/*
How to organize this? as each individual action extends the action class,
so I can't just pass an action here and hope it works... it's probably much
better to just have the method sit on the individual action
 */