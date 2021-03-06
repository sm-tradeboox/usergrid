/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  The ASF licenses this file to You
 * under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.  For additional information regarding
 * copyright in this work, please see the NOTICE file in the top level
 * directory of this distribution.
 */
package org.apache.usergrid.persistence.index.exceptions;


import org.apache.usergrid.persistence.index.QueryAnalyzer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class QueryAnalyzerException extends RuntimeException {

    private List<Map<String, Object>> violations = new ArrayList<>();
    private String originalQuery;
    private UUID applicationUUID;

    public QueryAnalyzerException(final List<Map<String, Object>> violations, final String originalQuery,
                                  final UUID applicationUUID) {
        super("Query Analyzer");
        this.violations = violations;
        this.originalQuery = originalQuery;
        this.applicationUUID = applicationUUID;
    }

    public List<Map<String, Object>> getViolations(){
        return violations;
    }

    public String getErrorMessage() {
        return QueryAnalyzer.violationsAsString(violations, originalQuery);
    }

    public String getOriginalQuery(){
        return originalQuery;
    }

    public UUID getApplicationUUID(){
        return applicationUUID;
    }
}
