package codacy.docker.api

import play.api.libs.json.JsValue

object Implicits {
  implicit def jsValueToParamValue(jsValue: JsValue): Parameter.Value = ParamValue(jsValue)
}
