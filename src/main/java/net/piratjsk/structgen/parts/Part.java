package net.piratjsk.structgen.parts;

import net.piratjsk.structgen.Location;

import java.util.Random;

public interface Part {
	double getRelativeX();
	double getRelativeY();
	double getRelativeZ();
	void setRelativeX(double x);
	void setRelativeY(double y);
	void setRelativeZ(double z);
	default void setRelativePos(double x, double y, double z) {
        this.setRelativeX(x);
        this.setRelativeY(y);
        this.setRelativeZ(z);
    }
	void putAt(Location pointOfOrigin, Random random);
}