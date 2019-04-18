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

package org.citygml.ade.noise.cityjson.model;

import com.google.gson.annotations.SerializedName;
import org.citygml4j.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.cityjson.feature.Attributes;
import org.citygml4j.cityjson.geometry.GeometryTypeName;
import org.citygml4j.util.gmlid.DefaultGMLIdManager;

import java.util.HashMap;
import java.util.Map;

public class NoiseRailwaySegmentType extends AbstractCityObjectType {
    @SerializedName("usedBy")
    private Map<String, TrainType> trains;

    public boolean isSetTrains() {
        return trains != null;
    }

    public Map<String, TrainType> getTrains() {
        return trains;
    }

    public void addTrain(TrainType train) {
        if (trains == null)
            trains = new HashMap<>();

        if (!train.isSetGmlId())
            train.setGmlId(DefaultGMLIdManager.getInstance().generateUUID());

        trains.put(train.getGmlId(), train);
    }

    public void setTrains(Map<String, TrainType> trains) {
        this.trains = trains;
    }

    @Override
    public Attributes newAttributes() {
        return super.newAttributes(new NoiseRailwaySegmentAttributes());
    }

    @Override
    public NoiseRailwaySegmentAttributes getAttributes() {
        return (NoiseRailwaySegmentAttributes) super.getAttributes();
    }

    @Override
    public boolean isValidGeometryType(GeometryTypeName type) {
        return type == GeometryTypeName.MULTI_LINE_STRING;
    }
}
