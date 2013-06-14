package scalaexamples.companionobject

// Define a primary constructor which takes a list of passengers (String) and an Option conductor also String
class Train(passengers1 : Array[String] ) {
  val passengers : List[String] = List.fromArray(passengers1)
  // You should also define an auxiliary constructor, which ignores the conductor
}

object Train {
  def apply(passengers1 : Array[String] ) = new Train(passengers1)
  // make a method which makes Train(Array("Alf", "Fredrik")) compile

  // make a method which makes Train("Alf", "Fredrik") compile
  
  // make a method which makes Train(Some("Conductor"), "Alf", "Fredrik") compile
  
}