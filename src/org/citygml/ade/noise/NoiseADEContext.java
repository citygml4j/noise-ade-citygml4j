package org.citygml.ade.noise;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.citygml.ade.noise.transform.NoiseADEMarshaller;
import org.citygml.ade.noise.transform.NoiseADEUnmarshaller;
import org.citygml.ade.noise.walker.NoiseADEFeatureFunctionWalker;
import org.citygml.ade.noise.walker.NoiseADEFeatureWalker;
import org.citygml.ade.noise.walker.NoiseADEGMLFunctionWalker;
import org.citygml.ade.noise.walker.NoiseADEGMLWalker;
import org.citygml4j.model.citygml.ade.binding.ADEContext;
import org.citygml4j.model.citygml.ade.binding.ADEMarshaller;
import org.citygml4j.model.citygml.ade.binding.ADEUnmarshaller;
import org.citygml4j.model.citygml.ade.binding.ADEWalker;
import org.citygml4j.model.module.ade.ADEModule;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.util.walker.FeatureFunctionWalker;
import org.citygml4j.util.walker.FeatureWalker;
import org.citygml4j.util.walker.GMLFunctionWalker;
import org.citygml4j.util.walker.GMLWalker;

public class NoiseADEContext implements ADEContext {
	public static final String NAMESPACE_URI = "http://www.citygml.org/ade/noise_de/2.0";
	
	private final ADEModule module = new ADEModule(
			NAMESPACE_URI, 
			"noise", 
			"http://schemas.opengis.net/citygml/examples/2.0/ade/noise-ade/CityGML-NoiseADE.xsd", 
			CityGMLVersion.v2_0_0);
	private final NoiseADEMarshaller marshaller = new NoiseADEMarshaller();
	private final NoiseADEUnmarshaller unmarshaller = new NoiseADEUnmarshaller();
	
	@Override
	public ADEModule getADEModule() {
		return module;
	}

	@Override
	public List<String> getModelPackageNames() {
		return Arrays.asList(new String[]{"org.citygml.ade.noise.model"});
	}

	@Override
	public List<String> getJAXBPackageNames() {
		return Arrays.asList(new String[]{"org.citygml.ade.noise_de._2"});
	}

	@Override
	public URL getSchemaResource() {
		return NoiseADEContext.class.getResource("/org/citygml/ade/noise_de/_2/schema/CityGML-NoiseADE.xsd");
	}

	@Override
	public ADEMarshaller getADEMarshaller() {
		return marshaller;
	}

	@Override
	public ADEUnmarshaller getADEUnmarshaller() {
		return unmarshaller;
	}

	@Override
	public ADEWalker<FeatureWalker> getDefaultFeatureWalker() {
		return new NoiseADEFeatureWalker();
	}

	@Override
	public ADEWalker<GMLWalker> getDefaultGMLWalker() {
		return new NoiseADEGMLWalker();
	}

	@Override
	public <T> ADEWalker<FeatureFunctionWalker<T>> getDefaultFeatureFunctionWalker() {
		return new NoiseADEFeatureFunctionWalker<>();
	}

	@Override
	public <T> ADEWalker<GMLFunctionWalker<T>> getDefaultGMLFunctionWalker() {
		return new NoiseADEGMLFunctionWalker<>();
	}

}
