/*
 * Copyright 2020-2021 Javier de Jesus Flores Herrera, Sergi Nadal Francesch & Oscar Romero Moral
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 *
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package edu.upc.essi.dtim.nextiajd.metafeatures.general

import edu.upc.essi.dtim.nextiajd.metafeatures.{DefaultWithConstantMF, DependantMF, DependantWithConstantMF, MetaFeature}
import edu.upc.essi.dtim.nextiajd.utils.{AggregationDataEnum, DataTypeProfilesEnum, NormalizationTypeEnum}
import org.apache.spark.sql.Column
import org.apache.spark.sql.functions.{col, lit}

object Uniqueness extends MetaFeature with DependantWithConstantMF {

  val name: String = "distinct_values_pct"
  val nameAtt: String = "uniqueness"
  val dataType: String = DataTypeProfilesEnum.all
  val doc: String = "Number of distinct values divided by the number of rows"
  val aggregatedData: String = AggregationDataEnum.rawValue
  val normalize: Boolean = true
  val normalizeType: Int = NormalizationTypeEnum.four

  def func(constant: Long): Column = col( Cardinality.nameAtt ).divide(lit(constant))

}
