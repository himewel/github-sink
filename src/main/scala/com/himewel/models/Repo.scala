package com.himewel.models

import io.circe.{Decoder, Encoder, HCursor, Json}
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

case class Repo(
  id: Int,
  node_id: String,
  name: String,
  full_name: String,
  privateRepo: Boolean,
  owner: User,
  html_url: String,
  description: Option[String],
  fork: Boolean,
  url: String,
  forks_url: String,
  keys_url: String,
  collaborators_url: String,
  teams_url: String,
  hooks_url: String,
  issue_events_url: String,
  events_url: String,
  assignees_url: String,
  branches_url: String,
  tags_url: String,
  blobs_url: String,
  git_tags_url: String,
  git_refs_url: String,
  trees_url: String,
  statuses_url: String,
  languages_url: String,
  stargazers_url: String,
  contributors_url: String,
  subscribers_url: String,
  subscription_url: String,
  commits_url: String,
  git_commits_url: String,
  comments_url: String,
  issue_comment_url: String,
  contents_url: String,
  compare_url: String,
  merges_url: String,
  archive_url: String,
  downloads_url: String,
  issues_url: String,
  pulls_url: String,
  milestones_url: String,
  notifications_url: String,
  labels_url: String,
  releases_url: String,
  deployments_url: String,
  created_at: LocalDateTime,
  updated_at: LocalDateTime,
  pushed_at: LocalDateTime,
  git_url: String,
  ssh_url: String,
  clone_url: String,
  svn_url: String,
  homepage: String,
  size: Int,
  stargazers_count: Int,
  watchers_count: Int,
  language: Option[String],
  has_issues: Boolean,
  has_projects: Boolean,
  has_downloads: Boolean,
  has_wiki: Boolean,
  has_pages: Boolean,
  has_discussions: Boolean,
  forks_count: Int,
  mirror_url: Option[String],
  archived: Boolean,
  disabled: Boolean,
  open_issues_count: Int,
  license: Option[String],
  allow_forking: Boolean,
  is_template: Boolean,
  web_commit_signoff_required: Boolean,
  topics: List[String],
  visibility: String,
  forks: Int,
  open_issues: Int,
  watchers: Int,
  default_branch: String,
  temp_clone_token: Option[String],
  network_count: Int,
  subscribers_count: Int
) extends Model

