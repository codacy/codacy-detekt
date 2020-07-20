package codacy.detekt

import io.gitlab.arturbosch.detekt.api.internal.YamlConfig

object YamlConfigFactory {

  def create(properties: java.util.Map[String, _]): YamlConfig = {
    val constructor = classOf[YamlConfig].getConstructors.head
    constructor.setAccessible(true)
    constructor.newInstance(properties, null).asInstanceOf[YamlConfig]
  }
}
