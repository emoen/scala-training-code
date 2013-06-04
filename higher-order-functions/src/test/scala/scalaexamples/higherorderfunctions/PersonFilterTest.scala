package scalaexamples.higherorderfunctions

import junit.framework.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import scalaexamples.EmptyTest

// Comment in the tests below and make them run and pass

@RunWith(classOf[JUnit4])
class PersonFilterTest extends EmptyTest {
  
  val personFilter = new PersonFilter
  
  val alf = Person("Alf", 30, List(EmailAddress("alf.kristian@gmail.com")))
  val fredrik = Person("Fredrik", 33, List(EmailAddress("fredrik@vraalsen.no"), EmailAddress("fvr@knowit.no")))
  val johannes = Person("Johannes", 0, Nil)

  val persons = alf :: fredrik :: johannes :: Nil
  
  @Test 
  def testAll {
    // Pass in a function that returns all persons (always true)
    def f(p:Person): Boolean = {return true}
    println( personFilter.filterPersons(persons, f))
    
    assertEquals(persons, personFilter.filterPersons(persons, f))
  }
  
  @Test 
  def test_None {
    // Pass in a function that returns no persons (always false)
    def f(p:Person): Boolean = {return false}
    println(personFilter.filterPersons(persons, f))
    
    assertEquals(Nil, personFilter.filterPersons(persons, f))
  }
  
  @Test 
  def testEmptyList {
    // Use the two functions from above to test personFilter on empty lists (Nil)
    def f(p:Person): Boolean = {return false}
    def g(p:Person): Boolean = {return true}
    
    assertEquals(Nil, personFilter.filterPersons(List(), f))
    assertEquals(Nil, personFilter.filterPersons(List(), g))
  }

  @Test 
  def testOld {
    // Pass in a function that returns the persons over 18
    def g(p:Person): Boolean = {p.age > 18}
    assertEquals(List(alf, fredrik), personFilter.filterPersons(persons, g))
  }

  @Test
  def testYoung {
    // Pass in a function that returns the persons under 18
    def g(p:Person): Boolean = {p.age < 18}
    assertEquals(List(johannes), personFilter.filterPersons(persons, g))
  }

}