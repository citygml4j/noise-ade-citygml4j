/*
 * module-noise-ade - Noise ADE module for citygml4j
 * https://github.com/citygml4j/module-noise-ade
 *
 * module-noise-ade is part of the citygml4j project
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
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.LodRepresentation;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.basicTypes.Measure;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.geometry.primitives.CurveProperty;
import org.citygml4j.model.gml.measures.Length;
import org.citygml4j.util.bbox.BoundingBoxOptions;

public class NoiseCityFurnitureSegment extends AbstractCityObject implements ADEModelObject {
	private Code type;
	private String reflection;
	private Measure reflectionCorrection;
	private Length height;
	private Length distance;
	private CurveProperty lod0BaseLine;
	
	public Code getType() {
		return type;
	}
	
	public boolean isSetType() {
		return type != null;
	}

	public void setType(Code type) {
		if (type != null)
			type.setParent(this);
		
		this.type = type;
	}

	public String getReflection() {
		return reflection;
	}
	
	public boolean isSetReflection() {
		return reflection != null;
	}

	public void setReflection(String reflection) {
		this.reflection = reflection;
	}

	public Measure getReflectionCorrection() {
		return reflectionCorrection;
	}
	
	public boolean isSetReflectionCorrection() {
		return reflectionCorrection != null;
	}

	public void setReflectionCorrection(Measure reflectionCorrection) {
		if (reflectionCorrection != null)
			reflectionCorrection.setParent(this);
		
		this.reflectionCorrection = reflectionCorrection;
	}

	public Length getHeight() {
		return height;
	}
	
	public boolean isSetHeight() {
		return height != null;
	}

	public void setHeight(Length height) {
		if (height != null)
			height.setParent(this);
		
		this.height = height;
	}

	public Length getDistance() {
		return distance;
	}
	
	public boolean isSetDistance() {
		return distance != null;
	}

	public void setDistance(Length distance) {
		if (distance != null)
			distance.setParent(this);
		
		this.distance = distance;
	}

	public CurveProperty getLod0BaseLine() {
		return lod0BaseLine;
	}
	
	public boolean isSetLod0BaseLine() {
		return lod0BaseLine != null;
	}

	public void setLod0BaseLine(CurveProperty lod0BaseLine) {
		if (lod0BaseLine != null)
			lod0BaseLine.setParent(this);
		
		this.lod0BaseLine = lod0BaseLine;
	}

	@Override
	public BoundingShape calcBoundedBy(BoundingBoxOptions options) {
		BoundingShape boundedBy = super.calcBoundedBy(options);
		if (options.isUseExistingEnvelopes() && !boundedBy.isEmpty())
			return boundedBy;
		
		if (lod0BaseLine != null && lod0BaseLine.isSetCurve())
			boundedBy.updateEnvelope(lod0BaseLine.getCurve().calcBoundingBox());
		
		if (options.isAssignResultToFeatures())
			setBoundedBy(boundedBy);
		
		return boundedBy;
	}
	
	@Override
	public LodRepresentation getLodRepresentation() {
		LodRepresentation lodRepresentation = new LodRepresentation();
		
		if (lod0BaseLine != null)
			lodRepresentation.addRepresentation(0, lod0BaseLine);
		
		return lodRepresentation;
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new NoiseCityFurnitureSegment(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		NoiseCityFurnitureSegment copy = (target == null) ? new NoiseCityFurnitureSegment() : (NoiseCityFurnitureSegment)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetType()) {
			copy.setType((Code)copyBuilder.copy(type));
			if (copy.getType() == type)
				type.setParent(this);
		}
		
		if (isSetReflection())
			copy.setReflection(copyBuilder.copy(reflection));

		if (isSetReflectionCorrection()) {
			copy.setReflectionCorrection((Measure)copyBuilder.copy(reflectionCorrection));
			if (copy.getReflectionCorrection() == reflectionCorrection)
				reflectionCorrection.setParent(this);
		}
		
		if (isSetHeight()) {
			copy.setHeight((Length)copyBuilder.copy(height));
			if (copy.getHeight() == height)
				height.setParent(this);
		}

		if (isSetDistance()) {
			copy.setDistance((Length)copyBuilder.copy(distance));
			if (copy.getDistance() == distance)
				distance.setParent(this);
		}

		if (isSetLod0BaseLine()) {
			copy.setLod0BaseLine((CurveProperty)copyBuilder.copy(lod0BaseLine));
			if (copy.getLod0BaseLine() == lod0BaseLine)
				lod0BaseLine.setParent(this);
		}
		
		return copy;
	}

	@Override
	public void accept(FeatureVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public <T> T accept(FeatureFunctor<T> visitor) {
		return visitor.apply(this);
	}

	@Override
	public void accept(GMLVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public <T> T accept(GMLFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
