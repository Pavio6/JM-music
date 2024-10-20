package com.jlf.music.vo.singer;

import com.jlf.music.enums.BaseGender;
import lombok.Data;

@Data
public class AdminSingerResponseVo {
    private Integer id;
    private String name;
    private BaseGender gender;
    private String imagePath;
}
