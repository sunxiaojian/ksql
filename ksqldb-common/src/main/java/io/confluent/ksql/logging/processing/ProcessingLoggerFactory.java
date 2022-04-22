/*
 * Copyright 2018 Confluent Inc.
 *
 * Licensed under the Confluent Community License (the "License"); you may not use
 * this file except in compliance with the License.  You may obtain a copy of the
 * License at
 *
 * http://www.confluent.io/confluent-community-license
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OF ANY KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations under the License.
 */

package io.confluent.ksql.logging.processing;

import java.util.Collection;
import org.apache.kafka.common.metrics.Sensor;

public interface ProcessingLoggerFactory {
  /**
   * Get a processing logger for writing record processing log messages
   * @param name The name of the logger to get.
   * @return The logger with the given name.
   */
  ProcessingLogger getLogger(String name);

  /**
   * Get a processing logger for writing record processing log messages and emits metrics
   * @param name The name of the logger to get.
   * @param sensor The metrics sensor to record the number of errors
   * @return The metrics emitting logger with the given name.
   */
  ProcessingLogger getLoggerWithMetrics(String name, Sensor sensor);

  /**
   * @return A collection of all loggers that have been created by the factory
   */
  Collection<String> getLoggers();
}
