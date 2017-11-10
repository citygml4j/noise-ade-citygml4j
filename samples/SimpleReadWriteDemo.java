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
import java.io.File;
import java.util.ServiceLoader;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.CityGMLBuilder;
import org.citygml4j.model.citygml.ade.binding.ADEContext;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.util.walker.FeatureWalker;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.writer.CityGMLWriter;

public class SimpleReadWriteDemo {

	public static void main(String[] args) throws Exception {
		System.out.println("Starting NoiseADE sample program...");
		CityGMLContext context = CityGMLContext.getInstance();

		/**
		 * First thing after we have obtained the CityGMLContext is
		 * to register the ADE contexts. This has to be done before creating
		 * a CityGMLBuilder object.
		 */
		
		// load ADE contexts using a service loader
		// alternatively, we could manually create an instance of NoiseADEContext
		for (ADEContext adeContext : ServiceLoader.load(ADEContext.class))
			context.registerADEContext(adeContext);

		CityGMLBuilder builder = context.createCityGMLBuilder();		

		/**
		 * Read the example NoiseADE dataset "railway_example.gml"
		 * Note that we do not need any ADE-specific extra code
		 */
		System.out.println("Reading NoiseADE dataset railway_example.gml...");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		CityGMLReader reader = in.createCityGMLReader(new File("datasets/railway_example.gml"));

		// we know that the root element is a CityModel so we take the shortcut here...
		CityModel cityModel = (CityModel)reader.nextFeature();
		reader.close();
		
		// let's walk through the city model and print every feature we come across
		// to the console. Again, we do not need any ADE-specific extra code.
		cityModel.accept(new FeatureWalker() {
			@Override
			public void visit(AbstractFeature feature) {
				System.out.println("Found feature with gml:id '" + feature.getId() + "' (class " + feature.getClass().getName() + ")");
				super.visit(feature);
			}
		});

		/**
		 * Write the city model with NoiseADE elements to the file "out.gml"
		 * Again, we do not need any ADE-specific extra code
		 */
		System.out.println("Writing NoiseADE dataset out.gml...");
		CityGMLOutputFactory out = builder.createCityGMLOutputFactory(CityGMLVersion.v2_0_0);
		CityGMLWriter writer = out.createCityGMLWriter(new File("datasets/out.gml"));

		writer.setIndentString("  ");
		writer.setPrefixes(CityGMLVersion.v2_0_0);
		writer.setSchemaLocations(CityGMLVersion.v2_0_0);
		
		// use XML prefixes and schema locations defined in the
		// registered ADE contexts. This is the only ADE-specific code...
		writer.setPrefixes(context.getADEContexts());
		writer.setSchemaLocations(context.getADEContexts());

		writer.write(cityModel);
		writer.close();
		
		System.out.println("Sample program successfully finished.");
	}

}
