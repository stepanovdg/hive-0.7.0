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

package org.apache.hadoop.hive.ql.plan;

import java.io.Serializable;
import java.util.List;

import org.apache.hadoop.hive.ql.security.authorization.Privilege;

@Explain(displayName = "Privilege")
public class PrivilegeDesc implements Serializable, Cloneable {
  private static final long serialVersionUID = 1L;
  
  private Privilege privilege;
  
  private List<String> columns;

  public PrivilegeDesc(Privilege privilege, List<String> columns) {
    super();
    this.privilege = privilege;
    this.columns = columns;
  }

  public PrivilegeDesc() {
    super();
  }

  /**
   * @return privilege definition
   */
  @Explain(displayName = "privilege")
  public Privilege getPrivilege() {
    return privilege;
  }

  /**
   * @param privilege
   */
  public void setPrivilege(Privilege privilege) {
    this.privilege = privilege;
  }

  /**
   * @return columns on which the given privilege take affect.
   */
  @Explain(displayName = "columns")
  public List<String> getColumns() {
    return columns;
  }

  /**
   * @param columns
   */
  public void setColumns(List<String> columns) {
    this.columns = columns;
  }
  
}
