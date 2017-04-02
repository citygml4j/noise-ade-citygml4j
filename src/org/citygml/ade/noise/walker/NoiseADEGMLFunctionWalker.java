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
import org.citygml4j.util.walker.GMLFunctionWalker;

public class NoiseADEGMLFunctionWalker<T> implements ADEWalker<GMLFunctionWalker<T>> {
	private GMLFunctionWalker<T> walker;

	@Override
	public void setParentWalker(GMLFunctionWalker<T> walker) {
		this.walker = walker;
	}

	@Override
	public String getNamespaceURI() {
		return NoiseADEContext.NAMESPACE_URI;
	}

	public T applyNoiseCityFurnitureSegment(NoiseCityFurnitureSegment noiseCityFurnitureSegment) {
		T object = walker.apply((AbstractCityObject)noiseCityFurnitureSegment);
		if (object != null)
			return object;
		
		if (noiseCityFurnitureSegment.isSetLod0BaseLine())
			return walker.apply(noiseCityFurnitureSegment.getLod0BaseLine());
		
		return null;
	}

	public T applyNoiseRoadSegment(NoiseRoadSegment noiseRoadSegment) {
		T object = walker.apply((AbstractTransportationObject)noiseRoadSegment);
		if (object != null)
			return object;
		
		if (noiseRoadSegment.isSetLod0BaseLine())
			return walker.apply(noiseRoadSegment.getLod0BaseLine());
		
		return null;
	}

	public T applyNoiseRailwaySegment(NoiseRailwaySegment noiseRailwaySegment) {
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
