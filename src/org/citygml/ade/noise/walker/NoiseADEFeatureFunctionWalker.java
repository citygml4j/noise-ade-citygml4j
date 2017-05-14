package org.citygml.ade.noise.walker;

import org.citygml.ade.noise.model.NoiseCityFurnitureSegment;
import org.citygml.ade.noise.model.NoiseCityFurnitureSegmentPropertyElement;
import org.citygml.ade.noise.model.NoiseRailwaySegment;
import org.citygml.ade.noise.model.NoiseRailwaySegmentPropertyElement;
import org.citygml.ade.noise.model.NoiseRoadSegment;
import org.citygml.ade.noise.model.NoiseRoadSegmentPropertyElement;
import org.citygml.ade.noise.model.Train;
import org.citygml.ade.noise.model.TrainProperty;
import org.citygml4j.model.citygml.ade.binding.ADEWalker;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.transportation.AbstractTransportationObject;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.util.walker.FeatureFunctionWalker;

public class NoiseADEFeatureFunctionWalker<T> implements ADEWalker<FeatureFunctionWalker<T>> {
	private FeatureFunctionWalker<T> walker;

	@Override
	public void setParentWalker(FeatureFunctionWalker<T> walker) {
		this.walker = walker;
	}

	public T apply(NoiseCityFurnitureSegment noiseCityFurnitureSegment) {
		return walker.apply((AbstractCityObject)noiseCityFurnitureSegment);
	}

	public T apply(NoiseRoadSegment noiseRoadSegment) {
		return walker.apply((AbstractTransportationObject)noiseRoadSegment);
	}

	public T apply(NoiseRailwaySegment noiseRailwaySegment) {
		T object = walker.apply((AbstractTransportationObject)noiseRailwaySegment);
		if (object != null)
			return object;
		
		if (noiseRailwaySegment.isSetUsedBy()) {
			for (TrainProperty trainProperty : noiseRailwaySegment.getUsedBy()) {
				object = walker.apply((FeatureProperty<?>)trainProperty);
				if (object != null)
					return object;
			}
		}
		
		return null;
	}
	
	public T apply(Train train) {
		return walker.apply((AbstractFeature)train);
	}

	public T apply(NoiseCityFurnitureSegmentPropertyElement noiseCityFurnitureSegmentPropertyElement) {
		return walker.apply((FeatureProperty<?>)noiseCityFurnitureSegmentPropertyElement.getValue());
	}
	
	public T apply(NoiseRoadSegmentPropertyElement noiseRoadSegmentPropertyElement) {
		return walker.apply((FeatureProperty<?>)noiseRoadSegmentPropertyElement.getValue());
	}

	public T apply(NoiseRailwaySegmentPropertyElement noiseRailwaySegmentPropertyElement) {
		return walker.apply((FeatureProperty<?>)noiseRailwaySegmentPropertyElement.getValue());
	}

}
