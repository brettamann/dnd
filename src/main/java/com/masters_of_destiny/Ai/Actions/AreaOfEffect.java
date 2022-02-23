package com.masters_of_destiny.Ai.Actions;

import com.masters_of_destiny.Ai.WorldBuilding.Vector;

/**
 * Almost every action has an area of effect, even if it's a tiny, single-target effect.
 * Even an arrow needs some sort of shape to determine how it moves and effects environment
 */
public class AreaOfEffect {
    public enum shapes {
        // Other
        POINT, // good for projectiles, takes X (range), Z
        TARGET, // affects whole target (molds shape to target), takes X (range)
        NONE, // basically no significant area of affect. Probably won't use

        // 2D, line, has no real width
        ARC, // Whole path in shape of an arrow arc
        INVERSEARC, // upside-down arc, probably only good for spells
        LINE, // takes X coord (length)
        HORIZON, // line, but it is perpendicular to the origin. Takes X (range), Y (length)

        // 2D, full, effects everything in the area it encompasses
        CIRCLE, // takes X coord
        SQUARE, // takes X coord
        RECTANGLE, // takes X, Y
        TRIANGLE, // takes X coord (equal sides), origin is a point
        VERTPLANE, // rectangle placed vertically. origin defines bottom. takes X, Z
        CONEFLAT, // takes X (width at max Y), Y (length, defines arc), arc is drawn automatically

        // 3D
        CUBE, // takes X coord (defines all dimensions equally)
        RECTANGULOID, // 3D, takes X, Y, Z
        PYRAMID, // takes X, Z coord (draw triangle, then height)
        CONICAL, // 3D, same as cone but accounts for height automatically based on X from origin
        SPHERE, // takes X coord (radius)
    }

    public enum lossTypes {
        LINELOSS, // no preference for any part
        PARABOLICLOSS, // stronger at center, weaker at edges (good for heat based or splashes)
        INVERSEPARABOLICLOSS, // weaker at center, stronger at edges
        NONE,
    }

    public shapes name;
    public Vector originPoint; // Where to start drawing the shape.
    public Vector size;
    public lossTypes lossType;
    /*
        maxes for x, y, z, of the area.
        the force of the vector determines loss at edges
        which is useful for an explosion, for instance, where at the center it's more powerful
        than at the edges. The value determines how much % of the effect is at the edge
     */
}