object Repo extends Model {
  implicit val decoder: Decoder[Repo] = Decoder.instance { c =>
    for {
      id <- c.downField("id").as[Int]
      node_id <- c.downField("node_id").as[String]
      name <- c.downField("name").as[String]
      full_name <- c.downField("full_name").as[String]
      privateRepo <- c.downField("private").as[Boolean]
      owner <- c.downField("owner").as[User]
      html_url <- c.downField("html_url").as[String]
      description <- c.downField("description").as[Option[String]]
      fork <- c.downField("fork").as[Boolean]
      url <- c.downField("url").as[String]
      forks_url <- c.downField("forks_url").as[String]
      keys_url <- c.downField("keys_url").as[String]
      collaborators_url <- c.downField("collaborators_url").as[String]
      teams_url <- c.downField("teams_url").as[String]
      hooks_url <- c.downField("hooks_url").as[String]
      issue_events_url <- c.downField("issue_events_url").as[String]
      events_url <- c.downField("events_url").as[String]
      assignees_url <- c.downField("assignees_url").as[String]
      branches_url <- c.downField("branches_url").as[String]
      tags_url <- c.downField("tags_url").as[String]
      blobs_url <- c.downField("blobs_url").as[String]
      git_tags_url <- c.downField("git_tags_url").as[String]
      git_refs_url <- c.downField("git_refs_url").as[String]
      trees_url <- c.downField("trees_url").as[String]
      statuses_url <- c.downField("statuses_url").as[String]
      languages_url <- c.downField("languages_url").as[String]
      stargazers_url <- c.downField("stargazers_url").as[String]
      contributors_url <- c.downField("contributors_url").as[String]
      subscribers_url <- c.downField("subscribers_url").as[String]
      subscription_url <- c.downField("subscription_url").as[String]
      commits_url <- c.downField("commits_url").as[String]
      git_commits_url <- c.downField("git_commits_url").as[String]
      comments_url <- c.downField("comments_url").as[String]
      issue_comment_url <- c.downField("issue_comment_url").as[String]
      contents_url <- c.downField("contents_url").as[String]
      compare_url <- c.downField("compare_url").as[String]
      merges_url <- c.downField("merges_url").as[String]
      archive_url <- c.downField("archive_url").as[String]
      downloads_url <- c.downField("downloads_url").as[String]
      issues_url <- c.downField("issues_url").as[String]
      pulls_url <- c.downField("pulls_url").as[String]
      milestones_url <- c.downField("milestones_url").as[String]
      notifications_url <- c.downField("notifications_url").as[String]
      labels_url <- c.downField("labels_url").as[String]
      releases_url <- c.downField("releases_url").as[String]
      deployments_url <- c.downField("deployments_url").as[String]
      created_at <- c.downField("created_at").as[Option[String]]
      updated_at <- c.downField("updated_at").as[Option[String]]
      pushed_at <- c.downField("pushed_at").as[Option[String]]
      git_url <- c.downField("git_url").as[String]
      ssh_url <- c.downField("ssh_url").as[String]
      clone_url <- c.downField("clone_url").as[String]
      svn_url <- c.downField("svn_url").as[String]
      homepage <- c.downField("homepage").as[String]
      size <- c.downField("size").as[Int]
      stargazers_count <- c.downField("stargazers_count").as[Int]
      watchers_count <- c.downField("watchers_count").as[Int]
      language <- c.downField("language").as[Option[String]]
      has_issues <- c.downField("has_issues").as[Boolean]
      has_projects <- c.downField("has_projects").as[Boolean]
      has_downloads <- c.downField("has_downloads").as[Boolean]
      has_wiki <- c.downField("has_wiki").as[Boolean]
      has_pages <- c.downField("has_pages").as[Boolean]
      has_discussions <- c.downField("has_discussions").as[Boolean]
      forks_count <- c.downField("forks_count").as[Int]
      mirror_url <- c.downField("mirror_url").as[Option[String]]
      archived <- c.downField("archived").as[Boolean]
      disabled <- c.downField("disabled").as[Boolean]
      open_issues_count <- c.downField("open_issues_count").as[Int]
      license <- c.downField("license").as[Option[String]]
      allow_forking <- c.downField("allow_forking").as[Boolean]
      is_template <- c.downField("is_template").as[Boolean]
      web_commit_signoff_required <- c.downField("web_commit_signoff_required").as[Boolean]
      topics <- c.downField("topics").as[List[String]]
      visibility <- c.downField("visibility").as[String]
      forks <- c.downField("forks").as[Int]
      open_issues <- c.downField("open_issues").as[Int]
      watchers <- c.downField("watchers").as[Int]
      default_branch <- c.downField("default_branch").as[String]
      temp_clone_token <- c.downField("temp_clone_token").as[Option[String]]
      network_count <- c.downField("network_count").as[Int]
      subscribers_count <- c.downField("subscribers_count").as[Int]
    } yield Repo(
      id,
      node_id,
      name,
      full_name,
      privateRepo,
      owner,
      html_url,
      description,
      fork,
      url,
      forks_url,
      keys_url,
      collaborators_url,
      teams_url,
      hooks_url,
      issue_events_url,
      events_url,
      assignees_url,
      branches_url,
      tags_url,
      blobs_url,
      git_tags_url,
      git_refs_url,
      trees_url,
      statuses_url,
      languages_url,
      stargazers_url,
      contributors_url,
      subscribers_url,
      subscription_url,
      commits_url,
      git_commits_url,
      comments_url,
      issue_comment_url,
      contents_url,
      compare_url,
      merges_url,
      archive_url,
      downloads_url,
      issues_url,
      pulls_url,
      milestones_url,
      notifications_url,
      labels_url,
      releases_url,
      deployments_url,
      created_at.map(fromIsoInstant).get,
      updated_at.map(fromIsoInstant).get,
      pushed_at.map(fromIsoInstant).get,
      git_url,
      ssh_url,
      clone_url,
      svn_url,
      homepage,
      size,
      stargazers_count,
      watchers_count,
      language,
      has_issues,
      has_projects,
      has_downloads,
      has_wiki,
      has_pages,
      has_discussions,
      forks_count,
      mirror_url,
      archived,
      disabled,
      open_issues_count,
      license,
      allow_forking,
      is_template,
      web_commit_signoff_required,
      topics,
      visibility,
      forks,
      open_issues,
      watchers,
      default_branch,
      temp_clone_token,
      network_count,
      subscribers_count
    )
  }

