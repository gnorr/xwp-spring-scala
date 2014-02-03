package org.norr.xwp

import scala.xml.NodeSeq
import javax.servlet.http.HttpServlet

class XwpServlet extends HttpServlet {

  import javax.servlet.http.HttpServletRequest
  import javax.servlet.http.HttpServletResponse

  override def doGet(request: HttpServletRequest, response: HttpServletResponse) {

    response.setContentType("text/html")
    response.setCharacterEncoding("UTF-8")

    val responseBody: NodeSeq = <html><body><h1>Hello, World!!!!</h1></body></html>
    response.getWriter.write(responseBody.toString + "\n")
  }
}
