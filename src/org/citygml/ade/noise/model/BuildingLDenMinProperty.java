package org.citygml.ade.noise.model;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.ade.binding.ADEGenericApplicationProperty;
import org.citygml4j.model.gml.basicTypes.Measure;

public class BuildingLDenMinProperty extends ADEGenericApplicationProperty<Measure> {

	public BuildingLDenMinProperty() {
	}
	
	public BuildingLDenMinProperty(Measure value) {
		super(value);
	}
	
	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new BuildingLDenMinProperty(), copyBuilder);
	}
	
}
