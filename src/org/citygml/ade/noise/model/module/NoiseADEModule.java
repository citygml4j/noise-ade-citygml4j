/*
 * module-noise-ade - Noise ADE module for citygml4j
 * https://github.com/citygml4j/module-noise-ade
 * 
 * module-noise-ade is part of the citygml4j project
 * 
 * Copyright 2013-2017 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml.ade.noise.model.module;

import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.namespace.QName;

import org.citygml.ade.noise.NoiseADEContext;
import org.citygml.ade.noise.model.NoiseCityFurnitureSegment;
import org.citygml.ade.noise.model.NoiseRailwaySegment;
import org.citygml.ade.noise.model.NoiseRoadSegment;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.module.ade.ADEModule;
import org.citygml4j.model.module.citygml.CityGMLVersion;

public class NoiseADEModule extends ADEModule {
	public static final NoiseADEModule v1_0 = new NoiseADEModule();
	
	private HashMap<String, Class<? extends AbstractFeature>> features;
	private HashSet<String> featureProperties;
	
	private NoiseADEModule() {
		super(NoiseADEContext.NAMESPACE_URI,
				"noise", 
				"http://schemas.opengis.net/citygml/examples/2.0/ade/noise-ade/CityGML-NoiseADE.xsd", 
				CityGMLVersion.v2_0_0);
		
		features = new HashMap<>();
		features.put("NoiseCityFurnitureSegment", NoiseCityFurnitureSegment.class);
		features.put("NoiseRoadSegment", NoiseRoadSegment.class);
		features.put("NoiseRailwaySegment", NoiseRailwaySegment.class);
		// note: we do not add Train to the list of features because it is not mapped
		// as global element in the XSD schema. This violates GML mapping rules.
		
		featureProperties = new HashSet<>();
		featureProperties.add("noiseCityFurnitureSegmentProperty");
		featureProperties.add("noiseRoadSegmentProperty");
		featureProperties.add("noiseRailwaySegmentProperty");
		// note: usedBy is neither added to the list because it only contains
		// Train elements.
	}
	
	@Override
	public URL getSchemaResource() {
		return NoiseADEContext.class.getResource("/org/citygml/ade/noise/bind/schema/CityGML-NoiseADE.xsd");
	}
	
	@Override
	public boolean hasFeatureProperty(String name) {
		return featureProperties.contains(name);
	}

	@Override
	public boolean hasFeature(String name) {
		return features.containsKey(name);
	}

	@Override
	public Class<? extends AbstractFeature> getFeatureClass(String name) {
		return features.get(name);
	}

	@Override
	public QName getFeatureName(Class<? extends AbstractFeature> featureClass) {
		Iterator<Entry<String, Class<? extends AbstractFeature>>> iter = features.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<String, Class<? extends AbstractFeature>> entry = iter.next();
			if (entry.getValue() == featureClass)
				return new QName(getNamespaceURI(), entry.getKey());
		}
		
		return null;
	}

	@Override
	public Map<String, Class<? extends AbstractFeature>> getFeatures() {
		return new HashMap<>(features);
	}

	@Override
	public boolean isTopLevelFeature(String name) {
		return false;
	}

}
