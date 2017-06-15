package org.citygml.ade.noise.model;

import org.citygml.ade.noise.model.module.NoiseADEModule;
import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.ade.binding.ADEGenericApplicationProperty;
import org.citygml4j.model.module.ade.ADEModule;

public class BuildingReflectionProperty extends ADEGenericApplicationProperty<String> {

	public BuildingReflectionProperty() {
	}
	
	public BuildingReflectionProperty(String value) {
		super(value);
	}
	
	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new BuildingReflectionProperty(), copyBuilder);
	}
	
	@Override
	public ADEModule getADEModule() {
		return NoiseADEModule.v1_0;
	}
	
}
