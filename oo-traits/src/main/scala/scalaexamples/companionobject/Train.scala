package scalaexamples.companionobject

// Define a primary constructor which takes a list of passengers (String) and an Option conductor also String
class Train(passengers1 : Array[String], conductor1 : Option[String] ) {
  val passengers : List[String] = List.fromArray(passengers1)
  val conductor : Option[String] = None
  
  
  //def this(conductor1 : Option[String], pass : Array[String]) = this(pass, conductor1)
  // You should also define an auxiliary constructor, which ignores the conductor
}

object Train {
  def apply(passengers1 : Array[String] ) = new Train(passengers1, None)
  def apply(pass1 : String, pass2 : String) = new Train(Array(pass1, pass2), None)
  def apply(conductor : Option[String], pass : String) = new Train(Array(pass), conductor)
  // make a method which makes Train(Array("Alf", "Fredrik")) compile

  // make a method which makes Train("Alf", "Fredrik") compile
  
  // make a method which makes Train(Some("Conductor"), "Alf", "Fredrik") compile
  
}