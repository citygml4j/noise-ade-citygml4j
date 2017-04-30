package org.citygml.ade.noise.model;

import java.math.BigInteger;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.ade.binding.ADEGenericApplicationProperty;

public class BuildingAppartmentsProperty extends ADEGenericApplicationProperty<BigInteger> {

	public BuildingAppartmentsProperty() {
	}
	
	public BuildingAppartmentsProperty(BigInteger value) {
		super(value);
	}
	
	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new BuildingAppartmentsProperty(), copyBuilder);
	}
	
}
