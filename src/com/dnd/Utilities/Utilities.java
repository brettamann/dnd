package com.dnd.Utilities;

import com.dnd.DataObjects.Items.Weapon;
import java.util.List;

public class Utilities {
    public boolean weaponListContainsType(final List<Weapon> list, final String name) {
        //https://stackoverflow.com/questions/18852059/java-list-containsobject-with-field-value-equal-to-x
        return list.stream().filter(o -> o.type.equals(name)).findFirst().isPresent();
    }
}
