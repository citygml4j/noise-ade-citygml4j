/*
 * noise-ade-citygml4j - Noise ADE module for citygml4j
 * https://github.com/citygml4j/module-noise-ade
 *
 * noise-ade-citygml4j is part of the citygml4j project
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
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

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.gml.feature.FeatureProperty;

public class NoiseRoadSegmentProperty extends FeatureProperty<NoiseRoadSegment> implements ADEModelObject {

	public NoiseRoadSegmentProperty() {
	}
	
	public NoiseRoadSegmentProperty(NoiseRoadSegment noiseRoadSegment) {
		super(noiseRoadSegment);
	}
	
	public NoiseRoadSegmentProperty(String href) {
		super(href);
	}
	
	public NoiseRoadSegment getNoiseRoadSegment() {
		return super.getObject();
	}

	public boolean isSetNoiseRoadSegment() {
		return super.isSetObject();
	}

	public void setNoiseRoadSegment(NoiseRoadSegment noiseRoadSegment) {
		super.setObject(noiseRoadSegment);
	}

	public void unsetNoiseRoadSegment() {
		super.unsetObject();
	}

	@Override
	public Class<NoiseRoadSegment> getAssociableClass() {
		return NoiseRoadSegment.class;
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new NoiseRoadSegmentProperty(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		NoiseRoadSegmentProperty copy = (target == null) ? new NoiseRoadSegmentProperty() : (NoiseRoadSegmentProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
