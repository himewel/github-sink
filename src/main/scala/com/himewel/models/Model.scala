package com.himewel.models

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

trait Model {
  def fromIsoInstant(s: String): LocalDateTime = {
    val isoPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
    LocalDateTime.parse(s, isoPattern)
  }

  def toIsoInstant(s: LocalDateTime): String = {
    val isoPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
    s.format(isoPattern)
  }
}
