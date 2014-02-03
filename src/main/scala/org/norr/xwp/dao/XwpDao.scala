/**
 * Copyright (C) 2013, George B. Norr, All Rights Reserved
 * Date: 9/14/13
 */
package org.norr.xwp.dao

import org.springframework.stereotype.Repository
import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.norr.xwp.domain.Xwp

@Repository
class XwpDao {

  @Autowired
  val sessionFactory: SessionFactory = null

  def saveXwp(xwp: Xwp) = {
    sessionFactory.getCurrentSession.save(xwp)
  }

  def loadXwps() = {
    val hql = "select x from Xwp x order by xwpId desc"
    val query = sessionFactory.getCurrentSession.createQuery(hql)
    query.setMaxResults(20)
    query.list().asInstanceOf[java.util.List[Xwp]]
  }
}
