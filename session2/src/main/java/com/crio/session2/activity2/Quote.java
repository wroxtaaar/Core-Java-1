package com.crio.session2.activity2;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {

  @JsonProperty("_id")
  private String id;
  private List<String> tags;
  private String author;
  private String content;
  
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public List<String> getTags() {
    return tags;
  }
  public void setTags(List<String> tags) {
    this.tags = tags;
  }
  public String getAuthor() {
    return author;
  }
  public void setAuthor(String author) {
    this.author = author;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  @Override
  public String toString() {
    return "Quote [author=" + author + ", content=" + content + ", id=" + id + ", tags=" + tags + "]";
  }
}
