package org.citygml.ade.noise.test;

import java.io.File;

import org.citygml.ade.noise.NoiseADEContext;
import org.citygml.ade.noise.model.NoiseRailwaySegment;
import org.citygml.ade.noise.model.NoiseRailwaySegmentProperty;
import org.citygml.ade.noise.model.NoiseRailwaySegmentPropertyElement;
import org.citygml.ade.noise.model.Train;
import org.citygml.ade.noise.model.TrainProperty;
import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.CityGMLBuilder;
import org.citygml4j.model.citygml.cityfurniture.CityFurniture;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.model.citygml.transportation.Railway;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.util.walker.FeatureWalker;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.writer.CityGMLWriter;
import org.citygml4j.xml.io.writer.FeatureWriteMode;

public class Test {

	public static void main(String[] args) throws Exception {
		CityGMLContext context = new CityGMLContext();

		context.registerADEContext(new NoiseADEContext());

		CityGMLBuilder builder = context.createCityGMLBuilder();

		CityGMLInputFactory in = builder.createCityGMLInputFactory();
//		in.setProperty(CityGMLInputFactory.FEATURE_READ_MODE, FeatureReadMode.SPLIT_PER_COLLECTION_MEMBER);
			
		CityGMLReader reader = in.createCityGMLReader(new File("datasets/railway_example.gml"));
		
		CityModel cityModel = (CityModel)reader.nextFeature();
		
		
		FeatureWalker walker = new FeatureWalker() {
			public void visit(AbstractFeature feature) {
				System.out.println(feature);
				super.visit(feature);
			}
		}.useADEContexts(context.getADEContexts());
		
		cityModel.accept(walker);
		
		CityGMLOutputFactory out = builder.createCityGMLOutputFactory(CityGMLVersion.v2_0_0, builder.getDefaultSchemaHandler());
//		out.setProperty(CityGMLOutputFactory.FEATURE_WRITE_MODE, FeatureWriteMode.SPLIT_PER_COLLECTION_MEMBER);
//		out.setProperty(CityGMLOutputFactory.EXCLUDE_FROM_SPLITTING, Train.class);
		CityGMLWriter writer = out.createCityGMLWriter(new File("datasets/out.gml"));

		writer.setIndentString("  ");
		writer.setPrefixes(CityGMLVersion.v2_0_0);
		writer.setPrefixes(context.getADEContexts());
		writer.setSchemaLocations(CityGMLVersion.v2_0_0);
		writer.setSchemaLocations(context.getADEContexts());

		writer.write(cityModel);
		
		
		System.out.println("hallo");
	}

}
