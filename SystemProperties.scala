import scala.sys.SystemProperties

object Demo
{
  def main(args: Array[String])
  {
    // Print ALL System Properties...
    val sysProps = new SystemProperties()
    for (sp <-sysProps) { println(s"${sp._1},  ${sp._2}") }

    println("=================================")

    // Obtain some individual System Properties and print them...
    var sysProp:Option[String] = sysProps.get("user.name")
    println("user.name = " + getOptionValue(sysProp))

    sysProp = sysProps.get("os.name")
    println("os.name = " + getOptionValue(sysProp))

    sysProp = sysProps.get("user.country")
    println("user.country = " + getOptionValue(sysProp))

    // Attempt to obtain a System Property (named "junk") that doesn't exist.
    // The Option.None value will be returned.
    sysProp = sysProps.get("junk")
    println("junk = " + getOptionValue(sysProp))
  }

  def getOptionValue(opt:Option[String]): String =
  {
    if (opt == None) "None"
    else opt.get.toString
  }
}
