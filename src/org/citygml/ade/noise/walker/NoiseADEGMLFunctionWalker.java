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
import org.citygml4j.util.walker.GMLFunctionWalker;

public class NoiseADEGMLFunctionWalker<T> implements ADEWalker<GMLFunctionWalker<T>> {
	private GMLFunctionWalker<T> walker;

	@Override
	public void setParentWalker(GMLFunctionWalker<T> walker) {
		this.walker = walker;
	}

	public T apply(NoiseCityFurnitureSegment noiseCityFurnitureSegment) {
		T object = walker.apply((AbstractCityObject)noiseCityFurnitureSegment);
		if (object != null)
			return object;
		
		if (noiseCityFurnitureSegment.isSetLod0BaseLine()) {
			object = walker.apply(noiseCityFurnitureSegment.getLod0BaseLine());
			if (object != null)
				return object;
		}
		
		return null;
	}

	public T apply(NoiseRoadSegment noiseRoadSegment) {
		T object = walker.apply((AbstractTransportationObject)noiseRoadSegment);
		if (object != null)
			return object;
		
		if (noiseRoadSegment.isSetLod0BaseLine()) {
			object = walker.apply(noiseRoadSegment.getLod0BaseLine());
			if (object != null)
				return object;
		}
		
		return null;
	}

	public T apply(NoiseRailwaySegment noiseRailwaySegment) {
		T object = walker.apply((AbstractTransportationObject)noiseRailwaySegment);
		if (object != null)
			return object;
		
		if (noiseRailwaySegment.isSetLod0BaseLine()) {
			object = walker.apply(noiseRailwaySegment.getLod0BaseLine());
			if (object != null)
				return object;
		}
		
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
