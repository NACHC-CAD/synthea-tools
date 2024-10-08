//
// Data Value Object (DVO) for concept_relationship
//

package org.nachc.tools.synthea.util.dvo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;

import org.yaorma.dvo.Dvo;

public class ConceptRelationshipDvo implements Dvo {

    //
    // tableName
    //
    
    public static final String TABLE_NAME = "concept_relationship";
    
    //
    // schemaName
    //
    
    public static final String SCHEMA_NAME = "synthea_omop";
    
    //
    // columnNames
    //
    
    public static final String[] COLUMN_NAMES = {
        "concept_id_1",
        "concept_id_2",
        "invalid_reason",
        "relationship_id",
        "valid_end_date",
        "valid_start_date"
    };
    
    //
    // primaryKeyColumnNames
    //
    
    public static final String[] PRIMARY_KEY_COLUMN_NAMES = {
    };
    
    //
    // javaNames
    //
    
    public static final String[] JAVA_NAMES = {
        "conceptId1",
        "conceptId2",
        "invalidReason",
        "relationshipId",
        "validEndDate",
        "validStartDate"
    };
    
    //
    // javaNamesProper
    //
    
    public static final String[] JAVA_NAMES_PROPER = {
        "ConceptId1",
        "ConceptId2",
        "InvalidReason",
        "RelationshipId",
        "ValidEndDate",
        "ValidStartDate"
    };
    
    
    //
    // member variables
    //
    
    private HashMap<String, String> descriptions = new HashMap<String, String>();
    
    private Integer conceptId1;
    
    private Integer conceptId2;
    
    private String invalidReason;
    
    private String relationshipId;
    
    private String validEndDate;
    
    private String validStartDate;
    
    private ConceptDvo conceptId1Dvo;
    
    private ConceptDvo conceptId2Dvo;
    
    private RelationshipDvo relationshipDvo;
    
    //
    // trivial getters and setters
    //
    
    // conceptId1
    
    public void setConceptId1(Integer val) {
        this.conceptId1 = val;
    }
    
    public Integer getConceptId1() {
        return this.conceptId1;
    }
    
    // conceptId2
    
    public void setConceptId2(Integer val) {
        this.conceptId2 = val;
    }
    
    public Integer getConceptId2() {
        return this.conceptId2;
    }
    
    // invalidReason
    
    public void setInvalidReason(String val) {
        this.invalidReason = val;
    }
    
    public String getInvalidReason() {
        return this.invalidReason;
    }
    
    // relationshipId
    
    public void setRelationshipId(String val) {
        this.relationshipId = val;
    }
    
    public String getRelationshipId() {
        return this.relationshipId;
    }
    
    // validEndDate
    
    public void setValidEndDate(String val) {
        this.validEndDate = val;
    }
    
    public String getValidEndDate() {
        return this.validEndDate;
    }
    
    // validStartDate
    
    public void setValidStartDate(String val) {
        this.validStartDate = val;
    }
    
    public String getValidStartDate() {
        return this.validStartDate;
    }
    
    // conceptId1Dvo
    
    public void setConceptId1Dvo(ConceptDvo dvo) {
        this.conceptId1Dvo = dvo;
    }
    
    public ConceptDvo getConceptId1Dvo() {
        return this.conceptId1Dvo;
    }
    
    // conceptId2Dvo
    
    public void setConceptId2Dvo(ConceptDvo dvo) {
        this.conceptId2Dvo = dvo;
    }
    
    public ConceptDvo getConceptId2Dvo() {
        return this.conceptId2Dvo;
    }
    
    // relationshipDvo
    
    public void setRelationshipDvo(RelationshipDvo dvo) {
        this.relationshipDvo = dvo;
    }
    
    public RelationshipDvo getRelationshipDvo() {
        return this.relationshipDvo;
    }
    
    //
    // implementation of Dvo
    //
    
    public String getTableName() {
        return TABLE_NAME;
    };
    
    public String getSchemaName() {
        return SCHEMA_NAME;
    };
    
    public String[] getColumnNames() {
        return COLUMN_NAMES;
    };
    
    public String[] getPrimaryKeyColumnNames() {
        return PRIMARY_KEY_COLUMN_NAMES;
    };
    
    public String[] getJavaNames() {
        return JAVA_NAMES;
    };
    
    public String[] getJavaNamesProper() {
        return JAVA_NAMES_PROPER;
    };
    
    public void setDescriptions(HashMap<String, String> descriptions) {
        this.descriptions = descriptions;
    }
    
    public HashMap<String, String> getDescriptions() {
        return this.descriptions;
    }
    
    public void addDescription(String javaName, String value) {
        this.descriptions.put(javaName, value);
    }
    
    public String getDescription(String javaName) {
        return this.descriptions.get(javaName);
    }
    
    public String[] getPrimaryKeyValues() {
        String[] rtn = new String[] {
        };
        return rtn;
    }
}
