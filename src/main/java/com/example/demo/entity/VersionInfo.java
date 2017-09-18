package com.example.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Calendar;
import java.util.Date;

@ApiModel(value = "版本")
public class VersionInfo {
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Calendar getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Calendar publishDate) {
        this.publishDate = publishDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getChangelog() {
        return changelog;
    }

    public void setChangelog(String changelog) {
        this.changelog = changelog;
    }

    @ApiModelProperty(name = "version", value = "版本号")
    private String version;
    @ApiModelProperty(name = "publishDate", value = "发布日期")
    private Calendar publishDate;
    @ApiModelProperty(name = "author", value = "作者")
    private String author;
    @ApiModelProperty(name = "changelog", value = "变更日志")
    private String changelog;
}
