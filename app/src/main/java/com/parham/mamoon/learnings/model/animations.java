package com.parham.mamoon.learnings.model;

/**
 * Created by m.amoon on 12/1/2016.
 */

public class animations {
    int setDuration , delay;
    float Firstalpha,SecondAlpha;

    public animations() {
    }

    public int getSetDuration() {
        return setDuration;
    }

    public void setSetDuration(int setDuration) {
        this.setDuration = setDuration;
    }

    public float getFirstalpha() {
        return Firstalpha;
    }

    public void setFirstalpha(float firstalpha) {
        Firstalpha = firstalpha;
    }

    public float getSecondAlpha() {
        return SecondAlpha;
    }

    public void setSecondAlpha(float secondAlpha) {
        SecondAlpha = secondAlpha;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }
}
