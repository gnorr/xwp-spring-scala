/**
 * Copyright (C) 2014, George B. Norr, All Rights Reserved
 * Date: 2/1/14
 */
package org.norr.xwp.dao

import org.springframework.test.context.ContextConfiguration
import org.scalatest.junit.JUnitSuiteLike
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests
import org.springframework.beans.factory.annotation.Autowired
import org.norr.xwp.domain.Xwp
import org.junit.Test
import org.junit.Assert._
import java.util.Date

@ContextConfiguration(Array("classpath:/META-INF/spring/applicationContext.xml"))
class XwpDaoTest extends AbstractTransactionalJUnit4SpringContextTests with JUnitSuiteLike {

  @Autowired
  val xwpDao: XwpDao = null

  @Test
  def testSaveXwp() = {
    val xwp = new Xwp
    xwp.timestamp = new Date()
    try {
      xwpDao.saveXwp(xwp)
      assertNotNull(xwp)
    }
    catch {
      case e: Exception => fail()
    }
  }

  @Test
  def testLoadXwps() = {
    val xwps: java.util.List[Xwp] = xwpDao.loadXwps()
    assertNotNull(xwps)
  }
}
