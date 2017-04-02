package org.citygml.ade.noise.model;

import java.math.BigInteger;
import java.util.List;

import org.citygml.ade.noise.NoiseADEContext;
import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.ade.binding.ADEGenericApplicationProperty;

public class BuildingImmissionPoints extends ADEGenericApplicationProperty<List<BigInteger>> {

	public BuildingImmissionPoints() {
	}
	
	public BuildingImmissionPoints(List<BigInteger> value) {
		super(value);
	}
	
	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new BuildingImmissionPoints(), copyBuilder);
	}

	@Override
	public String getNamespaceURI() {
		return NoiseADEContext.NAMESPACE_URI;
	}
	
}
