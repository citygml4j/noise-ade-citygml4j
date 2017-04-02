package org.citygml.ade.noise.model;

import java.math.BigInteger;

import org.citygml.ade.noise.NoiseADEContext;
import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.ade.binding.ADEGenericApplicationProperty;

public class BuildingHabitants extends ADEGenericApplicationProperty<BigInteger> {

	public BuildingHabitants() {
	}
	
	public BuildingHabitants(BigInteger value) {
		super(value);
	}
	
	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new BuildingHabitants(), copyBuilder);
	}

	@Override
	public String getNamespaceURI() {
		return NoiseADEContext.NAMESPACE_URI;
	}
	
}
