package com.masters_of_destiny.Ai.People;

/**
 * A distribution will define what is "normal" for a stat
 * This is helpful in making expectations, but also in making
 * certain things more common and others more rare.
 *
 * This is modeled after a bell curve.
 * Bell curves are symmetrical
 * 2 standard deviations should encompass ~95% of the total
 */
public class Distribution {
    public String name;
    public double median; // the "peak" of the curve
    public double standardDeviation;
    public double minValue;
    public double maxValue;
    /*

     */
    // double val = Random.nextGaussian() * standardDeviation + median;

    /*
        Technically +/- infinity is possible, but is infinitely improbable
        So we add cutoffs here on the off chance of a wild number

        standard deviation is:
        +/- 6 deviations (12 total) encompasses 'foo' % of the range
        +or- 1: encompasses 34.13447460685 %
        +or- 2: encompasses 13.59051219835 %
        +or- 3: encompasses 2.14002339165 %
        +or- 4: encompasses 0.13182267895 %
        +or- 5: encompasses 0.00313845905 %
        +or- 6: encompasses 0.0000285665 %
     */

}
