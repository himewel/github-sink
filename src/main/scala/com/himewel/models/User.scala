package com.himewel.models

import io.circe.{Decoder, Encoder, HCursor, Json}
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

case class User(
  login: String,
  id: Int,
  node_id: String,
  avatar_url: String,
  gravatar_id: String,
  url: String,
  html_url: String,
  followers_url: String,
  following_url: String,
  gists_url: String,
  starred_url: String,
  subscriptions_url: String,
  organizations_url: String,
  repos_url: String,
  events_url: String,
  received_events_url: String,
  userType: String,
  site_admin: Boolean,
  name: Option[String],
  company: Option[String],
  blog: Option[String],
  location: Option[String],
  email: Option[String],
  hireable: Option[Boolean],
  bio: Option[String],
  twitter_username: Option[String],
  public_repos: Option[Int],
  public_gists: Option[Int],
  followers: Option[Int],
  following: Option[Int],
  created_at: Option[LocalDateTime],
  updated_at: Option[LocalDateTime]
) extends Model

object User extends Model {
  implicit val decoder: Decoder[User] = Decoder.instance { c =>
    for {
      login <- c.downField("login").as[String]
      id <- c.downField("id").as[Int]
      node_id <- c.downField("node_id").as[String]
      avatar_url <- c.downField("avatar_url").as[String]
      gravatar_id <- c.downField("gravatar_id").as[String]
      url <- c.downField("url").as[String]
      html_url <- c.downField("html_url").as[String]
      followers_url <- c.downField("followers_url").as[String]
      following_url <- c.downField("following_url").as[String]
      gists_url <- c.downField("gists_url").as[String]
      starred_url <- c.downField("starred_url").as[String]
      subscriptions_url <- c.downField("subscriptions_url").as[String]
      organizations_url <- c.downField("organizations_url").as[String]
      repos_url <- c.downField("repos_url").as[String]
      events_url <- c.downField("events_url").as[String]
      received_events_url <- c.downField("received_events_url").as[String]
      userType <- c.downField("type").as[String]
      site_admin <- c.downField("site_admin").as[Boolean]
      name <- c.downField("name").as[Option[String]]
      company <- c.downField("company").as[Option[String]]
      blog <- c.downField("blog").as[Option[String]]
      location <- c.downField("location").as[Option[String]]
      email <- c.downField("email").as[Option[String]]
      hireable <- c.downField("hireable").as[Option[Boolean]]
      bio <- c.downField("bio").as[Option[String]]
      twitter_username <- c.downField("twitter_username").as[Option[String]]
      public_repos <- c.downField("public_repos").as[Option[Int]]
      public_gists <- c.downField("public_gists").as[Option[Int]]
      followers <- c.downField("followers").as[Option[Int]]
      following <- c.downField("following").as[Option[Int]]
      created_at <- c.downField("created_at").as[Option[String]]
      updated_at <- c.downField("updated_at").as[Option[String]]
    } yield User(
      login,
      id,
      node_id,
      avatar_url,
      gravatar_id,
      url,
      html_url,
      followers_url,
      following_url,
      gists_url,
      starred_url,
      subscriptions_url,
      organizations_url,
      repos_url,
      events_url,
      received_events_url,
      userType,
      site_admin,
      name,
      company,
      blog,
      location,
      email,
      hireable,
      bio,
      twitter_username,
      public_repos,
      public_gists,
      followers,
      following,
      created_at.map(fromIsoInstant),
      updated_at.map(fromIsoInstant)
    )
  }

  implicit val encoder: Encoder[User] = Encoder.instance { a =>
    Json.obj(
      "login" -> Json.fromString(a.login),
      "id" -> Json.fromInt(a.id),
      "node_id" -> Json.fromString(a.node_id),
      "avatar_url" -> Json.fromString(a.avatar_url),
      "gravatar_id" -> Json.fromString(a.gravatar_id),
      "url" -> Json.fromString(a.url),
      "html_url" -> Json.fromString(a.html_url),
      "followers_url" -> Json.fromString(a.followers_url),
      "following_url" -> Json.fromString(a.following_url),
      "gists_url" -> Json.fromString(a.gists_url),
      "starred_url" -> Json.fromString(a.starred_url),
      "subscriptions_url" -> Json.fromString(a.subscriptions_url),
      "organizations_url" -> Json.fromString(a.organizations_url),
      "repos_url" -> Json.fromString(a.repos_url),
      "events_url" -> Json.fromString(a.events_url),
      "received_events_url" -> Json.fromString(a.received_events_url),
      "type" -> Json.fromString(a.userType),
      "site_admin" -> Json.fromBoolean(a.site_admin),
      "name" -> a.name.map(Json.fromString).getOrElse(Json.Null),
      "company" -> a.company.map(Json.fromString).getOrElse(Json.Null),
      "blog" -> a.blog.map(Json.fromString).getOrElse(Json.Null),
      "location" -> a.location.map(Json.fromString).getOrElse(Json.Null),
      "email" -> a.email.map(Json.fromString).getOrElse(Json.Null),
      "hireable" -> a.hireable.map(Json.fromBoolean).getOrElse(Json.Null),
      "bio" -> a.bio.map(Json.fromString).getOrElse(Json.Null),
      "twitter_username" -> a.twitter_username.map(Json.fromString).getOrElse(Json.Null),
      "public_repos" -> a.public_repos.map(Json.fromInt).getOrElse(Json.Null),
      "public_gists" -> a.public_gists.map(Json.fromInt).getOrElse(Json.Null),
      "followers" -> a.followers.map(Json.fromInt).getOrElse(Json.Null),
      "following" -> a.following.map(Json.fromInt).getOrElse(Json.Null),
      "created_at" -> a.created_at.map(toIsoInstant).map(Json.fromString).getOrElse(Json.Null),
      "updated_at" -> a.updated_at.map(toIsoInstant).map(Json.fromString).getOrElse(Json.Null),
    )
  }
}
