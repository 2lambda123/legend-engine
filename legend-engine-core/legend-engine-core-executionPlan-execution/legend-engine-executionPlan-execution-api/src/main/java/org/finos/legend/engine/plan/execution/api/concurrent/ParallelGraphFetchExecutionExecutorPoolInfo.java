//  Copyright 2023 Goldman Sachs
//
//  Licensed under the Apache License, Version 2.0 (the "License");
//  you may not use this file except in compliance with the License.
//  You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
//  Unless required by applicable law or agreed to in writing, software
//  distributed under the License is distributed on an "AS IS" BASIS,
//  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//  See the License for the specific language governing permissions and
//  limitations under the License.

package org.finos.legend.engine.plan.execution.api.concurrent;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.finos.legend.engine.plan.execution.concurrent.ParallelGraphFetchExecutionExecutorPool;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api(tags = "Server")
@Path("server/v1")
@Produces(MediaType.APPLICATION_JSON)
public class ParallelGraphFetchExecutionExecutorPoolInfo
{
    private final ParallelGraphFetchExecutionExecutorPool executorPool;

    public ParallelGraphFetchExecutionExecutorPoolInfo(ParallelGraphFetchExecutionExecutorPool executorPool)
    {
        this.executorPool = executorPool;
    }

    @GET
    @Path("parallelGraphFetchExecutionExecutorPoolInfo")
    @ApiOperation(value = "current state of parallelGraphFetchExecutionExecutorPool")
    public Response getPoolInfo()
    {
        if (executorPool != null)
        {
            return Response.status(Response.Status.OK).type(MediaType.APPLICATION_JSON).entity(executorPool).build();
        }
        return Response.noContent().build();
    }
}
