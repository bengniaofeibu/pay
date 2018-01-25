package com.weichuxing.entity.WcxResponse;

import com.weichuxing.entity.WcxRequest.BaseWcxRequest;

import java.util.List;

public class UserAroundSignInfoResponse extends BaseWcxRequest {

    /** 标记结构 **/
    private Integer tags_num;

    /** 标记列表 **/
    private List<TagEntityResponse> tag_list;

    public Integer getTags_num() {
        return tags_num;
    }

    public void setTags_num(Integer tags_num) {
        this.tags_num = tags_num;
    }

    public List<TagEntityResponse> getTag_list() {
        return tag_list;
    }

    public void setTag_list(List<TagEntityResponse> tag_list) {
        this.tag_list = tag_list;
    }
}
