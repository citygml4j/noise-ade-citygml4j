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
	public BoundingShape calcBoundedBy(boolean setBoundedBy) {
		if (lod0BaseLine != null && lod0BaseLine.isSetCurve()) {
			BoundingShape boundedBy = new BoundingShape();
			calcBoundedBy(boundedBy, lod0BaseLine.getCurve());
			
			if (boundedBy.isSetEnvelope()) {
				if (setBoundedBy)
					setBoundedBy(boundedBy);
				
				return boundedBy;
			}
		}
		
		return null;
	}
	
	@Override
	public LodRepresentation getLodRepresentation() {
		LodRepresentation lodRepresentation = new LodRepresentation();
		
		if (lod0BaseLine != null)
			lodRepresentation.getLod0Geometry().add(lod0BaseLine);
		
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
			copy.setReflection((String)copyBuilder.copy(reflection));

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
		visitor.visit((ADEModelObject)this);
	}

	@Override
	public <T> T accept(FeatureFunctor<T> visitor) {
		return visitor.apply((ADEModelObject)this);
	}

	@Override
	public void accept(GMLVisitor visitor) {
		visitor.visit((ADEModelObject)this);
	}

	@Override
	public <T> T accept(GMLFunctor<T> visitor) {
		return visitor.apply((ADEModelObject)this);
	}

}
