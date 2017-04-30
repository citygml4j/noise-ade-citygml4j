package org.citygml.ade.noise.model;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.ade.binding.ADEGenericApplicationProperty;
import org.citygml4j.model.gml.basicTypes.Measure;

public class BuildingLNightEqProperty extends ADEGenericApplicationProperty<Measure> {

	public BuildingLNightEqProperty() {
	}
	
	public BuildingLNightEqProperty(Measure value) {
		super(value);
	}
	
	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new BuildingLNightEqProperty(), copyBuilder);
	}
	
}
