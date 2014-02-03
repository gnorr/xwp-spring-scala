/**
 * Copyright (C) 2013, George B. Norr, All Rights Reserved
 * Date: 9/2/13
 */
package org.norr.xwp.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.norr.xwp.service.XwpService
import org.springframework.beans.factory.annotation.Autowired
import org.norr.xwp.domain.Xwp
import java.util.Date

@Controller
class IndexController {

  @Autowired
  val xwpService: XwpService = null

  @RequestMapping(Array("/", "/index"))
  def index(model: java.util.Map[String,Object]): String = {
    val xwp = new Xwp
    xwp.timestamp = new Date
    xwpService.saveXwp(xwp)

    model.put("key", xwpService.getValue)
    model.put("list", xwpService.loadXwps())
    "index"
  }
}
