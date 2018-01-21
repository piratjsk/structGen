package net.piratjsk.structgen.parts;

import net.piratjsk.structgen.Location;

import java.util.Random;
import java.util.Set;

public class RandomPartPart implements Part {

    private double x, y, z;
    private final Set<Part> parts;


    public RandomPartPart(double x, double y, double z, final Set<Part> parts) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.parts = parts;
    }

    @Override
    public double getRelativeX() {
        return this.x;
    }

    @Override
    public double getRelativeY() {
        return this.y;
    }

    @Override
    public double getRelativeZ() {
        return this.z;
    }

    @Override
    public void setRelativeX(double x) {
        this.x = x;
    }

    @Override
    public void setRelativeY(double y) {
        this.y = y;
    }

    @Override
    public void setRelativeZ(double z) {
        this.z = z;
    }

    @Override
    public void putAt(final Location pointOfOrigin, final Random random) {
        this.choosePart(random).putAt(pointOfOrigin, random);
    }

    private Part choosePart(final Random random) {
        int rand = random.nextInt(this.parts.size()-1);
        return (Part) this.parts.toArray()[rand];
    }
}
