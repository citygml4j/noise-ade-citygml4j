package org.citygml.ade.noise.model;

import java.math.BigInteger;

import org.citygml.ade.noise.model.module.NoiseADEModule;
import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.ade.binding.ADEGenericApplicationProperty;
import org.citygml4j.model.module.ade.ADEModule;

public class BuildingHabitantsProperty extends ADEGenericApplicationProperty<BigInteger> {

	public BuildingHabitantsProperty() {
	}
	
	public BuildingHabitantsProperty(BigInteger value) {
		super(value);
	}
	
	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new BuildingHabitantsProperty(), copyBuilder);
	}
	
	@Override
	public ADEModule getADEModule() {
		return NoiseADEModule.v1_0;
	}
	
}
