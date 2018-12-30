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

import org.citygml.ade.noise.model.module.NoiseADEModule;
import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.builder.copy.ObjectCopier;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.citygml.core.LodRepresentation;
import org.citygml4j.model.citygml.transportation.AbstractTransportationObject;
import org.citygml4j.model.common.annotation.Lod;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.basicTypes.Measure;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.geometry.primitives.CurveProperty;
import org.citygml4j.model.gml.measures.Length;
import org.citygml4j.util.bbox.BoundingBoxOptions;
import org.citygml4j.util.bbox.SimpleBoundingBoxCalculator;
import org.citygml4j.util.lod.LodRepresentationBuilder;

import java.util.List;

public class NoiseRailwaySegment extends AbstractTransportationObject implements ADEModelObject {
	private String railwaySurfaceMaterial;
	private Measure railwaySurfaceCorrection;
	private Boolean bridge;
	private Boolean crossing;
	private Length curveRadius;
	private Measure additionalCorrectionSegment;
	@Lod(0) private CurveProperty lod0BaseLine;
	private List<TrainProperty> usedBy;

	public NoiseRailwaySegment() {

	}

	public NoiseRailwaySegment(NoiseADEModule module) {
		super(module);
	}
	
	public String getRailwaySurfaceMaterial() {
		return railwaySurfaceMaterial;
	}
	
	public boolean isSetRailwaySurfaceMaterial() {
		return railwaySurfaceMaterial != null;
	}

	public void setRailwaySurfaceMaterial(String railwaySurfaceMaterial) {
		this.railwaySurfaceMaterial = railwaySurfaceMaterial;
	}

	public Measure getRailwaySurfaceCorrection() {
		return railwaySurfaceCorrection;
	}
	
	public boolean isSetRailwaySurfaceCorrection() {
		return railwaySurfaceCorrection != null;
	}

	public void setRailwaySurfaceCorrection(Measure railwaySurfaceCorrection) {
		if (railwaySurfaceCorrection != null)
			railwaySurfaceCorrection.setParent(this);
		
		this.railwaySurfaceCorrection = railwaySurfaceCorrection;
	}

	public Boolean getBridge() {
		return bridge;
	}
	
	public boolean isSetBridge() {
		return bridge != null;
	}

	public void setBridge(Boolean bridge) {
		this.bridge = bridge;
	}

	public Boolean getCrossing() {
		return crossing;
	}
	
	public boolean isSetCrossing() {
		return crossing != null;
	}

	public void setCrossing(Boolean crossing) {
		this.crossing = crossing;
	}

	public Length getCurveRadius() {
		return curveRadius;
	}
	
	public boolean isSetCurveRadius() {
		return curveRadius != null;
	}

	public void setCurveRadius(Length curveRadius) {
		if (curveRadius != null)
			curveRadius.setParent(this);
		
		this.curveRadius = curveRadius;
	}

	public Measure getAdditionalCorrectionSegment() {
		return additionalCorrectionSegment;
	}
	
	public boolean isSetAdditionalCorrectionSegment() {
		return additionalCorrectionSegment != null;
	}

	public void setAdditionalCorrectionSegment(Measure additionalCorrectionSegment) {
		if (additionalCorrectionSegment != null)
			additionalCorrectionSegment.setParent(this);
		
		this.additionalCorrectionSegment = additionalCorrectionSegment;
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

	public void addUsedBy(TrainProperty usedBy) {
		if (this.usedBy == null)
			this.usedBy = new ChildList<>(this);
		
		this.usedBy.add(usedBy);
	}
	
	public List<TrainProperty> getUsedBy() {
		if (usedBy == null)
			usedBy = new ChildList<>(this);
		
		return usedBy;
	}
	
	public boolean isSetUsedBy() {
		return usedBy != null && !usedBy.isEmpty();
	}

	public void setUsedBy(List<TrainProperty> usedBy) {
		this.usedBy = new ChildList<>(this, usedBy);
	}
	
	@Override
	public BoundingShape calcBoundedBy(BoundingBoxOptions options) {
		return SimpleBoundingBoxCalculator.calcBoundedBy(this, options);
	}
	
	@Override
	public LodRepresentation getLodRepresentation() {
		return LodRepresentationBuilder.buildRepresentation(this);
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new NoiseRailwaySegment(), copyBuilder);
	}
	
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		NoiseRailwaySegment copy = (target == null) ? new NoiseRailwaySegment() : (NoiseRailwaySegment)target;
		super.copyTo(copy, copyBuilder);
		
		return ObjectCopier.copyTo(this, copy, copyBuilder);
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
