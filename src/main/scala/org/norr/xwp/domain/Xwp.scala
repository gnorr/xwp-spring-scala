/**
 * Copyright (C) 2013, George B. Norr, All Rights Reserved
 * Date: 9/14/13
 */
package org.norr.xwp.domain

import javax.persistence.{Column, GeneratedValue, Id, Entity}
import java.util.Date

@Entity
class Xwp {

  @Id
  @GeneratedValue
  val xwpId: Long = 0

  @Column(nullable = false)
  var timestamp: Date = null

  def getTimestamp = timestamp
}
