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

package org.finos.legend.engine.query.graphQL.api.execute;

import org.finos.legend.engine.protocol.graphQL.metamodel.executable.Field;
import org.finos.legend.engine.protocol.graphQL.metamodel.executable.OperationDefinition;
import org.finos.legend.engine.protocol.graphQL.metamodel.executable.OperationType;
import org.finos.legend.engine.protocol.graphQL.metamodel.executable.Selection;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestHelpers
{
    @Test
    public void testIsARootField()
    {
        GraphQLExecute graphQLExecute = new GraphQLExecute(null, null, null, null, null);
        OperationDefinition operationDefinition = new OperationDefinition();
        operationDefinition.name = "query";
        operationDefinition.type = OperationType.query;
        List<Selection> selectionList = new ArrayList<>();
        Field f = new Field();
        f.name = "getContacts";
        selectionList.add(f);
        operationDefinition.selectionSet = selectionList;
        Assert.assertFalse(GraphQLExecutionHelper.isARootField("abc", operationDefinition));
        Assert.assertTrue(GraphQLExecutionHelper.isARootField("getContacts", operationDefinition));
    }
}
