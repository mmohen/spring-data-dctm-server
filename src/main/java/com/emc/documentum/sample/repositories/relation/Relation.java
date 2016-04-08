package com.emc.documentum.sample.repositories.relation;

import com.emc.documentum.springdata.entitymanager.mapping.DctmAttribute;
import com.emc.documentum.springdata.entitymanager.mapping.DctmEntity;
import org.springframework.data.annotation.Id;

/*
 * Copyright (c) 2015 EMC Corporation. All Rights Reserved.
 * EMC Confidential: Restricted Internal Distribution
 */
@DctmEntity(repository = "dm_relation")
public class Relation {
	
  @Id
  private String id;

  @DctmAttribute("parent_id")
  private String parentId;

  @DctmAttribute("child_id")
  private String childId;

  @DctmAttribute("relation_name")
  private String relationName;

  public Relation() {}
  
  public String getId() {
	return id;
  }

  public void setId(String id) {
	this.id = id;
  }

  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId;
  }

  public String getChildId() {
    return childId;
  }

  public void setChildId(String childId) {
    this.childId = childId;
  }

  public String getRelationName() {
    return relationName;
  }

  public void setRelationName(String relationName) {
    this.relationName = relationName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) { return true; }
    if (o == null || getClass() != o.getClass()) { return false; }

    Relation relation = (Relation)o;

    if (parentId != null ? !parentId.equals(relation.parentId) : relation.parentId != null) { return false; }
    if (childId != null ? !childId.equals(relation.childId) : relation.childId != null) { return false; }
    return !(relationName != null ? !relationName.equals(relation.relationName) : relation.relationName != null);

  }

  @Override
  public int hashCode() {
    int result = parentId != null ? parentId.hashCode() : 0;
    result = 31 * result + (childId != null ? childId.hashCode() : 0);
    result = 31 * result + (relationName != null ? relationName.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Relation{" +
        "parentId='" + parentId + '\'' +
        ", childId='" + childId + '\'' +
        ", relationName='" + relationName + '\'' +
        '}';
  }
}
