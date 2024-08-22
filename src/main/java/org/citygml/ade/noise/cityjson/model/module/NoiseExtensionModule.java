/*
 * noise-ade-citygml4j - Noise ADE module for citygml4j
 * https://github.com/citygml4j/noise-ade-citygml4j
 *
 * noise-ade-citygml4j is part of the citygml4j project
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml.ade.noise.cityjson.model.module;

import com.google.gson.reflect.TypeToken;
import org.citygml.ade.noise.NoiseADEContext;
import org.citygml.ade.noise.cityjson.model.MeasureType;
import org.citygml.ade.noise.cityjson.model.NoiseCityFurnitureSegmentType;
import org.citygml.ade.noise.cityjson.model.NoiseRailwaySegmentType;
import org.citygml.ade.noise.cityjson.model.NoiseRoadSegmentType;
import org.citygml4j.builder.cityjson.extension.CityJSONExtensionModule;
import org.citygml4j.builder.cityjson.extension.ExtensionModuleVersion;
import org.citygml4j.cityjson.extension.ExtensibleType;
import org.citygml4j.cityjson.feature.AbstractBuildingType;
import org.citygml4j.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.cityjson.geometry.SemanticsType;

import java.lang.reflect.Type;
import java.math.BigInteger;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NoiseExtensionModule implements CityJSONExtensionModule {
    private final Map<String, Class<? extends AbstractCityObjectType>> cityObjects;
    private final Map<Class<? extends ExtensibleType>, Map<String, Type>> properties;
    private final ExtensionModuleVersion version = new ExtensionModuleVersion(1, 0);

    public NoiseExtensionModule() {
        cityObjects = new HashMap<>();
        cityObjects.put("+NoiseCityFurnitureSegment", NoiseCityFurnitureSegmentType.class);
        cityObjects.put("+NoiseRoadSegment", NoiseRoadSegmentType.class);
        cityObjects.put("+NoiseRailwaySegment", NoiseRailwaySegmentType.class);

        properties = new HashMap<>();
        Map<String, Type> abstractBuilding = new HashMap<>();
        abstractBuilding.put("+noise-buildingReflection", String.class);
        abstractBuilding.put("+noise-buildingReflectionCorrection", MeasureType.class);
        abstractBuilding.put("+noise-buildingLDenMax", MeasureType.class);
        abstractBuilding.put("+noise-buildingLDenMin", MeasureType.class);
        abstractBuilding.put("+noise-buildingLDenEq", MeasureType.class);
        abstractBuilding.put("+noise-buildingLNightMax", MeasureType.class);
        abstractBuilding.put("+noise-buildingLNightMin", MeasureType.class);
        abstractBuilding.put("+noise-buildingLNightEq", MeasureType.class);
        abstractBuilding.put("+noise-buildingHabitants", Integer.class);
        abstractBuilding.put("+noise-buildingAppartments", Integer.class);
        abstractBuilding.put("+noise-buildingImmissionPoints", new TypeToken<List<BigInteger>>() {
        }.getType());
        abstractBuilding.put("+noise-remark", String.class);
        properties.put(AbstractBuildingType.class, abstractBuilding);
    }

    @Override
    public String getIdentifier() {
        return "Noise";
    }

    @Override
    public String getSchemaURI() {
        return "noise.json";
    }

    @Override
    public ExtensionModuleVersion getVersion() {
        return version;
    }

    @Override
    public URL getSchemaResource() {
        return NoiseADEContext.class.getResource("/org/citygml/ade/noise/schema/cityjson/noise.json");
    }

    @Override
    public Map<String, Class<? extends AbstractCityObjectType>> getCityObjects() {
        return cityObjects;
    }

    @Override
    public Map<String, Class<? extends SemanticsType>> getSemanticSurfaces() {
        return null;
    }

    @Override
    public Map<Class<? extends ExtensibleType>, Map<String, Type>> getExtensionProperties() {
        return properties;
    }
}
