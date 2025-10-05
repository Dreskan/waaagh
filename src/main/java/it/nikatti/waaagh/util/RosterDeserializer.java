package it.nikatti.waaagh.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import it.nikatti.waaagh.model.Roster;

import java.io.IOException;
import java.util.Iterator;


public class RosterDeserializer extends StdDeserializer<Roster> {

    public RosterDeserializer() {
        this(null);
    }

    public RosterDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Roster deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {

        JsonNode node = jp.readValueAsTree();
        Roster roster = new Roster();

        JsonNode forcesNode = node.get("roster").get("forces");


        JsonNode firstForcesNode = getFirstArrayNode(forcesNode);
        //roster.setArmyName(firstForcesNode.get("catalogueName").textValue());
        JsonNode firstSelectionsNode = getFirstArrayNode(firstForcesNode.get("selections"));
        JsonNode firstSelectionsNode2 = getFirstArrayNode(firstSelectionsNode.get("selections"));
        JsonNode firstRulesNode = getFirstArrayNode(firstSelectionsNode2.get("rules"));

        //roster.setArmyDetachment(firstRulesNode.get("name").textValue());
        return roster;
    }


    private JsonNode getFirstArrayNode(JsonNode arrayNode) {
        JsonNode firstElement = null;
        if (arrayNode.isArray()) {
            Iterator<JsonNode> itr = arrayNode.iterator();
            while (itr.hasNext()) {
                firstElement = itr.next();
                break;
            }
        }
        return firstElement;
    }
}