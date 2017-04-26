package org.citygml.ade.noise.model;

import org.citygml.ade.noise.NoiseADEContext;
import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.ade.binding.ADEGenericApplicationProperty;
import org.citygml4j.model.gml.basicTypes.Measure;

public class BuildingReflectionCorrectionProperty extends ADEGenericApplicationProperty<Measure> {

	public BuildingReflectionCorrectionProperty() {
	}
	
	public BuildingReflectionCorrectionProperty(Measure value) {
		super(value);
	}
	
	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new BuildingReflectionCorrectionProperty(), copyBuilder);
	}

	@Override
	public String getNamespaceURI() {
		return NoiseADEContext.NAMESPACE_URI;
	}
	
}
