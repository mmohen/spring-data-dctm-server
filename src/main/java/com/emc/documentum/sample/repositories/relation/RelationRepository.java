package com.emc.documentum.sample.repositories.relation;

import com.emc.documentum.springdata.repository.DctmRepository;
import com.emc.documentum.springdata.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.util.List;

/*
 * Copyright (c) 2015 EMC Corporation. All Rights Reserved.
 * EMC Confidential: Restricted Internal Distribution
 */
public interface RelationRepository extends DctmRepository<Relation, String>, QueryDslPredicateExecutor <Relation> {
  public List<Relation> findByRelationName(String relationName);
  public List<Relation> findByRelationNameAndParentId(String relationName, String parentId);
  public List<Relation> findByRelationNameAndChildId(String relationName, String childId);
  
  @Query("select * from dm_relation where (relation_name=\'%s\' and (parent_id=\'%s\' and child_id=\'%s\')) or (relation_name=\'%s\' and (child_id = \'%s\' and parent_id = \'%s\'))")
  public List<Relation> findEnrolledCourses(String relationName, String parentId, String childId, String relationName2, String parentId2, String childId2);
}
