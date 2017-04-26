package org.citygml.ade.noise.model;

import java.math.BigInteger;
import java.util.List;

import org.citygml.ade.noise.NoiseADEContext;
import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.ade.binding.ADEGenericApplicationProperty;

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
	public String getNamespaceURI() {
		return NoiseADEContext.NAMESPACE_URI;
	}
	
}
