package com.jlf.music.vo.comment;

import lombok.Data;

@Data
public class UserLikeCommentRequestVo {
    private Integer userId;
    private Integer commentId;
}
