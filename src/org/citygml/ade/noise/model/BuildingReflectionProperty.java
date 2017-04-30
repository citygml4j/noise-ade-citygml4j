package org.citygml.ade.noise.model;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.ade.binding.ADEGenericApplicationProperty;

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
	
}