  implicit val encoder: Encoder[Repo] = Encoder.instance( a =>
    Json.obj(
      "id" -> Json.fromInt(a.id),
      "node_id" -> Json.fromString(a.node_id),
      "name" -> Json.fromString(a.name),
      "full_name" -> Json.fromString(a.full_name),
      "private" -> Json.fromBoolean(a.privateRepo),
      "owner" -> Encoder[User].apply(a.owner),
      "html_url" -> Json.fromString(a.html_url),
      "description" -> a.description.map(Json.fromString).getOrElse(Json.Null),
      "fork" -> Json.fromBoolean(a.fork),
      "url" -> Json.fromString(a.url),
      "forks_url" -> Json.fromString(a.forks_url),
      "keys_url" -> Json.fromString(a.keys_url),
      "collaborators_url" -> Json.fromString(a.collaborators_url),
      "teams_url" -> Json.fromString(a.teams_url),
      "hooks_url" -> Json.fromString(a.hooks_url),
      "issue_events_url" -> Json.fromString(a.issue_events_url),
      "events_url" -> Json.fromString(a.events_url),
      "assignees_url" -> Json.fromString(a.assignees_url),
      "branches_url" -> Json.fromString(a.branches_url),
      "tags_url" -> Json.fromString(a.tags_url),
      "blobs_url" -> Json.fromString(a.blobs_url),
      "git_tags_url" -> Json.fromString(a.git_tags_url),
      "git_refs_url" -> Json.fromString(a.git_refs_url),
      "trees_url" -> Json.fromString(a.trees_url),
      "statuses_url" -> Json.fromString(a.statuses_url),
      "languages_url" -> Json.fromString(a.languages_url),
      "stargazers_url" -> Json.fromString(a.stargazers_url),
      "contributors_url" -> Json.fromString(a.contributors_url),
      "subscribers_url" -> Json.fromString(a.subscribers_url),
      "subscription_url" -> Json.fromString(a.subscription_url),
      "commits_url" -> Json.fromString(a.commits_url),
      "git_commits_url" -> Json.fromString(a.git_commits_url),
      "comments_url" -> Json.fromString(a.comments_url),
      "issue_comment_url" -> Json.fromString(a.issue_comment_url),
      "contents_url" -> Json.fromString(a.contents_url),
      "compare_url" -> Json.fromString(a.compare_url),
      "merges_url" -> Json.fromString(a.merges_url),
      "archive_url" -> Json.fromString(a.archive_url),
      "downloads_url" -> Json.fromString(a.downloads_url),
      "issues_url" -> Json.fromString(a.issues_url),
      "pulls_url" -> Json.fromString(a.pulls_url),
      "milestones_url" -> Json.fromString(a.milestones_url),
      "notifications_url" -> Json.fromString(a.notifications_url),
      "labels_url" -> Json.fromString(a.labels_url),
      "releases_url" -> Json.fromString(a.releases_url),
      "deployments_url" -> Json.fromString(a.deployments_url),
      "created_at" -> Json.fromString(toIsoInstant(a.created_at)),
      "updated_at" -> Json.fromString(toIsoInstant(a.updated_at)),
      "pushed_at" -> Json.fromString(toIsoInstant(a.pushed_at)),
      "git_url" -> Json.fromString(a.git_url),
      "ssh_url" -> Json.fromString(a.ssh_url),
      "clone_url" -> Json.fromString(a.clone_url),
      "svn_url" -> Json.fromString(a.svn_url),
      "homepage" -> Json.fromString(a.homepage),
      "size" -> Json.fromInt(a.size),
      "stargazers_count" -> Json.fromInt(a.stargazers_count),
      "watchers_count" -> Json.fromInt(a.watchers_count),
      "language" -> a.language.map(Json.fromString).getOrElse(Json.Null),
      "has_issues" -> Json.fromBoolean(a.has_issues),
      "has_projects" -> Json.fromBoolean(a.has_projects),
      "has_downloads" -> Json.fromBoolean(a.has_downloads),
      "has_wiki" -> Json.fromBoolean(a.has_wiki),
      "has_pages" -> Json.fromBoolean(a.has_pages),
      "has_discussions" -> Json.fromBoolean(a.has_discussions),
      "forks_count" -> Json.fromInt(a.forks_count),
      "mirror_url" -> a.mirror_url.map(Json.fromString).getOrElse(Json.Null),
      "archived" -> Json.fromBoolean(a.archived),
      "disabled" -> Json.fromBoolean(a.disabled),
      "open_issues_count" -> Json.fromInt(a.open_issues_count),
      "license" -> a.license.map(Json.fromString).getOrElse(Json.Null),
      "allow_forking" -> Json.fromBoolean(a.allow_forking),
      "is_template" -> Json.fromBoolean(a.is_template),
      "web_commit_signoff_required" -> Json.fromBoolean(a.web_commit_signoff_required),
      "topics" -> Json.fromValues(a.topics.map(Json.fromString)),
      "visibility" -> Json.fromString(a.visibility),
      "forks" -> Json.fromInt(a.forks),
      "open_issues" -> Json.fromInt(a.open_issues),
      "watchers" -> Json.fromInt(a.watchers),
      "default_branch" -> Json.fromString(a.default_branch),
      "temp_clone_token" -> a.temp_clone_token.map(Json.fromString).getOrElse(Json.Null),
      "network_count" -> Json.fromInt(a.network_count),
      "subscribers_count" -> Json.fromInt(a.subscribers_count),
    )
  )
}
