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

package org.apache.hadoop.hive.ql.optimizer.pcr;

import java.io.Serializable;
import java.util.List;

import org.apache.hadoop.hive.ql.exec.FilterOperator;
import org.apache.hadoop.hive.ql.exec.Operator;
import org.apache.hadoop.hive.ql.lib.NodeProcessorCtx;
import org.apache.hadoop.hive.ql.parse.ParseContext;

/**
 * Context class for operator tree walker for partition condition remover.
 */
public class PcrOpWalkerCtx implements NodeProcessorCtx {

  static public class OpToDeleteInfo {
    private final Operator<? extends Serializable> parent;
    private final FilterOperator operator;

    public OpToDeleteInfo(Operator<? extends Serializable> parent, FilterOperator operator) {
      super();
      this.parent = parent;
      this.operator = operator;
    }
    public Operator<? extends Serializable> getParent() {
      return parent;
    }
    public FilterOperator getOperator() {
      return operator;
    }
  }

  private final ParseContext parseContext;
  private final List<OpToDeleteInfo> opToRemove;

  /**
   * Constructor.
   */
  public PcrOpWalkerCtx(ParseContext parseContext,
      List<OpToDeleteInfo> opToRemove) {
    this.parseContext = parseContext;
    this.opToRemove = opToRemove;
  }

  public ParseContext getParseContext() {
    return parseContext;
  }

  public List<OpToDeleteInfo> getOpToRemove() {
    return opToRemove;
  }
}
