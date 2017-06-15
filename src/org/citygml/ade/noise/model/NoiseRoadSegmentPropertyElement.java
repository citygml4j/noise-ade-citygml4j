package org.citygml.ade.noise.model;

import org.citygml.ade.noise.model.module.NoiseADEModule;
import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.ade.binding.ADEGenericApplicationProperty;
import org.citygml4j.model.module.ade.ADEModule;

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
	
	@Override
	public ADEModule getADEModule() {
		return NoiseADEModule.v1_0;
	}
	
}
