/*
 * noise-ade-citygml4j - Noise ADE module for citygml4j
 * https://github.com/citygml4j/noise-ade-citygml4j
 *
 * noise-ade-citygml4j is part of the citygml4j project
 *
 * Copyright 2013-2019 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml.ade.noise.walker;

import org.citygml.ade.noise.model.*;
import org.citygml4j.model.citygml.ade.binding.ADEWalker;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.transportation.AbstractTransportationObject;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.util.walker.FeatureWalker;

public class NoiseADEFeatureWalker implements ADEWalker<FeatureWalker> {
    private FeatureWalker walker;

    @Override
    public void setParentWalker(FeatureWalker walker) {
        this.walker = walker;
    }

    public void visit(NoiseCityFurnitureSegment noiseCityFurnitureSegment) {
        walker.visit((AbstractCityObject) noiseCityFurnitureSegment);
    }

    public void visit(NoiseRoadSegment noiseRoadSegment) {
        walker.visit((AbstractTransportationObject) noiseRoadSegment);
    }

    public void visit(NoiseRailwaySegment noiseRailwaySegment) {
        walker.visit((AbstractTransportationObject) noiseRailwaySegment);

        if (noiseRailwaySegment.isSetUsedBy()) {
            for (TrainProperty trainProperty : noiseRailwaySegment.getUsedBy())
                walker.visit((FeatureProperty<?>) trainProperty);
        }
    }

    public void visit(Train train) {
        walker.visit((AbstractFeature) train);
    }

    public void visit(NoiseCityFurnitureSegmentPropertyElement noiseCityFurnitureSegmentPropertyElement) {
        walker.visit((FeatureProperty<?>) noiseCityFurnitureSegmentPropertyElement.getValue());
    }

    public void visit(NoiseRoadSegmentPropertyElement noiseRoadSegmentPropertyElement) {
        walker.visit((FeatureProperty<?>) noiseRoadSegmentPropertyElement.getValue());
    }

    public void visit(NoiseRailwaySegmentPropertyElement noiseRailwaySegmentPropertyElement) {
        walker.visit((FeatureProperty<?>) noiseRailwaySegmentPropertyElement.getValue());
    }

}
