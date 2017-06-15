package org.citygml.ade.noise.model;

import java.math.BigInteger;
import java.util.List;

import org.citygml.ade.noise.model.module.NoiseADEModule;
import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.ade.binding.ADEGenericApplicationProperty;
import org.citygml4j.model.module.ade.ADEModule;

public class BuildingImmissionPointsProperty extends ADEGenericApplicationProperty<List<BigInteger>> {

	public BuildingImmissionPointsProperty() {
	}
	
	public BuildingImmissionPointsProperty(List<BigInteger> value) {
		super(value);
	}
	
	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new BuildingImmissionPointsProperty(), copyBuilder);
	}
	
	@Override
	public ADEModule getADEModule() {
		return NoiseADEModule.v1_0;
	}
	
}
