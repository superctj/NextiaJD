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

package edu.upc.essi.dtim.nextiajd.metafeatures.frequencies

import edu.upc.essi.dtim.nextiajd.metafeatures.{DefaultMF, MetaFeature}
import edu.upc.essi.dtim.nextiajd.utils.{AggregationDataEnum, DataTypeProfilesEnum, NormalizationTypeEnum}
import org.apache.spark.sql.Column
import org.apache.spark.sql.functions.max

object LastWord extends MetaFeature with DefaultMF{
  val name: String = "lastWord"
  val nameAtt: String = "lastWord"
  val dataType: String = DataTypeProfilesEnum.all
  val aggregatedData: String = AggregationDataEnum.frequency
  val normalize: Boolean = true
  val normalizeType: Int = NormalizationTypeEnum.one
  val doc: String = "The last string entry in a column that is sorted alphabetically"

  def func(columnName: String): Column = max(s"${columnName}_raw").as(s"${columnName}_${nameAtt}")
}
