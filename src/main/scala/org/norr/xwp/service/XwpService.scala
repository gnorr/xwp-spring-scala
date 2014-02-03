/**
 * Copyright (C) 2013, George B. Norr, All Rights Reserved
 * Date: 9/2/13
 */
package org.norr.xwp.service

import org.springframework.stereotype.Service
import org.norr.xwp.dao.XwpDao
import org.springframework.beans.factory.annotation.Autowired
import org.norr.xwp.domain.Xwp

@Service
class XwpService extends TransactionManagement {

  @Autowired
  val xwpDao: XwpDao = null

  def getValue: String = "value"

  def saveXwp(xwp: Xwp) = transactional() {
    xwpDao.saveXwp(xwp)
  }

  def loadXwps() = transactional() {
    xwpDao.loadXwps()
  }
}
