package com.himewel.sink

import io.circe._
import io.circe.syntax._
import org.mongodb.scala.MongoClient
import scala.util.{ Failure, Success, Using}
import scala.concurrent.Await
import scala.concurrent.duration._
import org.mongodb.scala.bson.{BsonDocument, BsonObjectId}
import org.mongodb.scala.model.Filters._
import org.mongodb.scala.model.ReplaceOptions

class MongoSink() extends Sink[MongoDB] {
  def run[E: Encoder](value: E, config: Map[String,String]): Boolean =
    (config.get("connectionString"), config.get("database"), config.get("collection")) match {
      case (Some(connection), Some(databaseName), Some(collection)) => {
        Using(MongoClient(connection)) { mongoClient =>
          val database = mongoClient.getDatabase(databaseName)
          val document = BsonDocument(value.asJson.toString)

          val result = 
            database.getCollection(collection)
            .replaceOne(
              equal("id", document.getInt32("id").getValue), 
              document, 
              new ReplaceOptions().upsert(true)
            )

          Await.result(result.head(), 10.seconds)
        } match {
          case Failure(exception) => throw exception
          case Success(value) => true
        }
      }
      case _ => throw new IllegalArgumentException(config.toString)
    }
}
