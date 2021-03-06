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

public class MissingValueStrategyTest extends TreeModelEvaluatorTest {

	@Test
	public void nullPrediction() throws Exception {
		assertEquals(null, getNodeId(MissingValueStrategyType.NULL_PREDICTION));
	}

	@Test
	public void lastPrediction() throws Exception {
		assertEquals("2", getNodeId(MissingValueStrategyType.LAST_PREDICTION));
	}

	private String getNodeId(MissingValueStrategyType missingValueStrategy) throws Exception {
		TreeModelEvaluator evaluator = createEvaluator();

		TreeModel treeModel = evaluator.getModel();
		treeModel.setMissingValueStrategy(missingValueStrategy);

		Map<FieldName, ?> arguments = createArguments("outlook", "sunny", "temperature", null, "humidity", null);

		Map<FieldName, ?> result = evaluator.evaluate(arguments);

		return getEntityId(result.get(evaluator.getTargetField()));
	}


}