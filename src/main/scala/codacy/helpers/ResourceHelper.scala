package codacy.helpers

import java.io.{File, InputStream}
import java.net.{URL, URLDecoder}
import java.nio.charset.{CodingErrorAction, StandardCharsets}
import java.nio.file.{Files, Path, StandardOpenOption}
import java.util.jar.JarFile

import scala.collection.JavaConversions.enumerationAsScalaIterator
import scala.io.{Codec, Source}
import scala.util.{Failure, Properties, Try}

object ResourceHelper {

  implicit val codec = Codec("UTF-8")
  codec.onMalformedInput(CodingErrorAction.REPLACE)
  codec.onUnmappableCharacter(CodingErrorAction.REPLACE)

  def getResourceContent(path: String): Try[List[String]] = {
    Option(getClass.getClassLoader.getResource(path)).map { url =>
      getResourceContent(url)
    }.getOrElse {
      Failure(new Exception("The path provided was not found"))
    }
  }

  private def getResourceContent(url: URL): Try[List[String]] = {
    getResourceStream(url).flatMap { stream =>
      val lines = Try {
        Source.fromInputStream(stream)
          .mkString
          .split(Properties.lineSeparator)
          .toList
      }

      Try(stream.close())

      lines
    }
  }

  def getResourceStream(path: String): Try[InputStream] = {
    Option(getClass.getClassLoader.getResource(path)).map { url =>
      getResourceStream(url)
    }.getOrElse {
      Failure(new Exception("The path provided was not found"))
    }
  }

  private def getResourceStream(url: URL): Try[InputStream] = {
    Some(url).map { file =>
      Try(file.openStream())
    }.getOrElse {
      Failure(new Exception("The URL provided is not valid"))
    }
  }

  def listResourceDirectory(path: String): Try[List[String]] = {
    Try(getClass.getClassLoader.getResources(path)).map(_.toList.flatMap {
      case directory if directory.getProtocol == "file" =>
        new File(directory.toURI).list().toList
          .map(_.stripPrefix(File.pathSeparator).stripPrefix(File.separator).trim())
          .filter(_.nonEmpty)

      case directory if directory.getProtocol == "jar" =>
        val jarPath = directory.getPath.substring(5, directory.getPath.indexOf("!"))
        val jar = new JarFile(URLDecoder.decode(jarPath, "UTF-8"))
        val files = enumerationAsScalaIterator(jar.entries).toList
          .collect {
            case file if !file.isDirectory && file.getName.startsWith(path) =>
              file.getName.stripPrefix(path).stripPrefix(File.pathSeparator).stripPrefix(File.separator)

            case file if file.isDirectory && file.getName.startsWith(path) =>
              file.getName.stripPrefix(path).stripPrefix(File.pathSeparator).stripPrefix(File.separator)
          }
        files.map(_.trim).filter(_.nonEmpty)

      case _ =>
        List.empty
    })
  }

  def writeFile(path: Path, content: String): Try[Path] = {
    Try(Files.write(
      path,
      content.getBytes(StandardCharsets.UTF_8),
      StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE
    ))
  }

}
