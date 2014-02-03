package org.norr.xwp.service

import org.springframework.transaction.support.{TransactionCallback, TransactionTemplate}
import org.springframework.transaction.{PlatformTransactionManager, TransactionStatus, TransactionDefinition}
import org.springframework.transaction.annotation.{Propagation, Isolation}
import org.springframework.beans.factory.annotation.Autowired
import scala.language.implicitConversions
import org.springframework.transaction.interceptor.DefaultTransactionAttribute

/**
 * This code adopted from:
 * http://stackoverflow.com/questions/4385929/use-spring-transactional-in-scala
 * https://github.com/ewolff/scala-spring
 */
trait TransactionManagement {

  @Autowired
  var transactionManager: PlatformTransactionManager = null

  implicit def transactionCallbackImplicit[T](func: => T) = {
    new TransactionCallback[T] {
      def doInTransaction(status: TransactionStatus) = func.asInstanceOf[T]
    }
  }

  class TransactionAttributeWithRollbackRules(propagation: Propagation = Propagation.REQUIRED,
                                              isolation: Isolation = Isolation.DEFAULT,
                                              readOnly: Boolean = false,
                                              timeout: Int = TransactionDefinition.TIMEOUT_DEFAULT,
                                              rollbackFor: List[Class[_ <: Throwable]] = List(),
                                              noRollbackFor: List[Class[_ <: Throwable]] = List()) extends DefaultTransactionAttribute(propagation.value()) {

    setIsolationLevel(isolation.value())
    setReadOnly(readOnly)
    setTimeout(timeout)

    override def rollbackOn(ex: Throwable): Boolean = {
      def clazz = ex.getClass
      if (rollbackFor.exists(_.isAssignableFrom(clazz))) {
        return true
      }
      if (noRollbackFor.exists(_.isAssignableFrom(clazz))) {
        return false
      }
      super.rollbackOn(ex)
    }
  }

  def transactional[T](propagation: Propagation = Propagation.REQUIRED,
                       isolation: Isolation = Isolation.DEFAULT,
                       readOnly: Boolean = false,
                       timeout: Int = TransactionDefinition.TIMEOUT_DEFAULT,
                       rollbackFor: List[Class[_ <: Throwable]] = List(),
                       noRollbackFor: List[Class[_ <: Throwable]] = List())(func: => T): T = {
    val transactionAttribute = new TransactionAttributeWithRollbackRules(propagation, isolation, readOnly, timeout, rollbackFor, noRollbackFor)
    val transactionTemplate = new TransactionTemplate(transactionManager, transactionAttribute)
    transactionTemplate.execute(func)
  }
}
