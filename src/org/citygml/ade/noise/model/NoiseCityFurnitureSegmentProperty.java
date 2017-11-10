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
package org.citygml.ade.noise.model;

import org.citygml.ade.noise.model.module.NoiseADEModule;
import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.module.ade.ADEModule;

public class NoiseCityFurnitureSegmentProperty extends FeatureProperty<NoiseCityFurnitureSegment> implements ADEModelObject {

	public NoiseCityFurnitureSegmentProperty() {
	}
	
	public NoiseCityFurnitureSegmentProperty(NoiseCityFurnitureSegment noiseCityFurnitureSegment) {
		super(noiseCityFurnitureSegment);
	}
	
	public NoiseCityFurnitureSegmentProperty(String href) {
		super(href);
	}
	
	public NoiseCityFurnitureSegment getNoiseCityFurnitureSegment() {
		return super.getObject();
	}

	public boolean isSetNoiseCityFurnitureSegment() {
		return super.isSetObject();
	}

	public void setNoiseCityFurnitureSegment(NoiseCityFurnitureSegment noiseCityFurnitureSegment) {
		super.setObject(noiseCityFurnitureSegment);
	}

	public void unsetNoiseCityFurnitureSegment() {
		super.unsetObject();
	}

	@Override
	public Class<NoiseCityFurnitureSegment> getAssociableClass() {
		return NoiseCityFurnitureSegment.class;
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new NoiseCityFurnitureSegmentProperty(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		NoiseCityFurnitureSegmentProperty copy = (target == null) ? new NoiseCityFurnitureSegmentProperty() : (NoiseCityFurnitureSegmentProperty)target;
		return super.copyTo(copy, copyBuilder);
	}
	
	@Override
	public ADEModule getADEModule() {
		return NoiseADEModule.v1_0;
	}

}
