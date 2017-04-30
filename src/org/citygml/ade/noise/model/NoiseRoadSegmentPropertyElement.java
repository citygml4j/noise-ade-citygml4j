package org.citygml.ade.noise.model;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.ade.binding.ADEGenericApplicationProperty;

public class NoiseRoadSegmentPropertyElement extends ADEGenericApplicationProperty<NoiseRoadSegmentProperty> {

	public NoiseRoadSegmentPropertyElement() {
	}
	
	public NoiseRoadSegmentPropertyElement(NoiseRoadSegmentProperty property) {
		super(property);
	}
	
	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new NoiseRoadSegmentPropertyElement(), copyBuilder);
	}
	
}
