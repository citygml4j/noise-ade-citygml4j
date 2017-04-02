package org.citygml.ade.noise.walker;

import org.citygml.ade.noise.NoiseADEContext;
import org.citygml.ade.noise.model.NoiseCityFurnitureSegment;
import org.citygml.ade.noise.model.NoiseCityFurnitureSegmentProperty;
import org.citygml.ade.noise.model.NoiseCityFurnitureSegmentPropertyElement;
import org.citygml.ade.noise.model.NoiseRailwaySegment;
import org.citygml.ade.noise.model.NoiseRailwaySegmentProperty;
import org.citygml.ade.noise.model.NoiseRailwaySegmentPropertyElement;
import org.citygml.ade.noise.model.NoiseRoadSegment;
import org.citygml.ade.noise.model.NoiseRoadSegmentProperty;
import org.citygml.ade.noise.model.NoiseRoadSegmentPropertyElement;
import org.citygml.ade.noise.model.Train;
import org.citygml.ade.noise.model.TrainProperty;
import org.citygml4j.model.citygml.ade.binding.ADEWalker;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.transportation.AbstractTransportationObject;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.util.walker.FeatureFunctionWalker;

public class NoiseADEFeatureFunctionWalker<T> implements ADEWalker<FeatureFunctionWalker<T>> {
	private FeatureFunctionWalker<T> walker;

	@Override
	public void setParentWalker(FeatureFunctionWalker<T> walker) {
		this.walker = walker;
	}

	@Override
	public String getNamespaceURI() {
		return NoiseADEContext.NAMESPACE_URI;
	}

	public T applyNoiseCityFurnitureSegment(NoiseCityFurnitureSegment noiseCityFurnitureSegment) {
		return walker.apply((AbstractCityObject)noiseCityFurnitureSegment);
	}

	public T applyNoiseRoadSegment(NoiseRoadSegment noiseRoadSegment) {
		return walker.apply((AbstractTransportationObject)noiseRoadSegment);
	}

	public T applyNoiseRailwaySegment(NoiseRailwaySegment noiseRailwaySegment) {
		T object = walker.apply((AbstractTransportationObject)noiseRailwaySegment);
		if (object != null)
			return object;
		
		if (noiseRailwaySegment.isSetUsedBy()) {
			for (TrainProperty trainProperty : noiseRailwaySegment.getUsedBy()) {
				object = applyTrain(trainProperty.getTrain());
				if (object != null)
					return object;
			}
		}
		
		return null;
	}
	
	public T applyTrain(Train train) {
		return walker.apply((AbstractFeature)train);
	}

	public T applyNoiseCityFurnitureSegmentPropertyElement(NoiseCityFurnitureSegmentPropertyElement noiseCityFurnitureSegmentPropertyElement) {
		NoiseCityFurnitureSegmentProperty noiseCityFurnitureSegmentProperty = noiseCityFurnitureSegmentPropertyElement.getValue();
		if (noiseCityFurnitureSegmentProperty.isSetNoiseCityFurnitureSegment())
			return applyNoiseCityFurnitureSegment(noiseCityFurnitureSegmentProperty.getNoiseCityFurnitureSegment());
		
		return null;
	}
	
	public T applyNoiseRoadSegmentPropertyElement(NoiseRoadSegmentPropertyElement noiseRoadSegmentPropertyElement) {
		NoiseRoadSegmentProperty noiseRoadSegmentProperty = noiseRoadSegmentPropertyElement.getValue();
		if (noiseRoadSegmentProperty.isSetNoiseRoadSegment())
			return applyNoiseRoadSegment(noiseRoadSegmentProperty.getNoiseRoadSegment());
		
		return null;
	}

	public T applyNoiseRailwaySegmentPropertyElement(NoiseRailwaySegmentPropertyElement noiseRailwaySegmentPropertyElement) {
		NoiseRailwaySegmentProperty noiseRailwaySegmentProperty = noiseRailwaySegmentPropertyElement.getValue();
		if (noiseRailwaySegmentProperty.isSetNoiseRailwaySegment())
			return applyNoiseRailwaySegment(noiseRailwaySegmentProperty.getNoiseRailwaySegment());
		
		return null;
	}

}
