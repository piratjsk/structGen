package net.piratjsk.structgen.parts;

import net.piratjsk.structgen.Location;

public interface Part {
	double getRelativeX();
	double getRelativeY();
	double getRelativeZ();
	void putAt(Location pointOfOrigin);
}