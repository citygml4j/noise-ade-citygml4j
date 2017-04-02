package org.citygml.ade.noise.model;

import org.citygml.ade.noise.NoiseADEContext;
import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.ade.binding.ADEGenericApplicationProperty;

public class NoiseRailwaySegmentPropertyElement extends ADEGenericApplicationProperty<NoiseRailwaySegmentProperty> {

	public NoiseRailwaySegmentPropertyElement() {
	}
	
	public NoiseRailwaySegmentPropertyElement(NoiseRailwaySegmentProperty property) {
		super(property);
	}
	
	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new NoiseRailwaySegmentPropertyElement(), copyBuilder);
	}

	@Override
	public String getNamespaceURI() {
		return NoiseADEContext.NAMESPACE_URI;
	}
	
}
