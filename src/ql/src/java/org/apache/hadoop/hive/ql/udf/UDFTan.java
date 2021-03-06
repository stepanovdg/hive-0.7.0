/*!
* Copyright 2010 - 2013 Pentaho Corporation.  All rights reserved.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*
*/

package org.apache.hadoop.hive.ql.udf;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.hive.serde2.io.DoubleWritable;

@Description(
    name = "tan",
    value = "_FUNC_(x) - returns the tangent of x (x is in radians)",
    extended = "Example:\n " +
    		"  > SELECT _FUNC_(0) FROM src LIMIT 1;\n" +
    		"  1"
    )
public class UDFTan extends UDF {

  @SuppressWarnings("unused")
  private static Log LOG = LogFactory.getLog(UDFTan.class.getName());
  DoubleWritable result = new DoubleWritable();

  public UDFTan() {
  }

  /**
   * Take Tangent of a
   */
  public DoubleWritable evaluate(DoubleWritable a)  {
    if (a == null) {
      return null;
    } else {
      result.set(Math.tan(a.get()));
      return result;
    }
  }

}
