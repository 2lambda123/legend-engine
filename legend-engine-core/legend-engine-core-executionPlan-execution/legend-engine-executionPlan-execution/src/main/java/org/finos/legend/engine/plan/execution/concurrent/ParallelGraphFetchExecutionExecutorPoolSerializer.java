// Copyright 2023 Goldman Sachs
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.finos.legend.engine.plan.execution.concurrent;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class ParallelGraphFetchExecutionExecutorPoolSerializer extends JsonSerializer<ParallelGraphFetchExecutionExecutorPool>
{
    @Override
    public void serialize(ParallelGraphFetchExecutionExecutorPool parallelGraphFetchExecutionExecutorPool, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException
    {
        parallelGraphFetchExecutionExecutorPool.serialize(jsonGenerator);
    }
}
