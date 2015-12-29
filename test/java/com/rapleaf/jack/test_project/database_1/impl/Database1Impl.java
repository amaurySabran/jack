
/**
 * Autogenerated by Jack
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package com.rapleaf.jack.test_project.database_1.impl;

import java.io.IOException;

import com.rapleaf.jack.test_project.database_1.IDatabase1;
import com.rapleaf.jack.LazyLoadPersistence;
import com.rapleaf.jack.queries.GenericQuery;
import com.rapleaf.jack.BaseDatabaseConnection;
import com.rapleaf.jack.test_project.database_1.iface.ICommentPersistence;
import com.rapleaf.jack.test_project.database_1.iface.IImagePersistence;
import com.rapleaf.jack.test_project.database_1.iface.ILockableModelPersistence;
import com.rapleaf.jack.test_project.database_1.iface.IPostPersistence;
import com.rapleaf.jack.test_project.database_1.iface.IUserPersistence;

import com.rapleaf.jack.test_project.IDatabases;

public class Database1Impl implements IDatabase1 {
  
  private final BaseDatabaseConnection conn;
  private final IDatabases databases;
  private final LazyLoadPersistence<ICommentPersistence, IDatabases> comments;
  private final LazyLoadPersistence<IImagePersistence, IDatabases> images;
  private final LazyLoadPersistence<ILockableModelPersistence, IDatabases> lockable_models;
  private final LazyLoadPersistence<IPostPersistence, IDatabases> posts;
  private final LazyLoadPersistence<IUserPersistence, IDatabases> users;

  public Database1Impl(BaseDatabaseConnection conn, IDatabases databases) {
    this.conn = conn;
    this.databases = databases;
    this.comments = new LazyLoadPersistence<ICommentPersistence, IDatabases>(conn, databases) {
      @Override
      protected ICommentPersistence build(BaseDatabaseConnection conn, IDatabases databases) {
        return new BaseCommentPersistenceImpl(conn, databases);
      }
    };
    this.images = new LazyLoadPersistence<IImagePersistence, IDatabases>(conn, databases) {
      @Override
      protected IImagePersistence build(BaseDatabaseConnection conn, IDatabases databases) {
        return new BaseImagePersistenceImpl(conn, databases);
      }
    };
    this.lockable_models = new LazyLoadPersistence<ILockableModelPersistence, IDatabases>(conn, databases) {
      @Override
      protected ILockableModelPersistence build(BaseDatabaseConnection conn, IDatabases databases) {
        return new BaseLockableModelPersistenceImpl(conn, databases);
      }
    };
    this.posts = new LazyLoadPersistence<IPostPersistence, IDatabases>(conn, databases) {
      @Override
      protected IPostPersistence build(BaseDatabaseConnection conn, IDatabases databases) {
        return new BasePostPersistenceImpl(conn, databases);
      }
    };
    this.users = new LazyLoadPersistence<IUserPersistence, IDatabases>(conn, databases) {
      @Override
      protected IUserPersistence build(BaseDatabaseConnection conn, IDatabases databases) {
        return new BaseUserPersistenceImpl(conn, databases);
      }
    };
  }

  public GenericQuery.Builder createQuery() {
    return GenericQuery.create(conn);
  }

  public ICommentPersistence comments(){
    return comments.get();
  }

  public IImagePersistence images(){
    return images.get();
  }

  public ILockableModelPersistence lockableModels(){
    return lockable_models.get();
  }

  public IPostPersistence posts(){
    return posts.get();
  }

  public IUserPersistence users(){
    return users.get();
  }

  public boolean deleteAll() throws IOException {
    boolean success = true;
    try {
    success &= comments().deleteAll();
    success &= images().deleteAll();
    success &= lockableModels().deleteAll();
    success &= posts().deleteAll();
    success &= users().deleteAll();
    } catch (IOException e) {
      throw e;
    }
    return success;
  }

  public void disableCaching() {
    comments.disableCaching();
    images.disableCaching();
    lockable_models.disableCaching();
    posts.disableCaching();
    users.disableCaching();
  }

  public void setAutoCommit(boolean autoCommit) {
    conn.setAutoCommit(autoCommit);
  }

  public boolean getAutoCommit() {
    return conn.getAutoCommit();
  }

  public void commit() {
    conn.commit();
  }

  public void rollback() {
    conn.rollback();
  }

  public void resetConnection() {
    conn.resetConnection();
  }

  public IDatabases getDatabases() {
    return databases;
  }

}
