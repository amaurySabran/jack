
/**
 * Autogenerated by Jack
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package com.rapleaf.jack.test_project.database_1.mock_impl;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Timestamp;

import com.rapleaf.jack.AbstractMockDatabaseModel;
import com.rapleaf.jack.ModelQuery;
import com.rapleaf.jack.ModelWithId;
import com.rapleaf.jack.QueryConstraint;

import com.rapleaf.jack.test_project.database_1.models.Image;
import com.rapleaf.jack.test_project.database_1.models.Image.Id;
import com.rapleaf.jack.test_project.database_1.iface.IImagePersistence;
import com.rapleaf.jack.test_project.database_1.query.ImageQueryBuilder;

import com.rapleaf.jack.test_project.IDatabases;

public class BaseMockImagePersistenceImpl extends AbstractMockDatabaseModel<Image, IDatabases> implements IImagePersistence {
  private final IDatabases databases;

  private static AtomicInteger curId = new AtomicInteger(1);

  public BaseMockImagePersistenceImpl(IDatabases databases) {
    super(databases);
    this.databases = databases;
  }

  @Override
  public Image create(Map<Enum, Object> fieldsMap) throws IOException {
    Integer user_id = (Integer) fieldsMap.get(Image._Fields.user_id);
    return create(user_id);
  }


  public Image create(final Integer user_id) throws IOException {
    long __id = curId.getAndIncrement();
    Image newInst = new Image(__id, user_id, databases);
    records.put(__id, newInst);
    clearForeignKeyCache();
    return newInst.getCopy();
  }



  public Image create() throws IOException {
    long __id = curId.getAndIncrement();
    Image newInst = new Image(__id, null, databases);
    records.put(__id, newInst);
    clearForeignKeyCache();
    return newInst.getCopy();
  }


  public Image createDefaultInstance() throws IOException {
    return create();
  }

  public Set<Image> find(Map<Enum, Object> fieldsMap) throws IOException {
    return super.realFind(fieldsMap);
  }

  public Set<Image> find(Set<Long> ids, Map<Enum, Object> fieldsMap) throws IOException {
    return super.realFind(ids, fieldsMap);
  }

  public Set<Image> find(ModelQuery query) throws IOException {
    return super.realFind(query);
  }
  
  public List<Image> findWithOrder(ModelQuery query) throws IOException {
    return super.realFindWithOrder(query);
  }

  public Set<Image> findByUserId(final Integer value) throws IOException {
    return find(new HashMap<Enum, Object>(){{put(Image._Fields.user_id, value);}});
  }

  public ImageQueryBuilder query() {
    return new ImageQueryBuilder(this);
  }
}
