package scalaexamples.patternmatching

import junit.framework.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import scalaexamples.EmptyTest

@RunWith(classOf[JUnit4])
class RegexMatchingTest extends EmptyTest {
  
  @Test 
  def matchEntireString {
    val string = "This is the string to find a match for."
    
    // "(string)".r makes a Scala regular expression, which may be used in matching.
    // The syntax to use it in a match expression is
    //  
    //    case myregex(one) => ...
    //  
    // The match extracts the contents within the 
    // capturing parentheses () in the regular expression.
    val matchRegex = "(.+)".r
    
    val mathedElement = string match {
      // Insert you match statement here
      case matchRegex(one) => one
      case _ => "Failed"
    }
    println(mathedElement)
    assertEquals(string, mathedElement)
  }
  
  @Test 
  def matchFirstPartOfString {
    val start = "This is"
    val string = start + " the string to find a match for."
    val matchRegex = """^(\w+\s\w+).*""".r
    
    val mathedElement = string match {
      // Insert you match statement here
      case matchRegex(one) => one
      case _ => "Failed"
    }
    println(mathedElement)
    
    assertEquals(start, mathedElement)
  }
  
  @Test 
  def matchFirstAndLastWordOfString {
    val start = "This"
    val end = "for"
    val string = start + " is the string to find a match " + end
    
    // Create a regular expression which will make the folliwing match and assertions correct.
    val matchRegex = """^(\w+).*(\b\w+)""".r //""" raw string, \b word boundery, .*(w+) gobles word - then backtracks

    
    val (first, last) = string match {
      case matchRegex(firstElement, lastElement) => (firstElement, lastElement)
      case _ => "Failed"
    }
    println(first)
    println(last)
    
    assertEquals(start, first)
    assertEquals(end, last)
  }
  
  @Test 
  def matchEmails {
    
    // Create a regex which identifies email (may be really simple)
	// val emailRegex = """([^@]+)@(.+)""".r
    // You may use the regex above.
	val emailRegex = """([^@]+)@(.+)""".r
    
	var tempEmail = "aks@knowit.no"
	val (first,last) = tempEmail match {
      // Insert you match statement here
	  case emailRegex(one,two) => (one,two)
      case _ => false
    }
	println(first)
	println(last)
	
    def isValidEmail(stringToTest: String) = stringToTest match {
      // Insert you match statement here
	  case emailRegex(one,two) => true
      case _ => false
    }

    assertTrue(isValidEmail("aks@knowit.no"))
    assertTrue(isValidEmail("alf.kristian@gmail.com"))
    assertFalse(isValidEmail("fvr_at_knowit.no"))
    
  }

}
