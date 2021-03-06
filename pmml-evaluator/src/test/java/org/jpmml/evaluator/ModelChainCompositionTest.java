/*
 * Copyright (c) 2013 Villu Ruusmann
 *
 * This file is part of JPMML-Evaluator
 *
 * JPMML-Evaluator is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JPMML-Evaluator is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with JPMML-Evaluator.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.jpmml.evaluator;

import java.util.*;

import org.dmg.pmml.*;

import org.junit.*;

import static org.junit.Assert.*;

public class ModelChainCompositionTest extends ModelChainTest {

	@Test
	public void evaluateSetosa() throws Exception {
		Map<FieldName, ?> result = evaluateExample(1.4, 0.2);

		assertEquals(0.3, result.get(new FieldName("Setosa Pollen Index")));
		assertEquals("2.1", result.get(new FieldName("Segment Id")));
		assertEquals("2", result.get(new FieldName("Class Node")));
	}

	@Test
	public void evaluateVersicolor() throws Exception {
		Map<FieldName, ?> result = evaluateExample(4.7, 1.4);

		assertEquals(0.2, result.get(new FieldName("Versicolor Pollen Index")));
		assertEquals("2.2", result.get(new FieldName("Segment Id")));
		assertEquals("4", result.get(new FieldName("Class Node")));
	}

	@Test
	public void evaluateVirginica() throws Exception {
		Map<FieldName, ?> result = evaluateExample(6, 2.5);

		assertEquals(0.1, result.get(new FieldName("Virginica Pollen Index")));
		assertEquals("2.3", result.get(new FieldName("Segment Id")));
		assertEquals("5", result.get(new FieldName("Class Node")));
	}
}