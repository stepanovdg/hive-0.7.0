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

package org.apache.hadoop.hive.ql.io;

import org.apache.hadoop.mapred.lib.HashPartitioner;

/** Partition keys by their {@link Object#hashCode()}. */
public class DefaultHivePartitioner<K2, V2> extends HashPartitioner<K2, V2> implements HivePartitioner<K2, V2> {

  /** Use {@link Object#hashCode()} to partition. */
  public int getBucket(K2 key, V2 value, int numBuckets) {
    return (key.hashCode() & Integer.MAX_VALUE) % numBuckets;
  }

}
