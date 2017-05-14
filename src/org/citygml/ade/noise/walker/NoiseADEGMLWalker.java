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
import org.citygml4j.util.walker.GMLWalker;

public class NoiseADEGMLWalker implements ADEWalker<GMLWalker> {
	private GMLWalker walker;

	@Override
	public void setParentWalker(GMLWalker walker) {
		this.walker = walker;
	}

	public void visit(NoiseCityFurnitureSegment noiseCityFurnitureSegment) {
		walker.visit((AbstractCityObject)noiseCityFurnitureSegment);
		
		if (noiseCityFurnitureSegment.isSetLod0BaseLine())
			walker.visit(noiseCityFurnitureSegment.getLod0BaseLine());
	}

	public void visit(NoiseRoadSegment noiseRoadSegment) {
		walker.visit((AbstractTransportationObject)noiseRoadSegment);
		
		if (noiseRoadSegment.isSetLod0BaseLine())
			walker.visit(noiseRoadSegment.getLod0BaseLine());
	}

	public void visit(NoiseRailwaySegment noiseRailwaySegment) {
		walker.visit((AbstractTransportationObject)noiseRailwaySegment);

		if (noiseRailwaySegment.isSetLod0BaseLine())
			walker.visit(noiseRailwaySegment.getLod0BaseLine());
		
		if (noiseRailwaySegment.isSetUsedBy()) {
			for (TrainProperty trainProperty : noiseRailwaySegment.getUsedBy())
				walker.visit((FeatureProperty<?>)trainProperty);
		}
	}
	
	public void visit(Train train) {
		walker.visit((AbstractFeature)train);
	}

	public void visit(NoiseCityFurnitureSegmentPropertyElement noiseCityFurnitureSegmentPropertyElement) {
		walker.visit((FeatureProperty<?>)noiseCityFurnitureSegmentPropertyElement.getValue());
	}
	
	public void visit(NoiseRoadSegmentPropertyElement noiseRoadSegmentPropertyElement) {
		walker.visit((FeatureProperty<?>)noiseRoadSegmentPropertyElement.getValue());
	}

	public void visit(NoiseRailwaySegmentPropertyElement noiseRailwaySegmentPropertyElement) {
		walker.visit((FeatureProperty<?>)noiseRailwaySegmentPropertyElement.getValue());
	}

}
