package com.graphaware.nlp.dsl;

import com.graphaware.nlp.NLPIntegrationTest;
import java.util.Map;
import org.junit.Assert;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.neo4j.graphdb.Result;



public class PipelineTaskTest extends NLPIntegrationTest {
    
    @Test
    public void testClassList() {
        clearDb();
        executeInTransaction("CALL ga.nlp.pipeline.input.class.list()",
                ((Result result) -> {
                    assertTrue(result.hasNext());
                    Map<String, Object> next = result.next();
                    Assert.assertEquals("com.graphaware.nlp.pipeline.input.QueryBasedPipelineIput", next.get("name"));
                    Assert.assertEquals("com.graphaware.nlp.pipeline.input.QueryBasedPipelineIput", next.get("className"));
                }));
    }
}